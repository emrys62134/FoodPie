package com.pei.foodpie.search;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pei.foodpie.R;

import java.util.ArrayList;

/**
 * Created by dllo on 16/12/12.
 */

public class SearchLvAdapter extends BaseAdapter {

    private ArrayList<String> arrayList;

    public void setArrayList(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return arrayList == null ? 0 : arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList == null ? null : arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Context mContext = viewGroup.getContext();
        SearchLvViewHolder searchLvViewHolder = null;
        if (view== null){
            view = LayoutInflater.from(mContext).inflate(R.layout.item_lv_search,viewGroup,false);
            searchLvViewHolder = new SearchLvViewHolder(view);
            view.setTag(searchLvViewHolder);
        }else{
            searchLvViewHolder = (SearchLvViewHolder) view.getTag();
        }
        searchLvViewHolder.tv.setText(arrayList.get(i));
        searchLvViewHolder.iv.setImageResource(R.mipmap.ic_history_empty);
        return view;
    }
    class SearchLvViewHolder {
            private TextView tv;
        private ImageView iv;
        public SearchLvViewHolder(View view) {
            tv = (TextView) view.findViewById(R.id.tv_item_lv_search);
            iv = (ImageView) view.findViewById(R.id.iv_empty);
        }
    }
}
