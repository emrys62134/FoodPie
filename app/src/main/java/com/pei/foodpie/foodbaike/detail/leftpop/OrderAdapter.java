package com.pei.foodpie.foodbaike.detail.leftpop;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pei.foodpie.R;
import com.pei.foodpie.utils.MyClickListener;
import com.pei.foodpie.volleysingleton.MyApp;

/**
 * Created by dllo on 16/12/6.
 */

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {

    private OrderBean bean;
    private MyClickListener myClickListener;

    public void setMyClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
        notifyDataSetChanged();
    }

    public void setBean(OrderBean bean) {
        this.bean = bean;
        notifyDataSetChanged();
    }

    @Override
    public OrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(MyApp.getContext()).inflate(R.layout.item_order_left,parent,false);
        OrderViewHolder viewHolder = new OrderViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(OrderViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myClickListener.onClickListener(position,bean.getTypes().get(position).getIndex());

            }
        });
        holder.tv.setText(bean.getTypes().get(position).getName());
    }

    @Override
    public int getItemCount() {
        return bean == null ? 0 : bean.getTypes().size();
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;
        public OrderViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv_item_left_pop);
        }
    }
}
