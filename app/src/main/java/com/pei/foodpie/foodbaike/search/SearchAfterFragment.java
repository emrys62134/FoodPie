package com.pei.foodpie.foodbaike.search;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.pei.foodpie.R;
import com.pei.foodpie.base.BaseFragment;

/**
 * Created by dllo on 16/12/10.
 */
public class SearchAfterFragment extends BaseFragment{

    private PullToRefreshListView lv;
    private String str1;
    private String UTF;
    private EditText edtTitle;
    private boolean flag = true;
    private boolean isClick = false;
    private CheckBox cb;
    private LinearLayout ll;
    private PopupWindow popUpWindow;
    private RecyclerView rvLine;
    private long dissmissTime = -1;
    private ImageView upOrDown;
    private String nameStr;
    private String url;
    private ImageView animation;
    private int page = 1;
    private LinearLayout llUpDown;
    private TextView tvUpDown;
    private ImageView imgUpDown;
    private LinearLayout llCheckBox;
    private String urlToUp;
    private String urlToDown;
    private TextView tvPop;
    private String text;



    @Override
    protected int setLayout() {
        return R.layout.fragment_after_search;
    }

    @Override
    protected void initView(View view) {
            initViews();
    }

    private void initViews() {
        lv = bindView(R.id.lv_food_search_result);

        cb = bindView(R.id.cb_search);
        ll = bindView(R.id.ll_food_search_line);
        upOrDown = bindView(R.id.food_search_up_down);
        animation = bindView(R.id.img_food_search_animation);
        llUpDown = bindView(R.id.ll_food_search_down_up);
        llCheckBox = bindView(R.id.ll_food_search_down_up_check);

        tvUpDown = bindView(R.id.tv_food_search_up_down);
        imgUpDown = bindView(R.id.img_food_search_up_down);

        tvPop = bindView(R.id.tv_food_search_line_pop);
    }


    @Override
    protected void initData() {

    }
}
