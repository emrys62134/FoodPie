package com.pei.foodpie.activity;

import android.support.v7.widget.RecyclerView;

import com.pei.foodpie.R;
import com.pei.foodpie.base.BaseActivity;

/**
 * Created by dllo on 16/12/7.
 */
public class SearchActivity extends BaseActivity{

    private RecyclerView rv;


    @Override
    protected int setLayout() {
        return R.layout.activity_search;
    }

    @Override
    protected void initView() {
        rv = bindView(R.id.rv_search);
    }

    @Override
    protected void initData() {

    }
}
