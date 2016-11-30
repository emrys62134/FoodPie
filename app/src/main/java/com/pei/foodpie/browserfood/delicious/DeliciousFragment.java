package com.pei.foodpie.browserfood.delicious;


import android.content.Context;
import android.content.Intent;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.android.volley.VolleyError;
import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;

import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.pei.foodpie.R;
import com.pei.foodpie.base.BaseFragment;
import com.pei.foodpie.constant.Constant;
import com.pei.foodpie.volleysingleton.NetListener;
import com.pei.foodpie.volleysingleton.VolleySingleton;

import java.util.List;

/**
 * Created by dllo on 16/11/23.
 */
public class DeliciousFragment extends BaseFragment implements OnRefreshListener, OnLoadMoreListener {

    private ListView lv;
    private DeliciousAdapter adapter;
    private SwipeToLoadLayout swipeToLoadLayout;
    List<DeliciousBean.FeedsBeanDetail> bean;


    String headUrl = "http://food.boohee.com/fb/v1/feeds/category_feed?page=";
    String footerUrl = "&category=4&per=10";


    int i = 2;
    private String newUrl;

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


        autoRefresh();


    }

    private void getNetData() {
        VolleySingleton.MyRequest(Constant.DeliciousUrl, DeliciousBean.class, new NetListener<DeliciousBean>() {
            @Override
            public void successListener(final DeliciousBean response) {
                Log.d("DeliciousFragment", "请求成功");
                Log.d("DeliciousFragment", "response.getFeeds():" + response.getFeeds());
                bean = response.getFeeds();
                adapter.setBean(bean);

                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(getActivity(), CommonActivity.class);

                        intent.putExtra("data", response.getFeeds().get(i).getLink());

                        Log.d("DeliciousFragment", "i:" + i);
                        startActivity(intent);

                    }
                });
            }

            @Override
            public void errorListener(VolleyError error) {
                Log.d("DeliciousFragment", "请求失败");
            }
        });

    }


    @Override
    public void onRefresh() {
        swipeToLoadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeToLoadLayout.setRefreshing(false);

            }
        }, 2000);
    }

    @Override
    public void onLoadMore() {
        swipeToLoadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeToLoadLayout.setLoadingMore(false);
                newUrl = headUrl + i + footerUrl;

                getData();

                i++;
            }
        }, 2000);
    }

    private void autoRefresh() {
        swipeToLoadLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeToLoadLayout.setRefreshing(true);
            }
        });
    }

    private void getData() {
        VolleySingleton.MyRequest(newUrl, DeliciousBean.class, new NetListener<DeliciousBean>() {
            @Override
            public void successListener(final DeliciousBean response) {
                Log.d("拼接后URL", "response.getFeeds():" + response.getFeeds());
                adapter.addMore(response.getFeeds());

                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(getActivity(), CommonActivity.class);


                        List<DeliciousBean.FeedsBeanDetail> details = response.getFeeds();
                        if (bean == null) {
                            bean = details;
                        } else {
                            for (int j = 0; j < details.size(); j++) {
                                bean.add(details.get(j));
                            }
                        }
                        intent.putExtra("data", bean.get(i).getLink());
                        adapter.setBean(bean);


                        startActivity(intent);

                    }
                });

            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });
    }
}
