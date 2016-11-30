package com.pei.foodpie.browserfood.delicious;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pei.foodpie.R;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 16/11/24.
 */

public class DeliciousAdapter extends BaseAdapter {
    private List<DeliciousBean.FeedsBeanDetail> bean;
    private static final int FIRST_TYPE = 0;
    private static final int SECOND_TYPE = 1;
    private static final int TYPE_COUNT = 5;


    public void setBean(List<DeliciousBean.FeedsBeanDetail> bean) {
        this.bean = bean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return bean == null ? 0 : bean.size();
    }

    @Override
    public Object getItem(int i) {
        return bean == null ? 0 : bean.get(i);
//        return bean.getFeeds().size();
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemViewType(int position) {
        int type = bean.get(position).getContent_type();
        if (type == 1) {
            return FIRST_TYPE;
        } else {
            return SECOND_TYPE;
        }

    }

    @Override
    public int getViewTypeCount() {
        return TYPE_COUNT;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        Context mContext = viewGroup.getContext();
        FirstViewHolder firstViewHolder = null;
        SecondViewHolder secondViewHolder = null;
        int type = getItemViewType(i);
        if (convertView == null) {
            switch (type) {

                case FIRST_TYPE:
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.item_knowledge_first, viewGroup, false);
                    firstViewHolder = new FirstViewHolder(convertView);
                    convertView.setTag(firstViewHolder);
                    break;

                case SECOND_TYPE:
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.item_knowledge_second, viewGroup, false);
                    secondViewHolder = new SecondViewHolder(convertView);
                    convertView.setTag(secondViewHolder);
                    break;
            }
        }else{
            switch(type){
                case FIRST_TYPE:
                    firstViewHolder = (FirstViewHolder) convertView.getTag();
                    break;
                case SECOND_TYPE:
                    secondViewHolder = (SecondViewHolder) convertView.getTag();
                    break;
            }
        }
        switch (type){
            case FIRST_TYPE:
                firstViewHolder.titleTv.setText(bean.get(i).getTitle());
                firstViewHolder.userTv.setText(bean.get(i).getSource());
                Picasso.with(mContext).load(bean.get(i).getImages().get(0)).into(firstViewHolder.pic);
                firstViewHolder.countTv.setText(bean.get(i).getTail());
                break;
            case SECOND_TYPE:
                secondViewHolder.titleTvS.setText(bean.get(i).getTitle());
                secondViewHolder.userTvS.setText(bean.get(i).getSource());
                secondViewHolder.countTvS.setText(bean.get(i).getItem_id()+"");
                Picasso.with(mContext).load(bean.get(i).getImages().get(0)).into(secondViewHolder.ivOneS);
                Picasso.with(mContext).load(bean.get(i).getImages().get(1)).into(secondViewHolder.ivTwoS);
                Picasso.with(mContext).load(bean.get(i).getImages().get(2)).into(secondViewHolder.ivThreeS);
                break;
        }
        return convertView;
    }

    public void addMore(List<DeliciousBean.FeedsBeanDetail> bean1) {
        bean.addAll(bean1);
        notifyDataSetChanged();
    }

    class FirstViewHolder {
        private TextView titleTv;
        private TextView userTv;
        private TextView countTv;
        private ImageView pic;
        public FirstViewHolder(View view) {
            titleTv = (TextView) view.findViewById(R.id.title_knowledge);
            userTv = (TextView) view.findViewById(R.id.user_knowledge);
            countTv = (TextView) view.findViewById(R.id.count_knowledge);
            pic = (ImageView) view.findViewById(R.id.pic_knowledge);
        }
    }

    class SecondViewHolder {
        private TextView titleTvS;
        private TextView userTvS;
        private TextView countTvS;
        private ImageView ivOneS;
        private ImageView ivTwoS;
        private ImageView ivThreeS;
        public SecondViewHolder(View view) {

            titleTvS = (TextView) view.findViewById(R.id.desc_knowledge_second);
            userTvS = (TextView) view.findViewById(R.id.user_knowledge_second);
            countTvS = (TextView) view.findViewById(R.id.count_knowledge_second);
            ivOneS = (ImageView) view.findViewById(R.id.iv_one_second_knowledge);
            ivTwoS = (ImageView) view.findViewById(R.id.iv_two_second_knowledge);
            ivThreeS = (ImageView) view.findViewById(R.id.iv_three_second_knowledge);
        }
    }
}
