package com.pei.foodpie.foodtext;


import android.content.Context;
import android.view.View;
import android.widget.GridView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.pei.foodpie.R;
import com.pei.foodpie.base.BaseFragment;
import com.pei.foodpie.foodbaike.FoodBaiKeBean;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by dllo on 16/11/22.
 */
public class FoodFragment extends BaseFragment {

    private GridView gvFood;
    private GridView gvBrand;
    private GridView gvRestaurant;
    private Context mContext;
    private String url = "http://food.boohee.com/fb/v1/categories/list";
    private FoodBaiKeBean bean;
    private CommonAdapter adapter;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    protected int setLayout() {

        return R.layout.fragment_food;
    }

    @Override
    protected void initView(View view) {
        gvFood = bindView(R.id.gv_food);
        gvBrand = bindView(R.id.gv_brand);
        gvRestaurant = bindView(R.id.gv_restaurant);
        adapter = new CommonAdapter(mContext);


    }

    @Override
    protected void initData() {
        RequestQueue requestQueue = Volley.newRequestQueue(mContext);
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                bean = gson.fromJson(response, FoodBaiKeBean.class);

                ArrayList<HashMap<String,Object>> list = new ArrayList<>();
                for (int i = 0; i < bean.getGroup().size() ; i++) {
                    for (int j = 0; j < bean.getGroup().get(i).getCategories().size() ; j++) {
                        HashMap<String,Object> map = new HashMap<>();
                        map.put("itemImage",bean.getGroup().get(i).getCategories().get(j).getImage_url());
                        map.put("itemText",bean.getGroup().get(i).getCategories().get(j).getName());
                        list.add(map);
                    }
                    adapter.setList(list);
                    gvFood.setAdapter(adapter);
                    gvBrand.setAdapter(adapter);
                    gvRestaurant.setAdapter(adapter);

                }




            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
    }
}
