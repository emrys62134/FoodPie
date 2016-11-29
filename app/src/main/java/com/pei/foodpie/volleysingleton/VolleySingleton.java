package com.pei.foodpie.volleysingleton;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;

/**
 * Created by dllo on 16/11/28.
 */

public class VolleySingleton {

    private RequestQueue requestQueue;

    private static VolleySingleton volleySingleton
            = new VolleySingleton();

    private VolleySingleton() {
        getRequestQueue();
    }

    private RequestQueue getRequestQueue() {

        if (requestQueue == null) {
            synchronized (VolleySingleton.class) {
                if (requestQueue == null) {
                    requestQueue = Volley.newRequestQueue(MyApp.getContext());
                }
            }
        }
       return requestQueue;
    }


    public static VolleySingleton getInstance(){
        return volleySingleton;
    }

    /****************私有化的方法*************************/

    // 这是最基本请求的方式
    private <T> void baseRequest(Request<T> request){
        requestQueue.add(request);
    }

    // get请求
    private<T> void baseGsonRequest(String url, Class<T> tClass,
                                    final NetListener<T> listener){
        GsonRequest<T> gsonRequest = new GsonRequest<T>(Request.Method.GET, url,
                tClass, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.errorListener(error);
            }
        }, new Response.Listener<T>() {
            @Override
            public void onResponse(T response) {
                listener.successListener(response);
            }
        });
        requestQueue.add(gsonRequest);
    }
    // post 请求
    private <T> void baseGsonPostRequest(String url, Class<T> tClass, NetListener<T> listener,
                                         HashMap<String,String> map){
        GsonRequest<T> gsonRequest = new GsonRequest<T>(Request.Method.POST, url,
                tClass, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }, new Response.Listener<T>() {
            @Override
            public void onResponse(T response) {

            }
        },map);

        requestQueue.add(gsonRequest);
    }

    private void baseStringRequest(String url, final NetListener<String> listener){
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                listener.successListener(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.errorListener(error);
            }
        });
        requestQueue.add(stringRequest);
    }

    /******************对外提供的方法****************************/
    public static void MyRequest(String url,NetListener<String> listener){
        getInstance().baseStringRequest(url,listener);
    }
    public static <T> void MyRequest(String url,Class<T> mclass,NetListener<T>listener){
        getInstance().baseGsonRequest(url,mclass,listener);
    }
    public static <T> void MyRequest(String url,Class<T> mClass,NetListener<T> listener,HashMap<String,String> map){
        getInstance().baseGsonPostRequest(url,mClass,listener,map);
    }
}
