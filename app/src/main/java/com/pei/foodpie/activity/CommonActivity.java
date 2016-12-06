package com.pei.foodpie.activity;

import android.content.Intent;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.pei.foodpie.R;
import com.pei.foodpie.base.BaseActivity;


/**
 * Created by dllo on 16/11/29.
 */

/**
 * 评测 知识 美食 的二级页面
 */
public class CommonActivity extends BaseActivity {

    private WebView webView;
    private WebViewClient webViewClient;
    private WebSettings webSettings;

    @Override
    protected int setLayout() {
        return R.layout.activity_common;
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
        String url = intent.getStringExtra("data");

        webView = (WebView) findViewById(R.id.web_delicious);

        webViewClient = new WebViewClient();
        webView.setWebViewClient(webViewClient);
        webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setCacheMode(webSettings.LOAD_CACHE_ELSE_NETWORK);


        webView.loadUrl(url);
    }
}
