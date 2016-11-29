package com.pei.foodpie.foodtext;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pei.foodpie.R;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dllo on 16/11/25.
 */

public class CommonAdapter extends BaseAdapter {

    private ArrayList<HashMap<String,Object>> list;
    private Context mContext;

    public CommonAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setList(ArrayList<HashMap<String, Object>> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int i) {
        return list == null ? null : list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null){
            view = LayoutInflater.from(mContext).inflate(R.layout.item_food_bai_ke,viewGroup,false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        Map<String,Object> map = list.get(i);
        Picasso.with(mContext).load((String) map.get("itemImage")).into(viewHolder.iv);
        viewHolder.tv.setText( map.get("itemText")+"");

        return view;
    }
    class ViewHolder{

        private ImageView iv;
        private TextView tv;

        public ViewHolder(View view) {
            iv = (ImageView) view.findViewById(R.id.icon_food_category);
            tv = (TextView) view.findViewById(R.id.title_food_category);
        }
    }
}
