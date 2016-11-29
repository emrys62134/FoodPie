package com.pei.foodpie.volleysingleton;

import com.android.volley.VolleyError;

/**
 * Created by dllo on 16/11/28.
 */

public interface NetListener <T>{
    void successListener(T response);
    void errorListener(VolleyError error);
}
