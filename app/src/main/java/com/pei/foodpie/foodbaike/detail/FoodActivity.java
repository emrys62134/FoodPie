package com.pei.foodpie.foodbaike.detail;

import android.content.Intent;

import com.pei.foodpie.R;
import com.pei.foodpie.base.BaseActivity;
import com.pei.foodpie.volleysingleton.VolleySingleton;

/**
 * Created by dllo on 16/12/2.
 */
public class FoodActivity extends BaseActivity {

    private String headerUrl = "http://food.boohee.com/fb/v1/foods?kind=";
    private String footUrl = "&value=";
    private String newUrl;

    @Override
    protected int setLayout() {
        return R.layout.activity_food;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        String category = intent.getStringExtra("foodName");
        int id = intent.getIntExtra("foodId",0);
        newUrl = headerUrl + category + footUrl + id;

    }

    @Override
    protected void initData() {
        VolleySingleton.MyRequest(newUrl,);
    }
}
