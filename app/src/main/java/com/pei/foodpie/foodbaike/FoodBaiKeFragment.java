package com.pei.foodpie.foodbaike;


import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import com.android.volley.VolleyError;
import com.pei.foodpie.R;
import com.pei.foodpie.base.BaseFragment;
import com.pei.foodpie.constant.Constant;
import com.pei.foodpie.volleysingleton.NetListener;
import com.pei.foodpie.volleysingleton.VolleySingleton;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by dllo on 16/11/22.
 */
public class FoodBaiKeFragment extends BaseFragment {

    private GridView gvFood;
    private GridView gvBrand;
    private GridView gvRestaurant;
    private FoodCategoryAdapter categoryAdapter;
    private FoodBrandAdapter brandAdapter;
    private FoodRestaurantAdapter restaurantAdapter;
    private ArrayList<HashMap<String, Object>> listItemFood = new ArrayList<HashMap<String, Object>>();
    private ArrayList<HashMap<String, Object>> listItemBrand = new ArrayList<HashMap<String, Object>>();
    private ArrayList<HashMap<String, Object>> listItemRestaurant = new ArrayList<HashMap<String, Object>>();


    public static FoodBaiKeFragment newInstance() {

        Bundle args = new Bundle();
        FoodBaiKeFragment fragment = new FoodBaiKeFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int setLayout() {
        return R.layout.fragment_food;
    }

    @Override
    protected void initView(View view) {
        initViews();
    }

    @Override
    protected void initData() {
        getNetData();
    }




    private void initViews() {
        gvFood = bindView(R.id.gv_food);
        gvBrand = bindView(R.id.gv_brand);
        gvRestaurant = bindView(R.id.gv_restaurant);
    }

    private void getNetData() {

        VolleySingleton.MyRequest(Constant.FoodBaiKeUrl, FoodBaiKeBean.class, new NetListener<FoodBaiKeBean>() {
            @Override
            public void successListener(FoodBaiKeBean response) {
                listItemFood = new ArrayList<HashMap<String, Object>>();
                for (int i = 0; i < response.getGroup().get(0).getCategories().size(); i++) {
                    HashMap<String, Object> mapFood = new HashMap<>();
                    mapFood.put("itemImageFood", response.getGroup().get(0).getCategories().get(i).getImage_url());
                    mapFood.put("itemTextFood", response.getGroup().get(0).getCategories().get(i).getName());
                    listItemFood.add(mapFood);
                }


                listItemBrand = new ArrayList<HashMap<String, Object>>();
                for (int i = 0; i < response.getGroup().get(1).getCategories().size(); i++) {
                    HashMap<String, Object> mapBrand = new HashMap<>();
                    mapBrand.put("itemImageBrand", response.getGroup().get(1).getCategories().get(i).getImage_url());
                    mapBrand.put("itemTextBrand", response.getGroup().get(1).getCategories().get(i).getName());
                    listItemBrand.add(mapBrand);
                }

                listItemRestaurant = new ArrayList<HashMap<String, Object>>();
                for (int i = 0; i < response.getGroup().get(2).getCategories().size(); i++) {
                    HashMap<String, Object> mapRestaurant = new HashMap<>();
                    mapRestaurant.put("itemImageRestaurant", response.getGroup().get(2).getCategories().get(i).getImage_url());
                    mapRestaurant.put("itemTextBrandRestaurant", response.getGroup().get(2).getCategories().get(i).getName());
                    listItemRestaurant.add(mapRestaurant);
                }

                // 分类
                categoryAdapter = new FoodCategoryAdapter(mContext);
                categoryAdapter.setList(listItemFood);

                // 品牌
                brandAdapter = new FoodBrandAdapter(mContext);
                brandAdapter.setList(listItemBrand);

                // 餐饮

                restaurantAdapter = new FoodRestaurantAdapter(mContext);
                restaurantAdapter.setList(listItemRestaurant);

                gvFood.setAdapter(categoryAdapter);
                gvBrand.setAdapter(brandAdapter);
                gvRestaurant.setAdapter(restaurantAdapter);

            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });

    }
}
