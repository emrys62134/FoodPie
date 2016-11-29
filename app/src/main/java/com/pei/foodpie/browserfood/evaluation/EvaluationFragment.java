package com.pei.foodpie.browserfood.evaluation;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.volley.VolleyError;
import com.pei.foodpie.R;
import com.pei.foodpie.base.BaseFragment;
import com.pei.foodpie.browserfood.delicious.CommonActivity;
import com.pei.foodpie.constant.Constant;
import com.pei.foodpie.volleysingleton.MyApp;
import com.pei.foodpie.volleysingleton.NetListener;
import com.pei.foodpie.volleysingleton.VolleySingleton;

/**
 * Created by dllo on 16/11/23.
 */
public class EvaluationFragment extends BaseFragment implements ClickListener {

    private RecyclerView rv;
    private EvaluationAdapter adapter;

    public static EvaluationFragment newInstance() {

        Bundle args = new Bundle();
        EvaluationFragment fragment = new EvaluationFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_evaluation_browser;
    }

    @Override
    protected void initView(View view) {
        initViews();
    }

    @Override
    protected void initData() {
        getNetData();
    }



    private void initViews() {
        rv = bindView(R.id.rv_evaluation);
        adapter = new EvaluationAdapter(MyApp.getContext());
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(MyApp.getContext()));
        adapter.setClickListener(this);
    }

    private void getNetData() {
        VolleySingleton.MyRequest(Constant.EvaluationUrl, EvaluationBean.class, new NetListener<EvaluationBean>() {
            @Override
            public void successListener(EvaluationBean response) {
                adapter.setBean(response);

            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });
    }

    @Override
    public void onClickListener(final int position) {
        VolleySingleton.MyRequest(Constant.EvaluationUrl, EvaluationBean.class, new NetListener<EvaluationBean>() {
            @Override
            public void successListener(EvaluationBean response) {
                Intent intent = new Intent(getActivity(), CommonActivity.class);
                intent.putExtra("data",response.getFeeds().get(position).getLink());
                startActivity(intent);


            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });
    }
}
