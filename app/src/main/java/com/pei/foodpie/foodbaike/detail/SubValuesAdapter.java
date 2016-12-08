package com.pei.foodpie.foodbaike.detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.pei.foodpie.R;
import com.pei.foodpie.foodbaike.FoodBaiKeBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/12/6.
 */

public class SubValuesAdapter extends BaseAdapter {

    private ArrayList<String> arrayList;
    private Context mContext;

    public SubValuesAdapter(Context mContext) {
        this.mContext = mContext;
    }

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
        ViewHolder viewHolder = null;
        if (view == null){
            view = LayoutInflater.from(mContext).inflate(R.layout.item_right_popup,null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.tv.setText(arrayList.get(i));
        return view;
    }
    class ViewHolder{
        private TextView tv;
        public ViewHolder(View view) {
            tv = (TextView) view.findViewById(R.id.tv_item_right_pop);
        }
    }
}
