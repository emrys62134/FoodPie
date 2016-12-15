package com.pei.foodpie.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pei.foodpie.R;
import com.pei.foodpie.base.BaseActivity;
import com.pei.foodpie.dbtool.CollectionBean;
import com.pei.foodpie.dbtool.DBTool;

import java.util.ArrayList;
import java.util.List;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;


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
    private ImageView ivCollect;
    private TextView tvCollect;
    private boolean flag = true;
    private List<CollectionBean> list;
    private String title;

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


        if (DBTool.getInstance().isSavaTitle(title)) {
            flag = false;
        }

        ShareSDK.initSDK(this);
        getNetData(url);
        if (DBTool.getInstance().isSava(url, title)) {
            ivCollect.setImageResource(R.mipmap.ic_news_keep_heighlight);
            tvCollect.setText("已收藏");
        } else {
            ivCollect.setImageResource(R.mipmap.ic_news_keep_default);
            tvCollect.setText("收藏");
        }
    }

    private void initViews() {
        Intent intent = getIntent();
        url = intent.getStringExtra("data");

        title = intent.getStringExtra("title");


        share = bindView(R.id.ll_share);
        back = bindView(R.id.back_detail_home_second);
        webView = (WebView) findViewById(R.id.web_delicious);
        LinearLayout ll = bindView(R.id.ll_collection_browser_detail);
        ivCollect = bindView(R.id.iv_collect_browser_detail);
        tvCollect = bindView(R.id.tv_collect_browser_detail);


        share.setOnClickListener(this);
        back.setOnClickListener(this);
        ll.setOnClickListener(this);


    }

    private void getNetData(String url) {


        webViewClient = new WebViewClient();
        webView.setWebViewClient(webViewClient);
        webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setCacheMode(webSettings.LOAD_CACHE_ELSE_NETWORK);
        webSettings.setPluginState(WebSettings.PluginState.ON);


        webView.loadUrl(url);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_share:
                showShare();
                break;
            case R.id.back_detail_home_second:
                finish();
                break;
            case R.id.ll_collection_browser_detail:


                if (flag) {
                    flag = !flag;

                    ivCollect.setImageResource(R.mipmap.ic_news_keep_heighlight);
                    tvCollect.setText("已收藏");
                    CollectionBean collectionBean = new CollectionBean();
                    list = new ArrayList<>();

                    collectionBean.setUrl(url);
                    collectionBean.setTitle(title);
                    list.add(collectionBean);

                    DBTool.getInstance().insertList(list);




                } else {
                    flag = !flag;
                    ivCollect.setImageResource(R.mipmap.ic_news_keep_default);
                    tvCollect.setText("收藏");
                    DBTool.getInstance().deleteBy(title);
                    DBTool.getInstance().deleteByUrl(url);



                }


                break;
        }
    }

    private void showShare() {

        ShareSDK.initSDK(this);
        OnekeyShare oks = new OnekeyShare();
//关闭sso授权
        oks.disableSSOWhenAuthorize();

// title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间等使用
        oks.setTitle("myFoodPie");
// titleUrl是标题的网络链接，QQ和QQ空间等使用
        oks.setTitleUrl("http://sharesdk.cn");
// text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
// imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
//oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
// url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
// comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
// site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
// siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

// 启动分享GUI
        oks.show(this);
    }


}
