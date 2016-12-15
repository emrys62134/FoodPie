package com.pei.foodpie.search;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pei.foodpie.R;
import com.pei.foodpie.utils.MyClickListener;

/**
 * Created by dllo on 16/12/12.
 */

public class SearchRvAdapter extends RecyclerView.Adapter {

    private SearchBean searchBean;
    private MyClickListener myClickListener;

    public void setMyClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
        notifyDataSetChanged();
    }

    public void setSearchBean(SearchBean searchBean) {
        this.searchBean = searchBean;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_rv_search,parent,false);
        SearchRvViewHolder viewHolder = new SearchRvViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        SearchRvViewHolder searchRvViewHolder = (SearchRvViewHolder) holder;
        searchRvViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myClickListener.onClickListener(position,searchBean.getKeywords().get(position));
            }
        });
        searchRvViewHolder.tv.setText(searchBean.getKeywords().get(position));
    }

    @Override
    public int getItemCount() {
        return searchBean == null ? 0 : searchBean.getKeywords().size();
    }

    class SearchRvViewHolder extends RecyclerView.ViewHolder{
        private TextView tv;
        public SearchRvViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv_item_rv_search);
        }
    }
}
