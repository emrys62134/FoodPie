package com.pei.foodpie.activity;

import android.content.Intent;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.pei.foodpie.R;
import com.pei.foodpie.base.BaseActivity;
import com.squareup.picasso.Picasso;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by dllo on 16/12/1.
 */
public class BrowserHomeDetailSecondActivity extends BaseActivity implements View.OnClickListener {


    @Override
    protected int setLayout() {
        return R.layout.activity_home_detail_second;
    }

    @Override
    protected void initView() {
        initViews();
    }

    @Override
    protected void initData() {

    }

    private void initViews() {
        ImageView back = bindView(R.id.back_detail_home_second);
        ImageView share = bindView(R.id.share_detail_home_second);

        back.setOnClickListener(this);
        share.setOnClickListener(this);


        Intent intent = getIntent();
        String bigPicGet = intent.getStringExtra("bigPic");
        String userIconGet = intent.getStringExtra("userIcon");
        String userNameGet = intent.getStringExtra("user");
        String titleGet = intent.getStringExtra("title");
        String likeGet = intent.getStringExtra("like");


        ImageView bigPic = bindView(R.id.big_pic_detail_home_second);
        ImageView userIcon = bindView(R.id.user_icon_detail_home_second);
        TextView user = bindView(R.id.user_name_detail_home_second);
        TextView title = bindView(R.id.title_detail_home_second);
        TextView like = bindView(R.id.like_detail_home_second);

        Picasso.with(this).load(bigPicGet).into(bigPic);
        Picasso.with(this).load(userIconGet).into(userIcon);
        user.setText(userNameGet);
        title.setText(titleGet);
        like.setText(likeGet);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_detail_home_second:
                finish();
                break;
            case R.id.share_detail_home_second:
                showShare();
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
