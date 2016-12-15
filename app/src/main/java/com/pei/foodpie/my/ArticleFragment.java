package com.pei.foodpie.my;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ListView;

import com.pei.foodpie.R;
import com.pei.foodpie.activity.BrowserDetailCommonActivity;
import com.pei.foodpie.base.BaseFragment;
import com.pei.foodpie.dbtool.CollectionBean;
import com.pei.foodpie.dbtool.DBTool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/12/13.
 */
public class ArticleFragment extends BaseFragment {

    private ListView listView;
    private List<CollectionBean> list = new ArrayList<>();
    private String url;
    private WebView webView;
    private WebViewClient webViewClient;
    private WebSettings webSettings;
    private String title;
    private ArticleAdapter adapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_article;
    }

    @Override
    protected void initView(View view) {
        listView = bindView(R.id.lv_my_collection);

        list = DBTool.getInstance().queryAll();
        Log.d("ArticleFragment", "list:" + list.size());
        for (int i = 0; i < list.size(); i++) {
            CollectionBean bean = new CollectionBean();
            title = bean.getTitle();
            url = bean.getUrl();
        }
        adapter = new ArticleAdapter();
        adapter.setList(list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), BrowserDetailCommonActivity.class);
                intent.putExtra("data", list.get(i).getUrl());
                intent.putExtra("title", "1");
                startActivity(intent);


            }
        });
        listView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                return true;
            }
        });

    }

    @Override
    protected void initData() {

    }
}
