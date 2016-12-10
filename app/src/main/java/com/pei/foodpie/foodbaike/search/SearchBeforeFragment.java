package com.pei.foodpie.foodbaike.search;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.pei.foodpie.R;
import com.pei.foodpie.base.BaseFragment;

/**
 * Created by dllo on 16/12/10.
 */
public class SearchBeforeFragment extends BaseFragment {

    private RecyclerView rv;
    private SearchBeforeAdapter beforeAdapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_before_search;
    }

    @Override
    protected void initView(View view) {
        rv = bindView(R.id.rv_search_before);
        beforeAdapter = new SearchBeforeAdapter();
    }

    @Override
    protected void initData() {

    }
}
