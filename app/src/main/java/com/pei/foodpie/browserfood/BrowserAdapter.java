package com.pei.foodpie.browserfood;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/23.
 */

public class BrowserAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragments;
    private String[] titles = {"首页", "评测", "知识", "美食"};

    public void setFragments(ArrayList<Fragment> fragments) {
        this.fragments = fragments;
        notifyDataSetChanged();
    }

    public BrowserAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments == null ? null : fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments == null ? 0 : fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
