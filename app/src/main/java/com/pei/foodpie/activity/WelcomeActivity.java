package com.pei.foodpie.activity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.pei.foodpie.R;
import com.pei.foodpie.base.BaseActivity;

/**
 * Created by dllo on 16/12/7.
 */

public class WelcomeActivity extends BaseActivity {

    private ImageView iv;
    private TextView tv;
    private CountDownTimer timer;

    @Override
    protected int setLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initView() {
        initViews();
        timer.start();
    }

    private void initViews() {
        iv = bindView(R.id.iv_welcome);
        tv = bindView(R.id.tv_welcome);


        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
                timer.cancel();
            }
        });

        timer = new CountDownTimer(5000,1000) {
            @Override
            public void onTick(long l) {
                tv.setText(l / 1000 + "s");

            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        };

    }



    @Override
    protected void initData() {

    }
}
