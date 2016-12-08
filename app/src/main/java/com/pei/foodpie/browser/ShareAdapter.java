package com.pei.foodpie.browser;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pei.foodpie.R;
import com.squareup.picasso.Picasso;


/**
 * Created by dllo on 16/12/8.
 */

public class ShareAdapter extends BaseAdapter {


    private ShareBean bean;
    private Context mContext;
    private Integer icons;
    private String iconNames;


    public ShareAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setMaps(ShareBean bean) {
        this.bean = bean;
        Log.d("ShareAdapter", "bean:" + bean);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return bean == null ? 0 : bean.getIcons().length;
    }

    @Override
    public Object getItem(int i) {
        return bean == null ? null : bean.getIcons()[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_share, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        icons = bean.getIcons()[i];
        iconNames = bean.getTitleNames()[i];

        viewHolder.iconName.setText(iconNames);
        Picasso.with(mContext).load(icons).into(viewHolder.icon);

        return view;
    }

    class ViewHolder {

        private ImageView icon;
        private TextView iconName;

        public ViewHolder(View view) {
            icon = (ImageView) view.findViewById(R.id.iv_share);
            iconName = (TextView) view.findViewById(R.id.tv_share);
        }
    }
}
