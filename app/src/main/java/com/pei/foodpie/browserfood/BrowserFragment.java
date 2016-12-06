package com.pei.foodpie.browserfood;


import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.pei.foodpie.R;
import com.pei.foodpie.base.BaseFragment;
import com.pei.foodpie.browserfood.delicious.DeliciousFragment;
import com.pei.foodpie.browserfood.evaluation.EvaluationFragment;
import com.pei.foodpie.browserfood.home.HomeFragment;
import com.pei.foodpie.browserfood.knowledge.KnowledgeFragment;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/22.
 */
public class BrowserFragment extends BaseFragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ArrayList<Fragment> fragments;

    public static BrowserFragment newInstance() {

        Bundle args = new Bundle();

        BrowserFragment fragment = new BrowserFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_browser;
    }

    @Override
    protected void initView(View view) {
        initViews();
    }

    @Override
    protected void initData() {

    }


    private void initViews() {
        tabLayout = bindView(R.id.tab_browser);
        viewPager = bindView(R.id.vp_browser);
        fragments = new ArrayList<>();
        fragments.add(HomeFragment.newInstance());
        fragments.add(EvaluationFragment.newInstance());
        fragments.add(new KnowledgeFragment());
        fragments.add(new DeliciousFragment());
        BrowserAdapter adapter = new BrowserAdapter(getChildFragmentManager());
        adapter.setFragments(fragments);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors(Color.BLACK, Color.RED);


    }
}
