package com.pei.foodpie.browserfood.delicious;

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
public class CommonActivity extends BaseActivity{

    private WebView webView;
    private WebViewClient webViewClient;
    private WebSettings webSettings;

    @Override
    protected int setLayout() {
        return R.layout.activity_common;
    }

    @Override
    protected void initView() {
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

    @Override
    protected void initData() {

    }
}
