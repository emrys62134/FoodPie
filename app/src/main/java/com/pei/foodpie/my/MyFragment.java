package com.pei.foodpie.my;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.pei.foodpie.activity.LoginActivity;
import com.pei.foodpie.activity.SettingActivity;
import com.pei.foodpie.R;
import com.pei.foodpie.base.BaseFragment;

/**
 * Created by dllo on 16/11/22.
 */
public class MyFragment extends BaseFragment implements View.OnClickListener {

    private ImageButton settingIB;
    private RelativeLayout rlPhoto;
    private RelativeLayout rlCollection;
    private RelativeLayout rlUpload;
    private RelativeLayout rlOrder;


    public static MyFragment newInstance() {

        Bundle args = new Bundle();

        MyFragment fragment = new MyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initView(View view) {
        initViews();
    }

    @Override
    protected void initData() {

    }
    @Override
    public void onClick(View view) {

        // 跳到设置界面
        Intent intentSetting = new Intent(getActivity(), SettingActivity.class);
        // 跳到登录界面
        Intent intentLogin = new Intent(getActivity(), LoginActivity.class);

        switch (view.getId()) {

            case R.id.setting_my:
                startActivity(intentSetting);
                break;

            case R.id.login_btn:
                startActivity(intentLogin);
                break;

            case R.id.rl_photo:
                startActivity(intentLogin);
                break;
            case R.id.rl_collection:
                startActivity(intentLogin);
                break;
            case R.id.rl_upload:
                startActivity(intentLogin);
                break;
            case R.id.rl_order:
                startActivity(intentLogin);
                break;
        }
    }


    private void initViews() {
        // 设置按钮
        settingIB = bindView(R.id.setting_my);
        // 登录按钮
        Button login = bindView(R.id.login_btn);

        // 相对布局: 我的照片 我的收藏 上传食物数据 我的订单
        rlPhoto = bindView(R.id.rl_photo);
        rlCollection = bindView(R.id.rl_collection);
        rlUpload = bindView(R.id.rl_upload);
        rlOrder = bindView(R.id.rl_order);

        rlPhoto.setOnClickListener(this);
        rlCollection.setOnClickListener(this);
        rlUpload.setOnClickListener(this);
        rlOrder.setOnClickListener(this);

        settingIB.setOnClickListener(this);
        login.setOnClickListener(this);
    }
}
