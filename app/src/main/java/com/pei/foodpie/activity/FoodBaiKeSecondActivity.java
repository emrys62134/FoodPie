package com.pei.foodpie.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.pei.foodpie.R;
import com.pei.foodpie.base.BaseActivity;
import com.pei.foodpie.foodbaike.detail.DetailBean;

/**
 * Created by dllo on 16/12/9.
 */

public class FoodBaiKeSecondActivity extends BaseActivity {

    private ImageView back;
    private TextView title;
    private DetailBean bean;
    private int position;


    @Override
    protected int setLayout() {
        return R.layout.activity_home_detail_third;
    }



    @Override
    protected void initView() {
        initViews();
        getIntentData();



    }

    private void getIntentData() {
        Intent intent = getIntent();
        bean = intent.getParcelableExtra("detailBean");
        position = intent.getIntExtra("position",0);

        title.setText(bean.getFoods().get(position).getName());
    }

    private void initViews() {
        back = bindView(R.id.back_third);
        title = bindView(R.id.title_third);





        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    @Override
    protected void initData() {

    }
}
