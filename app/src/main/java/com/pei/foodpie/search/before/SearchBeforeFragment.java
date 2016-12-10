package com.pei.foodpie.search.before;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.pei.foodpie.R;
import com.pei.foodpie.base.BaseFragment;

/**
 * Created by dllo on 16/12/10.
 */

public class SearchBeforeFragment extends BaseFragment {

    private RecyclerView recyclerView;

    @Override
    protected int setLayout() {
        return R.layout.fragment_search_before;
    }

    @Override
    protected void initView(View view) {
        recyclerView = bindView(R.id.rv_search_before);
    }

    @Override
    protected void initData() {

    }
}
