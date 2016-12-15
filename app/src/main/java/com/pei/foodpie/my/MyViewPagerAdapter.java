package com.pei.foodpie.my;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/12/13.
 */

public class MyViewPagerAdapter extends FragmentPagerAdapter {

   private ArrayList<Fragment> arrayList;
    private String[]titles = {"文章","食物"};

    public void setArrayList(ArrayList<Fragment> arrayList) {
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }

    public MyViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return arrayList == null ? null :arrayList.get(position);
    }

    @Override
    public int getCount() {
        return arrayList == null ? 0 :arrayList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
