package com.pei.foodpie.foodbaike.searchbefore;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.volley.VolleyError;
import com.pei.foodpie.R;
import com.pei.foodpie.activity.SearchActivity;
import com.pei.foodpie.base.BaseFragment;
import com.pei.foodpie.constant.Constant;
import com.pei.foodpie.utils.DividerItemDecoration;
import com.pei.foodpie.utils.NetListener;
import com.pei.foodpie.volleysingleton.VolleySingleton;

/**
 * Created by dllo on 16/12/8.
 */
public class SearchBeforeFragment extends BaseFragment implements OnSearchBeforeItemClickListener {

    private RecyclerView rv;
    private SearchBeforeAdapter searchBeforeAdapter;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext =context;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_before_search;
    }

    @Override
    protected void initView(View view) {
        initViews();


    }

    private void initViews() {
        rv = bindView(R.id.rv_search_before);
        searchBeforeAdapter = new SearchBeforeAdapter();
        rv.setAdapter(searchBeforeAdapter);
        rv.setLayoutManager(new GridLayoutManager(mContext,2));
        rv.addItemDecoration(new DividerItemDecoration(mContext,DividerItemDecoration.VERTICAL_LIST));
        searchBeforeAdapter.setOnSearchBeforeItemClickListener(this);
    }

    @Override
    protected void initData() {
        getNetData();
    }

    private void getNetData() {
        VolleySingleton.MyRequest(Constant.FOOD_SEARCH_BEFORE, SearchBeforeBean.class, new NetListener<SearchBeforeBean>() {
            @Override
            public void successListener(SearchBeforeBean response) {
                searchBeforeAdapter.setBean(response);
            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });
    }

    @Override
    public void onItemSearchBeforeListener(String data) {
        SearchActivity searchActivity = new SearchActivity();
        searchActivity.setData(data);
    }
}
