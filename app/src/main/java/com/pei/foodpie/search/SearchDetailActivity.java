package com.pei.foodpie.search;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.pei.foodpie.R;
import com.pei.foodpie.base.BaseActivity;
import com.pei.foodpie.constant.Constant;
import com.pei.foodpie.foodbaike.detail.DetailAdapter;
import com.pei.foodpie.foodbaike.detail.DetailBean;
import com.pei.foodpie.utils.NetListener;
import com.pei.foodpie.volleysingleton.MyApp;
import com.pei.foodpie.volleysingleton.VolleySingleton;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.io.InputStream;

/**
 * Created by dllo on 16/12/12.
 */
public class SearchDetailActivity extends BaseActivity implements View.OnClickListener {

    private PullLoadMoreRecyclerView rv;
    private ImageView ivBack;
    private EditText etInput;
    private ImageView ivClear;
    private ImageView ivSearch;
    private SearchDetailAdapter adapter;
    private String newUrl;


    @Override
    protected int setLayout() {
        return R.layout.activity_search_detail;
    }

    @Override
    protected void initView() {
        ivBack = bindView(R.id.iv_back_search_detail);
        etInput = bindView(R.id.et_input_search_detail);
        ivClear = bindView(R.id.iv_clear_search_detail);
        ivSearch = bindView(R.id.iv_search_detail);

        ivBack.setOnClickListener(this);
        etInput.setOnClickListener(this);
        ivClear.setOnClickListener(this);
        ivSearch.setOnClickListener(this);

        Intent intent = getIntent();
        String data = intent.getStringExtra("data");
        int i = intent.getIntExtra("position", 0);


        newUrl = Constant.FOOD_SEARCH_AFTER_LV_FIRST + i + Constant.FOOD_SEARCH_AFTER_LV_SECOND + data;


        rv = bindView(R.id.rv_detail_food_detail);
        adapter = new SearchDetailAdapter(this);


        etInput.setText(data);


        rv.setAdapter(adapter);
        rv.setLinearLayout();
        rv.setPullRefreshEnable(false);
        rv.setOnPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener() {
            @Override
            public void onRefresh() {
                rv.setRefreshing(false);
            }

            @Override
            public void onLoadMore() {
                rv.setPullLoadMoreCompleted();
            }
        });

    }


    @Override
    protected void initData() {
        VolleySingleton.MyRequest(newUrl.toString(), SearchDetailBean.class, new NetListener<SearchDetailBean>() {
            @Override
            public void successListener(SearchDetailBean response) {
                Log.d("SearchDetailActivity", newUrl);
                Log.d("SearchDetailActivity", "response.getItems().size():" + response.getItems().size());
                for (SearchDetailBean.ItemsBean itemsBean : response.getItems()) {
                    Log.d("SearchDetailActivity", itemsBean.getName());
                }
                adapter.setBean(response);

            }

            @Override
            public void errorListener(VolleyError error) {
                Log.d("SearchDetailActivity", error.getMessage());
            }
        });


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back_search_detail:
                finish();
                break;
            case R.id.et_input_search_detail:

                break;
            case R.id.iv_clear_search_detail:
                break;
            case R.id.iv_search_detail:
                break;
        }
    }
}
