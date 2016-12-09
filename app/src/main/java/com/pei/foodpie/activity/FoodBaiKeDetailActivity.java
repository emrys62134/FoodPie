package com.pei.foodpie.activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.pei.foodpie.constant.Constant;
import com.pei.foodpie.foodbaike.FoodBaiKeBean;
import com.pei.foodpie.foodbaike.detail.DetailAdapter;
import com.pei.foodpie.foodbaike.detail.DetailBean;
import com.pei.foodpie.foodbaike.detail.leftpop.OrderAdapter;
import com.pei.foodpie.foodbaike.detail.leftpop.OrderBean;
import com.pei.foodpie.foodbaike.detail.rightpop.SubValuesAdapter;
import com.pei.foodpie.utils.ClickListener;
import com.pei.foodpie.utils.DividerItemDecoration;
import com.pei.foodpie.R;
import com.pei.foodpie.base.BaseActivity;

import com.pei.foodpie.utils.MyClickListener;
import com.pei.foodpie.utils.NetListener;
import com.pei.foodpie.utils.ThirdClickListener;
import com.pei.foodpie.volleysingleton.VolleySingleton;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.util.ArrayList;

/**
 * Created by dllo on 16/12/2.
 */
public class FoodBaiKeDetailActivity extends BaseActivity implements View.OnClickListener, MyClickListener, ThirdClickListener {


    // 上拉加载网址拼接
    private String compositionUrl;

    // 根据主页传过来的id拼接网址
    private String newUrl;

    // 食物百科 详情页组件
    private PullLoadMoreRecyclerView rv;
    private Button orderBtn;
    private ImageView ivOrder;
    private TextView tvAll;
    private ImageView ivRight;
    private TextView title;
    private ImageView previous;


    // 从主页面传过来的数据
    private String category; // 是第几个gridView
    private String name; // gridView position name
    private int id; // gridView position
    private FoodBaiKeBean bean; // 从主页传过来的对象


    private DetailBean detailBean;

    // 详情页 RecyclerView adapter
    private DetailAdapter adapter;

    // 左侧popupWindow 里面的内容
    private OrderAdapter orderAdapter;

    // 左侧popup
    private PopupWindow popupWindow;

    private boolean isClick = false;
    // 页数
    private int i = 1;
    private SubValuesAdapter subValuesAdapter;
    private ArrayList<String> arrayList;
    // 食物分类详情页 右侧popup id
    private int subId;
    // 食物分类详情页 右侧popup id 对应的网址
    private String rightPopUrl;


    @Override
    protected int setLayout() {
        return R.layout.activity_food;
    }

    @Override
    protected void initView() {
        initViews();
        getIntentData();

    }

    @Override
    protected void initData() {
        getNetData();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.order_detail:
                // 初始化左侧popup 使用 RecyclerView
                initLeftPopup();
                // 初始化左侧popup对应的箭头
                initLeftArrow();
                if (!popupWindow.isShowing()) {
                    ivOrder.setImageResource(R.mipmap.ic_food_arrow_ordering);
                }
                break;
            case R.id.tv_all_right_pop:
                // 右侧popup 使用listView
                initRightPop();

                break;
            case R.id.back_detail_food:
                finish();
                break;
        }
    }



    private void initViews() {

        rv = bindView(R.id.rv_detail_food);
        orderBtn = bindView(R.id.order_detail);
        previous = bindView(R.id.back_detail_food);
        ivOrder = bindView(R.id.iv_order_arrow_down);
        tvAll = bindView(R.id.tv_all_right_pop);
        ivRight = bindView(R.id.iv_all_right_pop);
        title = bindView(R.id.title_detail_food);

        orderBtn.setOnClickListener(this);
        previous.setOnClickListener(this);



    }

    private void getNetData() {
        VolleySingleton.MyRequest(newUrl, DetailBean.class, new NetListener<DetailBean>() {
            @Override
            public void successListener(DetailBean response) {
                adapter.setBean(response);
                detailBean = response;


            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });
    }


    // 左侧popup
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
        ColorDrawable cd = new ColorDrawable(000000);
        popupWindow.setBackgroundDrawable(cd);
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAsDropDown(orderBtn, 0, 30);


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


    // 左侧popup 加载内容
    private void getOrderNetData() {
        VolleySingleton.MyRequest(Constant.FOOD_DETAIL_LIST_VIEW_URL, OrderBean.class, new NetListener<OrderBean>() {
            @Override
            public void successListener(OrderBean response) {
                orderAdapter.setBean(response);

            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });
    }


    // 右侧popup
    private void initRightPop() {
        PopupWindow rightPop = new PopupWindow(this);
        rightPop.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        rightPop.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        View view = LayoutInflater.from(this).inflate(R.layout.right_pop_food_detail, null);

        ListView rightList = (ListView) view.findViewById(R.id.lv_pop_right_food_detail);
        subValuesAdapter = new SubValuesAdapter(this);
        subValuesAdapter.setArrayList(arrayList);
        rightPop.setContentView(view);
        rightPop.setOutsideTouchable(true);
        rightList.setAdapter(subValuesAdapter);
        rightPop.showAsDropDown(tvAll);

//        rightList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                if (i == 0){
//
//                }else {
//                    rightPopUrl = Constant.FOOD_KIND_URL + category + Constant.FOOD_GRID_POSITION_URL + id
//                            +Constant.FOOD_DETAIL_RIGHT_POP_VALUE_URL+(subId)+Constant.FOOD_DETAIL_ORDER_BY_PAGE_URL
//                            + (i) + Constant.FOOD_DETAIL_TAIL;
//                    getRightPopMapNetData();
//                }
//            }
//        });


    }

//    private void getRightPopMapNetData() {
//        VolleySingleton.MyRequest(rightPopUrl, DetailBean.class, new NetListener<DetailBean>() {
//            @Override
//            public void successListener(DetailBean response) {
//                DetailBean data = response;
//                if (detailBean == null){
//                    detailBean = data;
//                }else {
//                    for (int j = 0; j < data.getFoods().size() ; j++) {
//                        detailBean.getFoods().add(data.getFoods().get(j));
//                    }
//                }
//                adapter.setBean(detailBean);
//            }
//
//            @Override
//            public void errorListener(VolleyError error) {
//
//            }
//        });
//
//    }


    // 获取从主页传过来的数据
    private void getIntentData() {

        Intent intent = getIntent();
        category = intent.getStringExtra("category");
        name = intent.getStringExtra("name");
        id = intent.getIntExtra("id", 0);
        bean = intent.getParcelableExtra("object");
        arrayList = new ArrayList<>();
        arrayList.add("全部");


        title.setText(name);
        newUrl = Constant.FOOD_KIND_URL + category + Constant.FOOD_GRID_POSITION_URL + id;
        refreshAndLoadMore();

        if (category.equals("group")) {
            tvAll.setText("全部");
            ivRight.setImageResource(R.mipmap.ic_food_arrow_ordering);
            tvAll.setOnClickListener(this);

            for (int j = 0; j < bean.getGroup().get(0).getCategories().get(id - 1).getSub_categories().size(); j++) {
                arrayList.add(bean.getGroup().get(0).getCategories().get(id - 1).getSub_categories().get(j).getName());
                subId = bean.getGroup().get(0).getCategories().get(id-1).getSub_categories().get(j).getId();

            }
        }
    }


    // 下拉刷新.上拉加载
    private void refreshAndLoadMore() {

        adapter = new DetailAdapter(this);
        rv.setAdapter(adapter);
        rv.setLinearLayout();
        rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));

        //TODO
        adapter.setThirdClickListener(this);

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

                        compositionUrl = Constant.FOOD_KIND_URL + category + Constant.FOOD_GRID_POSITION_URL + id
                                + Constant.FOOD_DETAIL_ORDER_BY_PAGE_URL + (i + 1);


                        getDetailLoadData();
                        i++;
                        rv.setPullLoadMoreCompleted();
                    }
                }, 2000);
            }
        });
    }

    // 获取加载的数据
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


    // 点击对应的左侧popup position 下方listView会显示不同的数据
    @Override
    public void onClickListener(int position, String data) {
        String orderByNewUrl = Constant.FOOD_KIND_URL + category + Constant.FOOD_GRID_POSITION_URL + id
                + Constant.FOOD_DETAIL_ORDER_BY_URL + data;
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


    @Override
    public void onClickSendBean(int position, DetailBean bean) {
        Intent intent = new Intent(FoodBaiKeDetailActivity.this,FoodBaiKeSecondActivity.class);
        intent.putExtra("detailBean",bean);
        intent.putExtra("position",position);
        startActivity(intent);
    }
}
