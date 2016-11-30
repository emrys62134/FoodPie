package com.pei.foodpie.browserfood.evaluation;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.volley.VolleyError;
import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.pei.foodpie.R;
import com.pei.foodpie.base.BaseFragment;
import com.pei.foodpie.browserfood.delicious.CommonActivity;
import com.pei.foodpie.constant.Constant;
import com.pei.foodpie.volleysingleton.MyApp;
import com.pei.foodpie.volleysingleton.NetListener;
import com.pei.foodpie.volleysingleton.VolleySingleton;

import java.util.List;

/**
 * Created by dllo on 16/11/23.
 */
public class EvaluationFragment extends BaseFragment implements ClickListener, OnRefreshListener, OnLoadMoreListener {

    private RecyclerView rv;
    private EvaluationAdapter adapter;
    private SwipeToLoadLayout swipeToLoadLayout;
    private String headUrl = "http://food.boohee.com/fb/v1/feeds/category_feed?page=";
    private String footUrl = "&category=2&per=10";
    private String newUrl;
    private int i = 2;
    private List<EvaluationBean.FeedsBeanDetail> detail;


    public static EvaluationFragment newInstance() {

        Bundle args = new Bundle();
        EvaluationFragment fragment = new EvaluationFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_evaluation_browser;
    }

    @Override
    protected void initView(View view) {
        initViews();
    }

    @Override
    protected void initData() {
        getNetData();
        autoRefresh();
    }


    private void initViews() {
        swipeToLoadLayout = bindView(R.id.swipeToLoadLayout);
        swipeToLoadLayout.setOnRefreshListener(this);
        swipeToLoadLayout.setOnLoadMoreListener(this);

        rv = bindView(R.id.swipe_target);
        adapter = new EvaluationAdapter(MyApp.getContext());
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(MyApp.getContext()));
        adapter.setClickListener(this);
    }

    private void getNetData() {
        VolleySingleton.MyRequest(Constant.EvaluationUrl, EvaluationBean.class, new NetListener<EvaluationBean>() {
            @Override
            public void successListener(EvaluationBean response) {
                adapter.setBean(response.getFeeds());

            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });
    }

    @Override
    public void onClickListener(final int position) {
        VolleySingleton.MyRequest(Constant.EvaluationUrl, EvaluationBean.class, new NetListener<EvaluationBean>() {
            @Override
            public void successListener(EvaluationBean response) {
                adapter.addMore(response.getFeeds());
                Intent intent = new Intent(getActivity(), CommonActivity.class);
                intent.putExtra("data", response.getFeeds().get(position).getLink());
                startActivity(intent);


            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });
    }
//
//    @Override
//    public void onClick(final int position) {
//        VolleySingleton.MyRequest(newUrl, EvaluationBean.class, new NetListener<EvaluationBean>() {
//            @Override
//            public void successListener(EvaluationBean response) {
//
//                adapter.addMore(response.getFeeds());
//
//                Intent intent = new Intent(getActivity(), CommonActivity.class);
//                List<EvaluationBean.FeedsBeanDetail> data = response.getFeeds();
//                if (detail == null) {
//                    detail = data;
//                } else {
//                    for (int j = 0; j < data.size(); j++) {
//                        detail.add(data.get(j));
//                    }
//                }
//                intent.putExtra("data", detail.get(position).getLink());
//                adapter.setBean(detail);
//                startActivity(intent);
//            }
//
//            @Override
//            public void errorListener(VolleyError error) {
//
//            }
//        });
//    }

    @Override
    public void onRefresh() {
        swipeToLoadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeToLoadLayout.setRefreshing(false);
                newUrl = headUrl + 0 + footUrl;
                getData();

            }
        }, 2000);
    }

    private void getData() {
        VolleySingleton.MyRequest(newUrl, EvaluationBean.class, new NetListener<EvaluationBean>() {
            @Override
            public void successListener(EvaluationBean response) {
                adapter.setBean(response.getFeeds());
            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });
    }

    @Override
    public void onLoadMore() {
        swipeToLoadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeToLoadLayout.setLoadingMore(false);
                newUrl = headUrl + i + footUrl;
                getLoadData();
                i++;
            }
        }, 2000);
    }


    private void getLoadData() {
        VolleySingleton.MyRequest(newUrl, EvaluationBean.class, new NetListener<EvaluationBean>() {
            @Override
            public void successListener(EvaluationBean response) {
                adapter.addMore(response.getFeeds());

            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });
    }

    private void autoRefresh() {
        swipeToLoadLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeToLoadLayout.setRefreshing(true);
            }
        });
    }
}
