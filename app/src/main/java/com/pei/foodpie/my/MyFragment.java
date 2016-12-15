package com.pei.foodpie.my;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pei.foodpie.activity.LoginActivity;
import com.pei.foodpie.activity.SettingActivity;
import com.pei.foodpie.R;
import com.pei.foodpie.base.BaseFragment;
import com.pei.foodpie.volleysingleton.VolleySingleton;
import com.squareup.picasso.Picasso;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;

/**
 * Created by dllo on 16/11/22.
 */
public class MyFragment extends BaseFragment implements View.OnClickListener {

    private ImageButton settingIB;
    private RelativeLayout rlPhoto;
    private RelativeLayout rlCollection;
    private RelativeLayout rlUpload;
    private RelativeLayout rlOrder;
    private String name;
    private String icon;
    private TextView user;
    private ImageView iconMy;
    private Button login;
    private String status;


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

        status = "quiet";

        Platform qq = ShareSDK.getPlatform(QQ.NAME);
        try {

            PlatformDb platformDb = qq.getDb();
            name = platformDb.getUserName();
            icon = platformDb.getUserIcon();

            if (!TextUtils.isEmpty(name)) {
//                btnLogIn.setVisibility(View.GONE);
                user.setVisibility(View.VISIBLE);
                login.setVisibility(View.GONE);
                user.setText(name);
//                VolleySingleton.getInstance().getImage(icon, myIv);
                Picasso.with(getActivity()).load(icon).into(iconMy);
            }
        } catch (NullPointerException e) {

        }

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
//                startActivity(intentLogin);
                startActivityForResult(intentLogin, 1);
                break;

            case R.id.rl_photo:
                startActivity(intentLogin);
                break;
            case R.id.rl_collection:


                if (status.equals("quiet")){
                    Intent intent = new Intent(getActivity(), MyCollectionActivity.class);
                    startActivity(intent);
                }else {
                    startActivity(intentLogin);
                }



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
        login = bindView(R.id.login_btn);

        // 相对布局: 我的照片 我的收藏 上传食物数据 我的订单
        rlPhoto = bindView(R.id.rl_photo);
        rlCollection = bindView(R.id.rl_collection);
        rlUpload = bindView(R.id.rl_upload);
        rlOrder = bindView(R.id.rl_order);
        user = bindView(R.id.material_user);
        iconMy = bindView(R.id.icon_my);

        rlPhoto.setOnClickListener(this);
        rlCollection.setOnClickListener(this);
        rlUpload.setOnClickListener(this);
        rlOrder.setOnClickListener(this);

        settingIB.setOnClickListener(this);
        login.setOnClickListener(this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            //退出登录
//            btnLogIn.setVisibility(View.VISIBLE);
            user.setVisibility(View.GONE);
            login.setVisibility(View.GONE);
            iconMy.setImageResource(R.mipmap.my_icon);
            return;
        }


        if (requestCode == 1 && 0 == resultCode && data != null) {

            name = data.getStringExtra("name");
            icon = data.getStringExtra("icon");

            status = data.getStringExtra("status");

            Log.d("MyFragment", status);
//            btnLogIn.setVisibility(View.GONE);
            user.setVisibility(View.VISIBLE);
            login.setVisibility(View.GONE);
            user.setText(name);
//            VolleySingleton.getInstance().getImage(icon, iconMy);
            Picasso.with(getActivity()).load(icon).into(iconMy);

        }

    }
}
