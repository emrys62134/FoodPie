package com.pei.foodpie.browserfood.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pei.foodpie.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by dllo on 16/11/23.
 */

public class HomeAdapter extends RecyclerView.Adapter {


    private List<HomeBean.FeedsBeanDetail> beans;
    private Context mContext;
    public static final int FIRST_TYPE = 5;
    public static final int SECOND_TYPE = 6;

    private ArrayList<Integer> heights;

    public void setBeans(List<HomeBean.FeedsBeanDetail> beans) {
        this.beans = beans;
        heights = new ArrayList<>();
        for (int i = 0; i < beans.size(); i++) {
            Random random = new Random();
            int height = random.nextInt(500 + 200 - 1) + 200;
            heights.add(height);
        }
        notifyDataSetChanged();

    }

    public HomeAdapter(Context mContext) {
        this.mContext = mContext;
    }


    @Override
    public int getItemViewType(int position) {
            return beans.get(position).getContent_type();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case FIRST_TYPE:
                View view = LayoutInflater.from(mContext).inflate(R.layout.item_home_first, parent, false);
                viewHolder = new FirstViewHolder(view);
                break;
            case SECOND_TYPE:
                View view1 = LayoutInflater.from(mContext).inflate(R.layout.item_home_second, parent, false);
                viewHolder = new SecondViewHolder(view1);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        switch (type) {
            case FIRST_TYPE:
                FirstViewHolder firstViewHolder = (FirstViewHolder) holder;
                Picasso.with(mContext).load(beans.get(position).getCard_image())
                        .resize(200,300)
                        .into(firstViewHolder.bigPicF);
                Picasso.with(mContext).load(beans.get(position).getPublisher_avatar()).
                        resize(20,30).into(firstViewHolder.userIconF);
                firstViewHolder.titleF.setText(beans.get(position).getTitle());
                firstViewHolder.userNameF.setText(beans.get(position).getPublisher());
                firstViewHolder.countF.setText(beans.get(position).getLike_ct() + "");
                break;
            case SECOND_TYPE:
                SecondViewHolder secondViewHolder = (SecondViewHolder) holder;
                Picasso.with(mContext).load(beans.get(position).getCard_image()).fit().into(secondViewHolder.ivS);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return beans == null ? 0 : beans.size();
    }

    class FirstViewHolder extends RecyclerView.ViewHolder {
        private ImageView bigPicF;
        private ImageView userIconF;
        private TextView titleF;
        private TextView userNameF;
        private TextView countF;

        public FirstViewHolder(View itemView) {
            super(itemView);
            bigPicF = (ImageView) itemView.findViewById(R.id.big_pic_home_first);
            userIconF = (ImageView) itemView.findViewById(R.id.user_icon_home_first);
            titleF = (TextView) itemView.findViewById(R.id.title_home_first);
            userNameF = (TextView) itemView.findViewById(R.id.user_name_home_first);
            countF = (TextView) itemView.findViewById(R.id.count_home_first);
        }
    }

    class SecondViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivS;

        public SecondViewHolder(View itemView) {
            super(itemView);
            ivS = (ImageView) itemView.findViewById(R.id.iv_home_second);
        }
    }
}
