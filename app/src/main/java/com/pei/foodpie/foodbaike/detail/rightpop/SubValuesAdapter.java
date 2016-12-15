package com.pei.foodpie.foodbaike.detail.rightpop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pei.foodpie.R;
import com.pei.foodpie.foodbaike.FoodBaiKeBean;
import com.pei.foodpie.utils.MyClickListener;
import com.pei.foodpie.utils.RightPopClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/12/6.
 */

public class SubValuesAdapter extends BaseAdapter {

    private List<String> arrayList;
    private Context mContext;
    private RightPopClickListener clickListener;

    public void setClickListener(RightPopClickListener clickListener) {
        this.clickListener = clickListener;
        notifyDataSetChanged();
    }

    public SubValuesAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setArrayList(List<String> arrayList) {
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
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_right_popup, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.tv.setText(arrayList.get(i));
        viewHolder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onMyClickListener(i,arrayList.get(i));
            }
        });

        return view;
    }

    class ViewHolder {
        private TextView tv;
        private LinearLayout ll;
        public ViewHolder(View view) {
            tv = (TextView) view.findViewById(R.id.tv_item_right_pop);
            ll = (LinearLayout) view.findViewById(R.id.ll_pop_right);
        }
    }
}
