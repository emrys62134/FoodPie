package com.pei.foodpie.activity;

import android.content.Intent;

import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;


import com.pei.foodpie.R;
import com.pei.foodpie.base.BaseActivity;


/**
 * Created by dllo on 16/12/1.
 */
public class BrowserHomeDetailActivity extends BaseActivity {

    private WebView webView;

    @Override
    protected int setLayout() {
        return R.layout.activity_home_detail;
    }

    @Override
    protected void initView() {
        initViews();
    }

    @Override
    protected void initData() {

    }

    private void initViews() {
        Intent intent = getIntent();
        String data = intent.getStringExtra("home");

        ImageView backIv = bindView(R.id.iv_back_detail_home);
        backIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        webView = bindView(R.id.web_view_home);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        WebViewClient webViewClient = new WebViewClient();
        webView.setWebViewClient(webViewClient);


        webView.loadUrl(data);
    }
}