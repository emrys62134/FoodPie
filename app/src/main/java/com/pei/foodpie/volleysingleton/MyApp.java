package com.pei.foodpie.volleysingleton;

import android.app.Application;
import android.content.Context;

import com.pei.foodpie.dbtool.DaoMaster;
import com.pei.foodpie.dbtool.DaoSession;

import cn.sharesdk.framework.ShareSDK;

/**
 * Created by dllo on 16/11/28.
 */

// 定义一个全局的Context对象
// 在Application刚启动的时候就声明一个

public class MyApp extends Application {

    private static Context context;
    private static DaoMaster sDaoMaster;
    private static DaoSession daoSession;


    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        ShareSDK.initSDK(this);
    }

    public static Context getContext() {
        return context;
    }

    // 对外提供获取DaoMAster对象
    public static DaoMaster getDaoMaster() {
        DaoMaster.DevOpenHelper helper =
                new DaoMaster.DevOpenHelper(getContext(),"File.db",null);

        // 初始化DaoMAster对象
        sDaoMaster = new DaoMaster(helper.getWritableDb());
        return sDaoMaster;
    }

    // 对外提供获取DaoSession对象
    public static DaoSession getDaoSession() {
        if (daoSession == null){
            if (sDaoMaster == null){
                sDaoMaster = getDaoMaster();
            }
            // 初始化DaoSession对象
            daoSession = sDaoMaster.newSession();
        }
        return daoSession;
    }

}
