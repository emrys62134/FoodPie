package com.pei.foodpie.search;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.pei.foodpie.R;
import com.pei.foodpie.base.BaseActivity;
import com.pei.foodpie.constant.Constant;
import com.pei.foodpie.dbtool.DBTool;
import com.pei.foodpie.dbtool.SearchData;
import com.pei.foodpie.utils.DividerItemDecoration;
import com.pei.foodpie.utils.MyClickListener;
import com.pei.foodpie.utils.NetListener;
import com.pei.foodpie.volleysingleton.VolleySingleton;

import java.util.ArrayList;

/**
 * Created by dllo on 16/12/12.
 */
public class SearchActivity extends BaseActivity implements View.OnClickListener, MyClickListener, TextWatcher {

    private ImageView ivBack;
    private EditText etInput;
    private ImageView ivClear;
    private ImageView ivSearch;
    private LinearLayout llHistory;
    private ListView lvHistory;
    private RecyclerView rvHot;
    private int length;
    private SearchRvAdapter searchRvAdapter;
    private ArrayList<String> arrayList ;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor sp;
    private View headView;
    private View footView;


    @Override
    protected int setLayout() {
        return R.layout.activity_search;
    }

    @Override
    protected void initView() {
        arrayList = new ArrayList<>();

        ivBack = bindView(R.id.iv_back_search);
        etInput = bindView(R.id.et_input_search);
        ivClear = bindView(R.id.iv_clear_search);
        ivSearch = bindView(R.id.iv_search);

        ivBack.setOnClickListener(this);
        etInput.setOnClickListener(this);
        ivClear.setOnClickListener(this);
        ivSearch.setOnClickListener(this);

        etInput.addTextChangedListener(this);

        lvHistory = bindView(R.id.lv_search);
        lvHistory.setVisibility(View.GONE);
        headView = LayoutInflater.from(this).inflate(R.layout.item_header_lv_search, null);
        footView = LayoutInflater.from(this).inflate(R.layout.item_footer_lv_search, null);
        LinearLayout llClear = (LinearLayout) footView.findViewById(R.id.ll_clear_lv_footer);
        llClear.setOnClickListener(this);

        rvHot = bindView(R.id.rv_search);

        searchRvAdapter = new SearchRvAdapter();
        rvHot.setAdapter(searchRvAdapter);
        rvHot.setLayoutManager(new GridLayoutManager(this, 2));
        rvHot.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));

        sharedPreferences = getSharedPreferences("file", MODE_PRIVATE);
        String lvData = sharedPreferences.getString("data", "");
        if (!lvData.equals("")) {
            Log.d("SearchActivity", lvData);
            arrayList.add(lvData);
        }

        if (arrayList != null) {

            lvHistory.setVisibility(View.VISIBLE);
            lvHistory.addHeaderView(headView);
            lvHistory.addFooterView(footView);

        } else {
            lvHistory.removeHeaderView(headView);
            lvHistory.removeFooterView(footView);

        }
     //   arrayList = new ArrayList<>();

        for (int i = 0; i < sharedPreferences.getInt("key", 0); i++) {
            String str = sharedPreferences.getString("data" + i, null);
            arrayList.add(str);
        }
        SearchLvAdapter searchLvAdapter = new SearchLvAdapter();
        searchLvAdapter.setArrayList(arrayList);
        lvHistory.setAdapter(searchLvAdapter);
        searchRvAdapter.setMyClickListener(this);

    }

    @Override
    protected void initData() {



        sp = (SharedPreferences.Editor)
                getSharedPreferences("file", MODE_PRIVATE).edit();

        VolleySingleton.MyRequest(Constant.FOOD_SEARCH_RV, SearchBean.class, new NetListener<SearchBean>() {
            @Override
            public void successListener(SearchBean response) {
                searchRvAdapter.setSearchBean(response);
            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back_search:
                finish();
                break;
            case R.id.et_input_search:

                break;
            case R.id.iv_clear_search:
                etInput.getText().clear();
                break;
            case R.id.iv_search:
                if (etInput.getText().toString().isEmpty()) {
                    Toast.makeText(this, "输入的内容不能为空", Toast.LENGTH_SHORT).show();
                } else {

                    int i = sharedPreferences.getInt("key", 0);
                    String data = etInput.getText().toString();
                    sp.putString("data" + i, data);
                    i += 1;
                    sp.putInt("key", i);

                    sp.commit();
                    Intent intent = new Intent(SearchActivity.this, SearchDetailActivity.class);
                    intent.putExtra("data", data);
                    startActivity(intent);
                    finish();
                }
                break;
            case R.id.ll_clear_lv_footer:
                arrayList.clear();
                lvHistory.removeHeaderView(headView);
                lvHistory.removeFooterView(footView);
                sp.clear();
                sp.commit();
                lvHistory.setVisibility(View.GONE);


                break;
        }
    }

    @Override
    public void onClickListener(int position, String data) {
        Intent intent = new Intent(SearchActivity.this, SearchDetailActivity.class);
        intent.putExtra("data", data);

        Log.d("SearchActivity", data);
        Log.d("SearchActivity", "position:" + position);

        int i = sharedPreferences.getInt("key", 0);
        sp.putString("data" + i, data);
        i += 1;
        sp.putInt("key", i);

        sp.commit();
        etInput.setText(data);
        intent.putExtra("position", position);
        startActivity(intent);
        finish();
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        length = etInput.getText().toString().length();
        if (length > 0) {
            ivClear.setVisibility(View.VISIBLE);
        } else {
            ivClear.setVisibility(View.GONE);
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
