package com.pei.foodpie.activity;



import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.pei.foodpie.R;
import com.pei.foodpie.base.BaseActivity;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;

/**
 * Created by dllo on 16/11/25.
 */

/**
 * 我的界面 右上角 设置界面
 */
public class SettingActivity extends BaseActivity implements View.OnClickListener {

    private Button logout;
    private PlatformActionListener platformActionListener;

    @Override
    protected int setLayout() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initView() {
        initViews();
    }

    @Override
    protected void initData() {
        // TODO Auto-generated method stub
//输出所有授权信息
// TODO Auto-generated method stub
        platformActionListener = new PlatformActionListener() {
            @Override
            public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                // TODO Auto-generated method stub
                //输出所有授权信息
                platform.getDb().exportData();
            }

            @Override
            public void onError(Platform platform, int i, Throwable throwable) {
                // TODO Auto-generated method stub
                throwable.printStackTrace();
            }

            @Override
            public void onCancel(Platform platform, int i) {

            }
        };

    }

    private void initViews() {
        logout = bindView(R.id.logout);
        logout.setOnClickListener(this);

        ImageView reBack = bindView(R.id.back);
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
            case R.id.logout:
                Platform qq = ShareSDK.getPlatform(QQ.NAME);
                if (qq.isAuthValid()) {
                    qq.removeAccount(true);
                }
         //       qq.setPlatformActionListener(platformActionListener);
//authorize与showUser单独调用一个即可
         //       qq.authorize();//单独授权，OnComplete返回的hashmap是空的
          //      qq.showUser(null);//授权并获取用户信息
//isValid和removeAccount不开启线程，会直接返回。
//                qq.removeAccount(true);


                Intent intent = new Intent(SettingActivity.this,MainActivity.class);
                startActivity(intent);

                finish();
                break;
        }
    }
}
