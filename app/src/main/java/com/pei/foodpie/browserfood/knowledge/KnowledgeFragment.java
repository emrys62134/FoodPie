package com.pei.foodpie.browserfood.knowledge;


import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
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
public class KnowledgeFragment extends BaseFragment {

    private ListView lv;
    private KnowledgeAdapter adapter;


    @Override
    protected int setLayout() {
        return R.layout.fragment_knowledge_browser;
    }

    @Override
    protected void initView(View view) {
        initViews();// 初始化控件
    }

    @Override
    protected void initData() {
        getNetData(); // 获取网络数据
    }


    private void initViews() {
        lv = bindView(R.id.lv_browser_knowledge);
        adapter = new KnowledgeAdapter(MyApp.getContext());
        lv.setAdapter(adapter);
    }

    private void getNetData() {
        VolleySingleton.MyRequest(Constant.KnowledgeUrl, KnowledgeBean.class, new NetListener<KnowledgeBean>() {
            @Override
            public void successListener(final KnowledgeBean response) {
                adapter.setKnowledgeBean(response);
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(getActivity(), CommonActivity.class);
                        intent.putExtra("data",response.getFeeds().get(i).getLink());
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });
    }
}
