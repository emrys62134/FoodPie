package com.pei.foodpie.activity;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;


import com.pei.foodpie.R;
import com.pei.foodpie.foodtext.FoodFragment;
import com.pei.foodpie.base.BaseActivity;
import com.pei.foodpie.browserfood.BrowserFragment;
import com.pei.foodpie.foodbaike.FoodBaiKeFragment;
import com.pei.foodpie.my.MyFragment;


public class MainActivity extends BaseActivity implements View.OnClickListener {

    private RadioButton rbFood;
    private RadioButton rbBrowser;
    private RadioButton rbMy;
    private FoodBaiKeFragment foodBaiKeFragment;
    private BrowserFragment browserFragment;
    private MyFragment myFragment;



    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        initViews();
    }

    @Override
    protected void initData() {

    }


    private void initViews() {

        rbFood = bindView(R.id.rb_food_bai_ke);
        rbBrowser = bindView(R.id.rb_browser);
        rbMy = (RadioButton) findViewById(R.id.rb_my);

        rbFood.setOnClickListener(this);
        rbBrowser.setOnClickListener(this);
        rbMy.setOnClickListener(this);


        foodBaiKeFragment = FoodBaiKeFragment.newInstance();
        browserFragment = BrowserFragment.newInstance();
        myFragment = MyFragment.newInstance();

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fl,foodBaiKeFragment);
        transaction.commit();
    }

    @Override
    public void onClick(View view) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        switch(view.getId()){
            case R.id.rb_food_bai_ke:
                transaction.replace(R.id.fl,foodBaiKeFragment);
                break;
            case R.id.rb_browser:
                transaction.replace(R.id.fl,browserFragment);
                break;
            case R.id.rb_my:
                transaction.replace(R.id.fl,myFragment);
                break;
        }
        transaction.commit();
    }
}


