package com.pei.foodpie.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.pei.foodpie.R;
import com.pei.foodpie.base.BaseActivity;
import com.pei.foodpie.base.BaseFragment;
import com.pei.foodpie.foodbaike.searchafter.EventPost;
import com.pei.foodpie.foodbaike.searchafter.SearchAfterFragment;
import com.pei.foodpie.foodbaike.searchbefore.SearchBeforeFragment;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by dllo on 16/12/7.
 */
public class SearchActivity extends BaseActivity implements View.OnClickListener {


    private ImageView ivBack;
    private EditText etSearch;
    private ImageView ivSearch;
    private FrameLayout frameLayout;
    private String data;
    private BaseFragment currentFragment;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private ImageView ivClear;

    @Override
    protected int setLayout() {
        return R.layout.activity_search;
    }

    @Override
    protected void initView() {
        initViews();
        replaceSearchFrame(); // 将占位布局替换成搜索之前显示的布局
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_search:
                if (currentFragment instanceof SearchAfterFragment){
                    EventBus.getDefault().post(new EventPost
                            (etSearch.getText().toString()));
                }else {
                    SearchAfterFragment searchAfterFragment =
                            new SearchAfterFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("searchContent",etSearch.getText().toString());
                    searchAfterFragment.setArguments(bundle);
                    currentFragment = searchAfterFragment;
                    transaction.replace(R.id.frame_search,searchAfterFragment);
                    transaction.commit();

                }
                break;

            case R.id.iv_back_search:
                finish();
                break;
        }
    }


    private void initViews() {
//         返回按钮
        ivBack = bindView(R.id.iv_back_search);
        // 搜索按钮
        ivSearch = bindView(R.id.iv_search);
        // 输入框
        etSearch = bindView(R.id.et_search);
        // 清除按钮
        ivClear = bindView(R.id.iv_clear_search);
        // 占位布局
        frameLayout = bindView(R.id.frame_search);

        ivBack.setOnClickListener(this);
        ivSearch.setOnClickListener(this);


    }

    private void replaceSearchFrame() {
        SearchBeforeFragment searchBeforeFragment =
                new SearchBeforeFragment();
        currentFragment = searchBeforeFragment;
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.frame_search, searchBeforeFragment);
        transaction.commit();
    }

    // 接收fragment 传递来的数据
    public void setData(String data) {
        this.data = data;
        etSearch.setText(data);
    }
}
