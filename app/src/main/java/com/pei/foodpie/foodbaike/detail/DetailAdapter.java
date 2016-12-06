package com.pei.foodpie.foodbaike.detail;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pei.foodpie.R;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dllo on 16/12/3.
 */

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.ViewHolder> {

    private Context mContext;
    private DetailBean bean;

    public void setBean(DetailBean bean) {
        this.bean = bean;

        notifyDataSetChanged();
    }

    public DetailAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void addMore(DetailBean detailBean) {
        bean.getFoods().addAll(detailBean.getFoods());
        notifyDataSetChanged();

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(mContext).inflate(R.layout.item_food_detail,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Picasso.with(mContext).load(bean.getFoods().get(position).getThumb_image_url()).into(holder.icon);
        holder.title.setText(bean.getFoods().get(position).getName());
        holder.content.setText(bean.getFoods().get(position).getCalory()+"千卡/100克");
        int num = bean.getFoods().get(position).getHealth_light();


        switch (num){
            case 1:
                holder.dot.setImageResource(R.mipmap.ic_food_light_green);
                break;
            case 2:
                holder.dot.setImageResource(R.mipmap.ic_food_light_yellow);
                break;
            case 3:
                holder.dot.setImageResource(R.mipmap.ic_food_light_red);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return bean == null ? 0 : bean.getFoods().size() ;
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView icon;
        private TextView title;
        private TextView content;
        private ImageView dot;
        public ViewHolder(View itemView) {
            super(itemView);

            icon = (ImageView) itemView.findViewById(R.id.icon_detail);
            title = (TextView) itemView.findViewById(R.id.title_detail);
            content = (TextView) itemView.findViewById(R.id.content_detail);
            dot = (CircleImageView) itemView.findViewById(R.id.dot_detail);
        }
    }

//    private DetailBean bean;
//    private Context mContext;
//
//    public DetailAdapter(Context mContext) {
//        this.mContext = mContext;
//    }
//
//    public void setBean(DetailBean bean) {
//        this.bean = bean;
//        notifyDataSetChanged();
//    }
//
//    @Override
//    public int getCount() {
//        return bean == null ? 0 : bean.getFoods().size();
//    }
//
//    @Override
//    public Object getItem(int i) {
//        return bean == null ? null : bean.getFoods().get(i);
//    }
//
//    @Override
//    public long getItemId(int i) {
//        return i;
//    }
//
//    @Override
//    public View getView(int i, View view, ViewGroup viewGroup) {
//        ViewHolder viewHolder = null;
//        if (view == null){
//            view = LayoutInflater.from(mContext).inflate(R.layout.item_food_detail,viewGroup,false);
//            viewHolder = new ViewHolder(view);
//            view.setTag(viewHolder);
//
//        }else{
//            viewHolder = (ViewHolder) view.getTag();
//        }
//        Picasso.with(mContext).load(bean.getFoods().get(i).getThumb_image_url()).into(viewHolder.icon);
//        viewHolder.title.setText(bean.getFoods().get(i).getName());
//        viewHolder.content.setText(bean.getFoods().get(i).getCalory()+"千卡/100克");
//        int num = bean.getFoods().get(i).getHealth_light();
//
//        switch (num){
//            case 1:
//                viewHolder.dot.setImageResource(R.mipmap.ic_food_light_green);
//                break;
//            case 2:
//                viewHolder.dot.setImageResource(R.mipmap.ic_food_light_yellow);
//                break;
//            case 3:
//                viewHolder.dot.setImageResource(R.mipmap.ic_food_light_red);
//                break;
//        }
//        return view;
//    }
//    class ViewHolder{
//
//        private ImageView icon;
//        private TextView title;
//        private TextView content;
//        private ImageView dot;
//        public ViewHolder(View view) {
//
//            icon = (ImageView) view.findViewById(R.id.icon_detail);
//            title = (TextView) view.findViewById(R.id.title_detail);
//            content = (TextView) view.findViewById(R.id.content_detail);
//            dot = (CircleImageView) view.findViewById(R.id.dot_detail);
//        }
//    }
}
