package com.pei.foodpie.my;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.pei.foodpie.R;
import com.pei.foodpie.base.BaseActivity;

import java.util.ArrayList;

/**
 * Created by dllo on 16/12/13.
 */
public class MyCollectionActivity extends BaseActivity implements View.OnClickListener {

    private ImageView ivBack;
    private ArrayList<Fragment> arrayList;

    @Override
    protected int setLayout() {
        return R.layout.activity_my_collection;
    }

    @Override
    protected void initView() {
        ivBack = bindView(R.id.back_my_collection);
        ivBack.setOnClickListener(this);
        arrayList = new ArrayList<>();
        arrayList.add(new ArticleFragment());
        arrayList.add(new FoodFragment());
        TabLayout tab = bindView(R.id.tab_my_collection);
        ViewPager vp = bindView(R.id.vp_my_collection);
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getSupportFragmentManager());
        adapter.setArrayList(arrayList);
        vp.setAdapter(adapter);
        tab.setupWithViewPager(vp);



    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_my_collection:

                finish();
                break;
        }
    }
}
