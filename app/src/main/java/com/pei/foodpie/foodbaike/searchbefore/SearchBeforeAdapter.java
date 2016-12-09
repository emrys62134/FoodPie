package com.pei.foodpie.foodbaike.searchbefore;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pei.foodpie.R;
import com.pei.foodpie.volleysingleton.MyApp;

/**
 * Created by dllo on 16/12/9.
 */

public class SearchBeforeAdapter extends RecyclerView.Adapter {

    private SearchBeforeBean bean;
    private OnSearchBeforeItemClickListener onSearchBeforeItemClickListener;

    public void setOnSearchBeforeItemClickListener(OnSearchBeforeItemClickListener onSearchBeforeItemClickListener) {
        this.onSearchBeforeItemClickListener = onSearchBeforeItemClickListener;
        notifyDataSetChanged();
    }

    public void setBean(SearchBeforeBean bean) {
        this.bean = bean;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(MyApp.getContext()).inflate(R.layout.item_search_before,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSearchBeforeItemClickListener.onItemSearchBeforeListener
                        (bean.getKeywords().get(position).toString());
                Log.d("SearchBeforeAdapter", bean.getKeywords().get(position).toString());
            }
        });
        myViewHolder.tv.setText(bean.getKeywords().get(position));
    }

    @Override
    public int getItemCount() {
        return bean == null ? 0 : bean.getKeywords().size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private  TextView tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv_item_search_before);
        }
    }
}
