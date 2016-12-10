package com.pei.foodpie.foodbaike;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import com.android.volley.VolleyError;
import com.pei.foodpie.R;
import com.pei.foodpie.foodbaike.search.SearchActivity;
import com.pei.foodpie.base.BaseFragment;
import com.pei.foodpie.constant.Constant;
import com.pei.foodpie.activity.FoodBaiKeDetailActivity;
import com.pei.foodpie.utils.NetListener;
import com.pei.foodpie.volleysingleton.VolleySingleton;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by dllo on 16/11/22.
 */
public class FoodBaiKeFragment extends BaseFragment implements View.OnClickListener {

    // 食物分类
    private GridView gvFood;
    private FoodCategoryAdapter categoryAdapter;
    // 热门品牌
    private GridView gvBrand;
    private FoodBrandAdapter brandAdapter;
    // 餐饮连锁
    private GridView gvRestaurant;
    private FoodRestaurantAdapter restaurantAdapter;

    private ArrayList<HashMap<String, Object>> listItemFood = new ArrayList<HashMap<String, Object>>();
    private ArrayList<HashMap<String, Object>> listItemBrand = new ArrayList<HashMap<String, Object>>();
    private ArrayList<HashMap<String, Object>> listItemRestaurant = new ArrayList<HashMap<String, Object>>();
    private FoodBaiKeBean bean;

    // 创建FoodBaiKeFragment实例
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
        onItemClickListener();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_search:
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);

                break;
        }
    }


    private void initViews() {
        Button searchBtn = bindView(R.id.btn_search);
        searchBtn.setOnClickListener(this);

        gvFood = bindView(R.id.gv_food);
        gvBrand = bindView(R.id.gv_brand);
        gvRestaurant = bindView(R.id.gv_restaurant);
    }

    private void getNetData() {

        VolleySingleton.MyRequest(Constant.FoodBaiKeUrl, FoodBaiKeBean.class, new NetListener<FoodBaiKeBean>() {
            @Override
            public void successListener(FoodBaiKeBean response) {

                bean = response;

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


    private void onItemClickListener() {
        gvFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (bean.getGroup().get(0).getKind().equals("group")) {
                    Intent intent = new Intent(getActivity(), FoodBaiKeDetailActivity.class);
                    intent.putExtra("object", bean);
                    intent.putExtra("category", bean.getGroup().get(0).getKind());
                    intent.putExtra("name", bean.getGroup().get(0).getCategories().get(i).getName());
                    intent.putExtra("id", bean.getGroup().get(0).getCategories().get(i).getId());
                    startActivity(intent);
                }

            }
        });

        gvBrand.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (bean.getGroup().get(1).getKind().equals("brand")) {
                    Intent intent = new Intent(getActivity(), FoodBaiKeDetailActivity.class);
                    intent.putExtra("category", bean.getGroup().get(1).getKind());
                    intent.putExtra("name", bean.getGroup().get(1).getCategories().get(i).getName());
                    intent.putExtra("id", bean.getGroup().get(1).getCategories().get(i).getId());
                    startActivity(intent);
                }
            }
        });
        gvRestaurant.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (bean.getGroup().get(2).getKind().equals("restaurant")) {
                    Intent intent = new Intent(getActivity(), FoodBaiKeDetailActivity.class);
                    intent.putExtra("category", bean.getGroup().get(2).getKind());
                    intent.putExtra("name", bean.getGroup().get(2).getCategories().get(i).getName());
                    intent.putExtra("id", bean.getGroup().get(2).getCategories().get(i).getId());
                    startActivity(intent);
                }
            }
        });
    }
}
