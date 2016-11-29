package com.pei.foodpie.activity;



import android.view.View;
import android.widget.ImageView;

import com.pei.foodpie.R;
import com.pei.foodpie.base.BaseActivity;

/**
 * Created by dllo on 16/11/25.
 */
public class SettingActivity extends BaseActivity {

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

    }

    private void initViews() {
        ImageView reBack = bindView(R.id.back);
        reBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
