package com.pei.foodpie.browser.delicious;


import android.content.Intent;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.android.volley.VolleyError;
import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;

import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.pei.foodpie.R;
import com.pei.foodpie.activity.BrowserDetailCommonActivity;
import com.pei.foodpie.base.BaseFragment;
import com.pei.foodpie.constant.Constant;
import com.pei.foodpie.utils.NetListener;
import com.pei.foodpie.volleysingleton.VolleySingleton;


/**
 * Created by dllo on 16/11/23.
 */
public class DeliciousFragment extends BaseFragment implements OnRefreshListener, OnLoadMoreListener {

    private ListView lv;
    private DeliciousAdapter adapter;
    private SwipeToLoadLayout swipeToLoadLayout;
    DeliciousBean bean;
    int i = 2;  // 设置网址拼接的初始值
    private String newUrl; // 网址拼接后的网址

    @Override
    protected int setLayout() {
        return R.layout.fragment_delicious_browser;
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
        swipeToLoadLayout = bindView(R.id.swipeToLoadLayout);
        swipeToLoadLayout.setOnRefreshListener(this);
        swipeToLoadLayout.setOnLoadMoreListener(this);

        lv = bindView(R.id.swipe_target);
        adapter = new DeliciousAdapter();
        lv.setAdapter(adapter);


    }

    private void getNetData() {
        VolleySingleton.MyRequest(Constant.DELICIOUS_URL, DeliciousBean.class, new NetListener<DeliciousBean>() {
            @Override
            public void successListener(final DeliciousBean response) {
                adapter.setBean(response);
                bean = response;
            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), BrowserDetailCommonActivity.class);

                intent.putExtra("data", bean.getFeeds().get(i).getLink());
                if (bean.getFeeds().get(i).getTitle()!=null){
                    intent.putExtra("title",bean.getFeeds().get(i).getTitle());
                }

                startActivity(intent);

            }
        });

    }


    // 下拉刷新方法
    @Override
    public void onRefresh() {
        swipeToLoadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeToLoadLayout.setRefreshing(false);
                // 刷新没有拼接后的网址即可
                getRefreshData();
            }
        }, 2000);
    }

    // 上拉加载的方法
    @Override
    public void onLoadMore() {
        swipeToLoadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeToLoadLayout.setLoadingMore(false);
                newUrl = Constant.DELICIOUS_HEAD_URL + i + Constant.DELICIOUS_FOOT_URL;

                getLoadData(); // 上拉加载后的网络数据

                i++;
            }
        }, 2000);
    }


    private void getRefreshData() {
        VolleySingleton.MyRequest(Constant.DELICIOUS_URL, DeliciousBean.class, new NetListener<DeliciousBean>() {
            @Override
            public void successListener(DeliciousBean response) {
                adapter.addMore(response);
            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });
    }


    private void getLoadData() {
        VolleySingleton.MyRequest(newUrl, DeliciousBean.class, new NetListener<DeliciousBean>() {
            @Override
            public void successListener(final DeliciousBean response) {

                adapter.addMore(response); // 将新拼接网址请求下来的数据添加到原有的集合中

                bean.getFeeds().addAll(response.getFeeds()); // 将上拉加载后的每一个item数据加载到集合中

            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });
    }


}
