package com.pei.foodpie.search;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.pei.foodpie.R;
import com.pei.foodpie.base.BaseActivity;




/**
 * Created by dllo on 16/12/7.
 */
public class SearchActivity extends BaseActivity implements View.OnClickListener {



    private ImageView ivBack;
    private EditText etSearch;
    private ImageView ivClear;
    private ImageView ivSearch;

    private FragmentManager manager;
    private FragmentTransaction transaction;

    @Override
    protected int setLayout() {
        return R.layout.activity_search;
    }

    @Override
    protected void initView() {

        initViews();


    }

    @Override
    protected void initData() {

    }



    private void initViews() {

        // 返回按钮
        ivBack = bindView(R.id.iv_back_search);
        // 输入框
        etSearch = bindView(R.id.et_search);
        // 清除按钮
        ivClear = bindView(R.id.iv_clear_search);
        // 搜索按钮
        ivSearch = bindView(R.id.iv_search);

        ivBack.setOnClickListener(this);
        etSearch.setOnClickListener(this);
        ivClear.setOnClickListener(this);
        ivSearch.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back_search:
                finish();
                break;
            case R.id.et_search:

                break;
            case R.id.iv_clear_search:
                etSearch.getText().clear();
                break;
            case R.id.iv_search:

                break;
        }
    }


}


