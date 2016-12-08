package com.pei.foodpie.browser.home;


import android.content.Intent;
import android.os.Bundle;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;


import android.view.View;


import com.android.volley.VolleyError;
import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.pei.foodpie.R;
import com.pei.foodpie.activity.BrowserHomeDetailActivity;
import com.pei.foodpie.activity.BrowserHomeDetailSecondActivity;
import com.pei.foodpie.base.BaseFragment;
import com.pei.foodpie.utils.ClickListener;
import com.pei.foodpie.constant.Constant;
import com.pei.foodpie.utils.NetListener;
import com.pei.foodpie.volleysingleton.VolleySingleton;


/**
 * Created by dllo on 16/11/23.
 */
public class HomeFragment extends BaseFragment implements OnLoadMoreListener, OnRefreshListener, ClickListener {

    private RecyclerView rv;
    private HomeBean bean;
    private HomeAdapter adapter;
    private SwipeToLoadLayout swipeToLoadLayout;
    private int i = 2;
    private String newUrl;

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
        swipeToLoadLayout = bindView(R.id.swipe_load_layout);
        swipeToLoadLayout.setOnLoadMoreListener(this);
        swipeToLoadLayout.setOnRefreshListener(this);


        rv = bindView(R.id.swipe_target);
        adapter = new HomeAdapter();
        rv.setAdapter(adapter);
        rv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        adapter.setClickListener(this);
    }

    private void getNetData() {
        VolleySingleton.MyRequest(Constant.HOME_URL, HomeBean.class, new NetListener<HomeBean>() {
            @Override
            public void successListener(HomeBean response) {
                adapter.setBean(response);
                bean = response;


            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });
    }


    @Override
    public void onClickListener(int position) {


        if (bean.getFeeds().get(position).getContent_type() == 6) {
            Intent intent = new Intent(getActivity(), BrowserHomeDetailActivity.class);
            intent.putExtra("home", bean.getFeeds().get(position).getLink());
            startActivity(intent);
        } else {
            Intent intent = new Intent(getActivity(), BrowserHomeDetailSecondActivity.class);
            intent.putExtra("bigPic", bean.getFeeds().get(position).getCard_image());
            intent.putExtra("userIcon", bean.getFeeds().get(position).getPublisher_avatar());
            intent.putExtra("title", bean.getFeeds().get(position).getTitle());
            intent.putExtra("user", bean.getFeeds().get(position).getPublisher());
            intent.putExtra("like", bean.getFeeds().get(position).getLike_ct() + "");
            startActivity(intent);
        }


    }

    @Override
    public void onLoadMore() {
        swipeToLoadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeToLoadLayout.setLoadingMore(false);
                newUrl = Constant.HOME_HEAD_URL + i + Constant.HOME_FOOT_URL;
                getLoadData();
                i++;
            }
        }, 2000);
    }

    private void getLoadData() {
        VolleySingleton.MyRequest(newUrl, HomeBean.class, new NetListener<HomeBean>() {
            @Override
            public void successListener(HomeBean response) {
                adapter.addMore(response);
                bean.getFeeds().addAll(response.getFeeds());

            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });
    }

    @Override
    public void onRefresh() {
        swipeToLoadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeToLoadLayout.setRefreshing(false);
                getRefreshData();
            }
        }, 2000);
    }

    private void getRefreshData() {
        VolleySingleton.MyRequest(Constant.HOME_URL, HomeBean.class, new NetListener<HomeBean>() {
            @Override
            public void successListener(HomeBean response) {
                adapter.setBean(response);
            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });
    }
}
