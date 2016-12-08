package com.pei.foodpie.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.pei.foodpie.R;
import com.pei.foodpie.base.BaseActivity;
import com.pei.foodpie.browser.ShareAdapter;
import com.pei.foodpie.browser.ShareBean;
import com.pei.foodpie.volleysingleton.MyApp;

import me.shaohui.bottomdialog.BottomDialog;


/**
 * Created by dllo on 16/11/29.
 */

/**
 * 评测 知识 美食 的二级详情页面
 */
public class BrowserDetailCommonActivity extends BaseActivity implements View.OnClickListener {

    private WebView webView;
    private WebViewClient webViewClient;
    private WebSettings webSettings;
    private String url;
    private LinearLayout share;
    private ImageView back;
    private GridView gvShare;

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
        getNetData(url);
    }

    private void initViews() {
        Intent intent = getIntent();
        url = intent.getStringExtra("data");

        share = bindView(R.id.ll_share);
        back = bindView(R.id.back_detail_home_second);
        webView = (WebView) findViewById(R.id.web_delicious);

        share.setOnClickListener(this);
        back.setOnClickListener(this);


    }

    private void getNetData(String url) {
        webViewClient = new WebViewClient();
        webView.setWebViewClient(webViewClient);
        webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setCacheMode(webSettings.LOAD_CACHE_ELSE_NETWORK);


        webView.loadUrl(url);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.ll_share:
                BottomDialog.create(getSupportFragmentManager()).setViewListener(new BottomDialog.ViewListener() {
                    @Override
                    public void bindView(View v) {

                        // 初始化分享控件
                        initDialogViews(v);
                        // 给分享item设置监听
                        initDialogOnClickListener();



                        // TODO
                    }

                }).setLayoutRes(R.layout.share_layout).show();
                break;
            case R.id.back_detail_home_second:
                finish();
                break;
        }
    }

    private void initDialogViews(View v) {
        gvShare = (GridView) v.findViewById(R.id.gv_share);

        ShareBean shareBean = new ShareBean();
        Log.d("BrowserHomeDetailSecond", "shareBean.getIcons().length:" + shareBean.getIcons().length);
        ShareAdapter shareAdapter = new ShareAdapter(MyApp.getContext());
        shareAdapter.setMaps(shareBean);
        gvShare.setAdapter(shareAdapter);
    }

    private void initDialogOnClickListener() {
        gvShare.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }
}
