package com.pei.foodpie.browserfood.knowledge;


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
import com.pei.foodpie.browserfood.delicious.CommonActivity;
import com.pei.foodpie.constant.Constant;
import com.pei.foodpie.volleysingleton.MyApp;
import com.pei.foodpie.volleysingleton.NetListener;
import com.pei.foodpie.volleysingleton.VolleySingleton;

import java.util.List;

/**
 * Created by dllo on 16/11/23.
 */
public class KnowledgeFragment extends BaseFragment implements OnRefreshListener, OnLoadMoreListener {

    private SwipeToLoadLayout swipeToLoadLayout;
    private ListView lv;
    private KnowledgeAdapter adapter;

    private String headUrl ="http://food.boohee.com/fb/v1/feeds/category_feed?page=";
    private String footUrl = "&category=3&per=10";
    private int i = 2;
    private String newUrl;

    private List<KnowledgeBean.FeedsBeanDetail> detail;

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
        autoRefresh();
    }


    private void initViews() {
        swipeToLoadLayout = bindView(R.id.swipeToLoadLayout);
        swipeToLoadLayout.setOnRefreshListener(this);
        swipeToLoadLayout.setOnLoadMoreListener(this);

        lv = bindView(R.id.swipe_target);
        adapter = new KnowledgeAdapter(MyApp.getContext());
        lv.setAdapter(adapter);
    }

    private void getNetData() {
        VolleySingleton.MyRequest(Constant.KnowledgeUrl, KnowledgeBean.class, new NetListener<KnowledgeBean>() {
            @Override
            public void successListener(final KnowledgeBean response) {

                adapter.setBean(response.getFeeds());

                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(getActivity(), CommonActivity.class);
                        intent.putExtra("data",detail.get(i).getLink());
                        startActivity(intent);


                    }
                });
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
                newUrl = headUrl + 0 + footUrl;
                refreshData();
            }


        },2000);
    }

    private void refreshData() {
        VolleySingleton.MyRequest(newUrl, KnowledgeBean.class, new NetListener<KnowledgeBean>() {
            @Override
            public void successListener(KnowledgeBean response) {
                detail = response.getFeeds();
                adapter.setBean(detail);
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
                getData();
                i++;
            }
        },2000);
    }

    private void getData() {
        VolleySingleton.MyRequest(newUrl, KnowledgeBean.class, new NetListener<KnowledgeBean>() {
            @Override
            public void successListener(final KnowledgeBean response) {

                adapter.addMore(response.getFeeds());
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        Intent intent = new Intent (getActivity(),CommonActivity.class);
                       List <KnowledgeBean.FeedsBeanDetail> data = response.getFeeds();
                        if (detail == null){
                            detail = data;
                        }else{
                            for (int j = 0; j < data.size() ; j++) {
                                detail.add(data.get(j));

                            }
                        }
                        intent.putExtra("data",detail.get(i).getLink());
                        adapter.setBean(detail);
                        startActivity(intent);

                    }

                });


            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });
    }
    private void autoRefresh(){
        swipeToLoadLayout.post(new Runnable() {
            @Override
            public void run() {
               swipeToLoadLayout.setRefreshing(true);
            }
        });
    }
}
