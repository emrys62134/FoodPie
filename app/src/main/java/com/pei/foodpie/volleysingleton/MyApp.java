package com.pei.foodpie.volleysingleton;

import android.app.Application;
import android.content.Context;

/**
 * Created by dllo on 16/11/28.
 */

    // 定义一个全局的Context对象
    // 在Application刚启动的时候就声明一个

public class MyApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static Context getContext() {
        return context;
    }
}
