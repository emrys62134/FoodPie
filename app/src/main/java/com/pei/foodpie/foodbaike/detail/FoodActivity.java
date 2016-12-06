package com.pei.foodpie.foodbaike.detail;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.pei.foodpie.utils.DividerItemDecoration;
import com.pei.foodpie.R;
import com.pei.foodpie.base.BaseActivity;

import com.pei.foodpie.utils.MyClickListener;
import com.pei.foodpie.volleysingleton.NetListener;
import com.pei.foodpie.volleysingleton.VolleySingleton;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.util.ArrayList;

/**
 * Created by dllo on 16/12/2.
 */
public class FoodActivity extends BaseActivity implements View.OnClickListener, MyClickListener {

    private String headerUrl = "http://food.boohee.com/fb/v1/foods?kind=";
    private String footUrl = "&value=";
    private String newUrl;
    private String orderByUrl = "&order_by=";
    private String detailPageUrl = "&order_by=1&page=";
    private String endUrl = "&order_asc=0";

    private String subValueUrl = "(&sub_value=";
    private String subValueEndUrl = ")&order_by=1&page=";

    //            http://food.boohee.com/fb/v1/foods?kind=group&value=1(&sub_value=13)&order_by=1&page=1&order_asc=0
    private DetailAdapter adapter;
    private Button order;
    private String orderUrl = "http://food.boohee.com/fb/v1/foods/sort_types";
    private OrderAdapter orderAdapter;
    private TextView tvAll;
    private ImageView ivRight;
    private String category;
    private int id;
    private int subId;


    private PopupWindow popupWindow;
    private ImageView ivOrder;
    private boolean isClick = false;
    private PullLoadMoreRecyclerView rv;
    private int i = 1;
    private String compositionUrl;
    private String rightPopListUrl;
    private SubValuesAdapter subValuesAdapter;
    private String subName;
    private int subCount;
    private ArrayList<String> arrayList;


    @Override
    protected int setLayout() {
        return R.layout.activity_food;
    }

    @Override
    protected void initView() {
        initViews();

    }

    private void initViews() {

        rv = bindView(R.id.rv_detail_food);
        order = bindView(R.id.order_detail);
        ImageView previous = bindView(R.id.back_detail_food);
        order.setOnClickListener(this);
        previous.setOnClickListener(this);
        ivOrder = bindView(R.id.iv_order_arrow_down);

        tvAll = bindView(R.id.tv_all_right_pop);
        ivRight = bindView(R.id.iv_all_right_pop);

        Intent intent = getIntent();
        category = intent.getStringExtra("category");
        String name = intent.getStringExtra("name");
        subId = intent.getIntExtra("subId", 0);
        id = intent.getIntExtra("id", 0);
        subName = intent.getStringExtra("subName");


        subCount = intent.getIntExtra("subCount",0);
        arrayList = new ArrayList<>();
        for (int j = 0; j < subCount ; j++) {
            arrayList.add(subName);
        }






        TextView title = bindView(R.id.title_detail_food);
        title.setText(name);


        newUrl = headerUrl + category + footUrl + id;
        adapter = new DetailAdapter(this);
        rv.setAdapter(adapter);
        rv.setLinearLayout();


        rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));

        rv.setPullRefreshEnable(false);

        rv.setOnPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener() {


            @Override
            public void onRefresh() {
                rv.setRefreshing(false);


            }

            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        compositionUrl = headerUrl + category + footUrl + id + detailPageUrl + (i + 1) + endUrl;

                        getDetailLoadData();
                        i++;
                        rv.setPullLoadMoreCompleted();
                    }
                }, 2000);
            }
        });

        if (category.equals("group")) {
            tvAll.setText("全部");
            ivRight.setImageResource(R.mipmap.ic_food_arrow_ordering);
            tvAll.setOnClickListener(this);
        }


    }

    private void getDetailLoadData() {
        VolleySingleton.MyRequest(compositionUrl, DetailBean.class, new NetListener<DetailBean>() {
            @Override
            public void successListener(DetailBean response) {

                adapter.addMore(response);
            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });
    }

    @Override
    protected void initData() {
        VolleySingleton.MyRequest(newUrl, DetailBean.class, new NetListener<DetailBean>() {
            @Override
            public void successListener(DetailBean response) {
                adapter.setBean(response);

            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.order_detail:
                initLeftPopup();
                initLeftArrow();
                if (!popupWindow.isShowing()) {
                    ivOrder.setImageResource(R.mipmap.ic_food_arrow_ordering);
                }
                break;
            case R.id.tv_all_right_pop:
                initRightPop();
                break;
            case R.id.back_detail_food:
                finish();
                break;
        }
    }

    private void initRightPop() {
        PopupWindow rightPop = new PopupWindow(this);
        rightPop.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        rightPop.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        View view = LayoutInflater.from(this).inflate(R.layout.right_pop_food_detail, null);

        //TODO 食物百科 右侧popup 未获取弹出name

        ListView rightList = (ListView) view.findViewById(R.id.lv_pop_right_food_detail);
        subValuesAdapter = new SubValuesAdapter(this);
        subValuesAdapter.setArrayList(arrayList);
        rightPop.setContentView(view);
        rightPop.setOutsideTouchable(true);
        rightList.setAdapter(subValuesAdapter);

//        rightPopListUrl = headerUrl + category + footUrl + id + subValueUrl + subId + subValueEndUrl + endUrl;


        rightPop.showAsDropDown(tvAll);

    }



    private void initLeftArrow() {
        if (!isClick) {
            ivOrder.setImageResource(R.mipmap.ic_arrowup);
            isClick = true;
        } else if (isClick) {
            ivOrder.setImageResource(R.mipmap.ic_food_arrow_ordering);
            isClick = false;
        }

    }


    private void initLeftPopup() {
        popupWindow = new PopupWindow(this);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        View view = LayoutInflater.from(this).inflate(R.layout.item_popup, null);
        RecyclerView rv = (RecyclerView) view.findViewById(R.id.left_pop_rv);
        orderAdapter = new OrderAdapter();
        getOrderNetData();
        rv.setAdapter(orderAdapter);
        rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        orderAdapter.setMyClickListener(this);
        rv.setLayoutManager(new GridLayoutManager(this, 3));
        popupWindow.setContentView(view);
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAsDropDown(order, 0, 30);


    }

    private void getOrderNetData() {
        VolleySingleton.MyRequest(orderUrl, OrderBean.class, new NetListener<OrderBean>() {
            @Override
            public void successListener(OrderBean response) {
                orderAdapter.setBean(response);

            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });
    }


    @Override
    public void onClickListener(int position, String data) {
        String orderByNewUrl = headerUrl + category + footUrl + id + orderByUrl + data;
        VolleySingleton.MyRequest(orderByNewUrl, DetailBean.class, new NetListener<DetailBean>() {
            @Override
            public void successListener(DetailBean response) {
                adapter.setBean(response);
            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });

    }
}
