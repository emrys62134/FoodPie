package com.pei.foodpie.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.pei.foodpie.R;
import com.pei.foodpie.base.BaseActivity;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;

/**
 * Created by dllo on 16/11/25.
 */

/**
 *      我的界面 :登录界面
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected int setLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        initViews();
    }

    @Override
    protected void initData() {

    }

    private void initViews() {
        ImageView ivQQ = bindView(R.id.qq_login);
        ivQQ.setOnClickListener(this);
        ImageView reBack = bindView(R.id.back_login);
        reBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.qq_login:
                show();
                break;
        }
    }

    private void show() {
        Platform qq = ShareSDK.getPlatform(QQ.NAME);
        qq.authorize();
        qq.setPlatformActionListener(new PlatformActionListener() {
            @Override
            public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                PlatformDb platformDb = platform.getDb();
                String name = platformDb.getUserName();
                Log.d("LoginActivity", name);
                String icon = platformDb.getUserIcon();
                Intent intent = new Intent();
                intent.putExtra("name", name);
                intent.putExtra("icon", icon);
                intent.putExtra("status","login");
                setResult(0, intent);

                Intent intentMe = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intentMe);

                finish();

            }

            @Override
            public void onError(Platform platform, int i, Throwable throwable) {

            }

            @Override
            public void onCancel(Platform platform, int i) {

            }
        });
    }
}
