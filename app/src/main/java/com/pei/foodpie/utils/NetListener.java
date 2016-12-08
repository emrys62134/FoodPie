package com.pei.foodpie.utils;

import com.android.volley.VolleyError;

/**
 * Created by dllo on 16/11/28.
 */

// 获取网络数据成功和失败的接口
public interface NetListener <T>{
    void successListener(T response);
    void errorListener(VolleyError error);
}
