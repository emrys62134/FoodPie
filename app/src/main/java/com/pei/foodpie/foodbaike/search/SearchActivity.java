package com.pei.foodpie.foodbaike.search;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.pei.foodpie.R;
import com.pei.foodpie.base.BaseActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


/**
 * Created by dllo on 16/12/7.
 */
public class SearchActivity extends BaseActivity implements View.OnClickListener {


    private SearchBeforeFragment beforeFragment;
    private SearchAfterFragment afterFragment;
    private ImageView ivBack;
    private EditText etSearch;
    private ImageView ivClear;
    private ImageView ivSearch;
    private int length;
    private boolean isClick = false;
    private FragmentManager manager;
    private FragmentTransaction transaction;

    @Override
    protected int setLayout() {
        return R.layout.activity_search;
    }

    @Override
    protected void initView() {
        // 注册EventBus
        EventBus.getDefault().register(this);
        initViews();
        displayFirstSeeFragment();

    }

    @Override
    protected void initData() {

    }

    private void displayFirstSeeFragment() {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.frame_search, beforeFragment);
        transaction.commit();
    }

    private void initViews() {
        //
        beforeFragment = new SearchBeforeFragment();

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
                monitorTextChanged();
                break;
            case R.id.iv_clear_search:
                etSearch.getText().clear();
                break;
            case R.id.iv_search:
                searchData();
                break;
        }
    }

    private void searchData() {
        isClick = true;
        if (etSearch.getText().toString().isEmpty()){
            Toast.makeText(this, "输入不能为空哦", Toast.LENGTH_SHORT).show();
        }else{
            String data = etSearch.getText().toString();
            Bundle bundle = new Bundle();
            bundle.putString("data",data);
            afterFragment = new SearchAfterFragment();
            afterFragment.setArguments(bundle);
            // 点击换
            transaction.replace(R.id.frame_search,afterFragment);
            transaction.commit();

            // TODO 将输入到搜索框内的内容存入数据库

        }
    }

    private void monitorTextChanged() {
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                length = etSearch.getText().toString().length();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (isClick && etSearch.getText().toString().length() < length){

                    transaction.replace(R.id.frame_search,beforeFragment);
                    transaction.commit();
                    isClick = false;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (etSearch.getText().toString().length() > 0){
                    ivClear.setVisibility(View.VISIBLE);
                }else {
                    ivClear.setVisibility(View.GONE);
                }
            }
        });
    }

    // eventBus 接收第一个界面点击常用带过来的值
    @Subscribe (threadMode = ThreadMode.MAIN)
    public void eventSetText(EventText eventText){
        isClick = true;
        etSearch.setText(eventText.getText());
        etSearch.setSelection(eventText.getText().length());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
