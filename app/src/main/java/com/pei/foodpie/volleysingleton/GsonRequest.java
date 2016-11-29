package com.pei.foodpie.volleysingleton;



import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dllo on 16/11/28.
 */

public class GsonRequest<T> extends Request<T> {

    private Gson mGson;
    private Class<T> mClass;
    private Response.Listener mListener;

    private HashMap<String, String> map;


    public GsonRequest(int method, String url, Response.ErrorListener listener) {
        super(method, url, listener);
    }


    // get请求
    public GsonRequest(int method,
                       String url,
                       Class<T> mClass,
                       Response.ErrorListener listener,
                       Response.Listener<T> mListener) {
        super(method, url, listener);
        this.mClass = mClass;
        this.mListener = mListener;
        mGson = new Gson();
    }

    public GsonRequest(int method,
                       String url,
                       Class<T> mClass,
                       Response.ErrorListener listener,
                       Response.Listener<T> mListener,
                       HashMap<String, String> map) {
        super(method, url, listener);
        this.mClass = mClass;
        this.mListener = mListener;
        this.map = map;
        mGson = new Gson();
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String data = new String(response.data,
                    HttpHeaderParser.parseCharset(response.headers));

            return Response.success(mGson.fromJson(data,mClass),
                    HttpHeaderParser.parseCacheHeaders(response));

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return Response.error(new ParseError(e));
        }

    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }

    // 分发事件
    @Override
    protected void deliverResponse(T response) {
        mListener.onResponse(response);
    }

    @Override
    public void deliverError(VolleyError error) {
        if (error instanceof NoConnectionError){
            Cache.Entry entry = this.getCacheEntry();
            Response<T> response = parseNetworkResponse(new NetworkResponse
                    (entry.data,entry.responseHeaders));
            deliverResponse(response.result);
        }
        super.deliverError(error);
    }
}
