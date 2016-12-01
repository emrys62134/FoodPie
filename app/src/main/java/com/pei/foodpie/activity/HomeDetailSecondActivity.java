package com.pei.foodpie.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.pei.foodpie.R;
import com.pei.foodpie.base.BaseActivity;
import com.squareup.picasso.Picasso;

/**
 * Created by dllo on 16/12/1.
 */
public class HomeDetailSecondActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected int setLayout() {
        return R.layout.activity_home_detail_second;
    }

    @Override
    protected void initView() {
        ImageView back = bindView(R.id.back_detail_home_second);
        back.setOnClickListener(this);
        ImageView share = bindView(R.id.share_detail_home_second);
        share.setOnClickListener(this);

        Intent intent = getIntent();
        String bigPic1 = intent.getStringExtra("bigPic");
        String userIcon1 = intent.getStringExtra("userIcon");
        String userName = intent.getStringExtra("user");
        String title1 = intent.getStringExtra("title");
        String like1 = intent.getStringExtra("like");



        ImageView bigPic = bindView(R.id.big_pic_detail_home_second);
        ImageView userIcon = bindView(R.id.user_icon_detail_home_second);
        TextView user = bindView(R.id.user_name_detail_home_second);
        TextView title = bindView(R.id.title_detail_home_second);
        TextView like = bindView(R.id.like_detail_home_second);

        Picasso.with(this).load(bigPic1).into(bigPic);
        Picasso.with(this).load(userIcon1).into(userIcon);
        user.setText(userName);
        title.setText(title1);
        like.setText(like1);



    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.back_detail_home_second:
                finish();
                break;
            case R.id.share_detail_home_second:

                break;
        }
    }
}
