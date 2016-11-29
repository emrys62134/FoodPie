package com.pei.foodpie.browserfood.home;


import android.os.Bundle;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;


import com.android.volley.VolleyError;
import com.pei.foodpie.R;
import com.pei.foodpie.base.BaseFragment;
import com.pei.foodpie.constant.Constant;
import com.pei.foodpie.volleysingleton.MyApp;
import com.pei.foodpie.volleysingleton.NetListener;
import com.pei.foodpie.volleysingleton.VolleySingleton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/11/23.
 */
public class HomeFragment extends BaseFragment {

    private RecyclerView rv;
    private List<HomeBean.FeedsBeanDetail> beanDetails;
    private HomeAdapter adapter;

    public static HomeFragment newInstance() {

        Bundle args = new Bundle();

        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int setLayout() {
        return R.layout.fragment_home_browser;
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
        rv = bindView(R.id.rv_home);
        adapter = new HomeAdapter(MyApp.getContext());
        beanDetails = new ArrayList<>();
        rv.setAdapter(adapter);
        rv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
    }

    private void getNetData() {
        VolleySingleton.MyRequest(Constant.HomeUrl, HomeBean.class, new NetListener<HomeBean>() {
            @Override
            public void successListener(HomeBean response) {
                beanDetails = response.getFeeds();
                adapter.setBeans(beanDetails);
            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });
    }
}
