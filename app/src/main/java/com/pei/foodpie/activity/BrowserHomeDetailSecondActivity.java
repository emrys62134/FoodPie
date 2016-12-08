package com.pei.foodpie.activity;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.pei.foodpie.R;
import com.pei.foodpie.base.BaseActivity;
import com.pei.foodpie.browser.ShareAdapter;
import com.pei.foodpie.browser.ShareBean;
import com.pei.foodpie.volleysingleton.MyApp;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.shaohui.bottomdialog.BottomDialog;

/**
 * Created by dllo on 16/12/1.
 */
public class BrowserHomeDetailSecondActivity extends BaseActivity implements View.OnClickListener {


    private GridView gvShare;


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
