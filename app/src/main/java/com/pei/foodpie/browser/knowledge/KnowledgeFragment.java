package com.pei.foodpie.browser.knowledge;


import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.VolleyError;

import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.pei.foodpie.R;
import com.pei.foodpie.base.BaseFragment;
import com.pei.foodpie.activity.BrowserDetailCommonActivity;
import com.pei.foodpie.constant.Constant;
import com.pei.foodpie.utils.NetListener;
import com.pei.foodpie.volleysingleton.VolleySingleton;

/**
 * Created by dllo on 16/11/23.
 */
public class KnowledgeFragment extends BaseFragment implements OnRefreshListener, OnLoadMoreListener {

    private SwipeToLoadLayout swipeToLoadLayout;
    private ListView lv;
    private KnowledgeAdapter adapter;
    private int i = 2;
    private String newUrl;

    private KnowledgeBean detail;

    @Override
    protected int setLayout() {
        return R.layout.fragment_delicious_browser;
    }

    @Override
    protected void initView(View view) {
        initViews();// 初始化控件
    }

    @Override
    protected void initData() {
        getNetData(); // 获取网络数据
//        autoRefresh();
    }


    private void initViews() {
        swipeToLoadLayout = bindView(R.id.swipeToLoadLayout);
        swipeToLoadLayout.setOnRefreshListener(this);
        swipeToLoadLayout.setOnLoadMoreListener(this);

        lv = bindView(R.id.swipe_target);
        adapter = new KnowledgeAdapter();
        lv.setAdapter(adapter);
    }

    private void getNetData() {
        VolleySingleton.MyRequest(Constant.KNOWLEDGE_URL, KnowledgeBean.class, new NetListener<KnowledgeBean>() {
            @Override
            public void successListener(final KnowledgeBean response) {

                adapter.setBean(response);
                detail = response;

            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), BrowserDetailCommonActivity.class);
                intent.putExtra("data", detail.getFeeds().get(i).getLink());
                startActivity(intent);


            }
        });
    }

    @Override
    public void onRefresh() {
        swipeToLoadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeToLoadLayout.setRefreshing(false);
                refreshData();
            }


        }, 2000);
    }

    @Override
    public void onLoadMore() {
        swipeToLoadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeToLoadLayout.setLoadingMore(false);
                newUrl = Constant.KNOWLEDGE_HEAD_URL + i + Constant.KNOWLEDGE_FOOT_URL;
                getData();
                i++;
            }
        }, 2000);
    }





    private void refreshData() {
        VolleySingleton.MyRequest(Constant.KNOWLEDGE_URL, KnowledgeBean.class, new NetListener<KnowledgeBean>() {
            @Override
            public void successListener(KnowledgeBean response) {

                adapter.setBean(response);
            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });
    }

    private void getData() {
        VolleySingleton.MyRequest(newUrl, KnowledgeBean.class, new NetListener<KnowledgeBean>() {
            @Override
            public void successListener(final KnowledgeBean response) {

                adapter.addMore(response);

                detail.getFeeds().addAll(response.getFeeds());


            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });
    }

//    private void autoRefresh() {
//        swipeToLoadLayout.post(new Runnable() {
//            @Override
//            public void run() {
//                swipeToLoadLayout.setRefreshing(true);
//                refreshData();
//            }
//        });
//    }
}
