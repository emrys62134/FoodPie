package com.pei.foodpie.browserfood.evaluation;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pei.foodpie.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 16/11/24.
 */

public class EvaluationAdapter extends RecyclerView.Adapter<EvaluationAdapter.EvaluationViewHolder> {

    private List<EvaluationBean.FeedsBeanDetail> bean;
    private Context mContext;
    private ClickListener clickListener;

    public EvaluationAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setBean(List<EvaluationBean.FeedsBeanDetail> bean) {
        this.bean = bean;
        notifyDataSetChanged();
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
        notifyDataSetChanged();
    }

    @Override
    public EvaluationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_evaluation,parent,false);
        EvaluationViewHolder evaluationViewHolder = new EvaluationViewHolder(view);
        return evaluationViewHolder;
    }

    @Override
    public void onBindViewHolder(EvaluationViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onClickListener(position);
//                clickListener.onClick(position);
            }
        });
        holder.tvCount.setText(bean.get(position).getTail());
        holder.tvTitle.setText(bean.get(position).getSource());
        holder.tvDesc.setText(bean.get(position).getTitle());
        Picasso.with(mContext).load(bean.get(position).getBackground()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return bean == null ? 0 :bean.size();
    }

    public void addMore(List<EvaluationBean.FeedsBeanDetail> bean1) {
        bean.addAll(bean1);
        notifyDataSetChanged();
    }

    public class EvaluationViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView tvTitle;
        private TextView tvDesc;
        private TextView tvCount;
        public EvaluationViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv_evaluation);
            tvTitle = (TextView) itemView.findViewById(R.id.title_evaluation);
            tvDesc = (TextView) itemView.findViewById(R.id.desc_evaluation);
            tvCount = (TextView) itemView.findViewById(R.id.count_evaluation);
        }
    }
}
