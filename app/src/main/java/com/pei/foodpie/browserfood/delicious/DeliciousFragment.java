package com.pei.foodpie.browserfood.delicious;


import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.android.volley.VolleyError;
import com.pei.foodpie.R;
import com.pei.foodpie.base.BaseFragment;
import com.pei.foodpie.constant.Constant;
import com.pei.foodpie.volleysingleton.MyApp;
import com.pei.foodpie.volleysingleton.NetListener;
import com.pei.foodpie.volleysingleton.VolleySingleton;

/**
 * Created by dllo on 16/11/23.
 */
public class DeliciousFragment extends BaseFragment {

    private ListView lv;
    private DeliciousAdapter adapter;


    @Override
    protected int setLayout() {
        return R.layout.fragment_delicious_browser;
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
        lv = bindView(R.id.lv_browser_delicious);
        adapter = new DeliciousAdapter(MyApp.getContext());
        lv.setAdapter(adapter);

    }

    private void getNetData() {
        VolleySingleton.MyRequest(Constant.DeliciousUrl, DeliciousBean.class, new NetListener<DeliciousBean>() {
            @Override
            public void successListener(final DeliciousBean response) {
                adapter.setBean(response);


                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(getActivity(),CommonActivity.class);
                        intent.putExtra("data", response.getFeeds().get(i).getLink());

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
