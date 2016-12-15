package com.pei.foodpie.my;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.pei.foodpie.R;
import com.pei.foodpie.dbtool.CollectionBean;

import java.util.List;

/**
 * Created by dllo on 16/12/13.
 */

public class ArticleAdapter extends BaseAdapter {

   private  List<CollectionBean> list;

    public void setList(List<CollectionBean> list) {
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
        Context context = viewGroup.getContext();
        ArticleViewHolder articleViewHolder = null;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_article,viewGroup,false);
            articleViewHolder = new ArticleViewHolder(view);
            view.setTag(articleViewHolder);
        }else {
            articleViewHolder = (ArticleViewHolder) view.getTag();
        }
        articleViewHolder.title.setText(list.get(i).getTitle());
        return view;
    }
    class ArticleViewHolder{
       private  TextView title ;
        public ArticleViewHolder(View view) {
            title = (TextView) view.findViewById(R.id.title_article);
        }
    }
}
