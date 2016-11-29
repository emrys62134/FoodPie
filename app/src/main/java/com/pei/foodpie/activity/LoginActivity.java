package com.pei.foodpie.activity;

import android.view.View;
import android.widget.ImageView;

import com.pei.foodpie.R;
import com.pei.foodpie.base.BaseActivity;

/**
 * Created by dllo on 16/11/25.
 */
public class LoginActivity extends BaseActivity{
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
        ImageView reBack = bindView(R.id.back_login);
        reBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
