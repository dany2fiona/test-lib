package com.example.dany.retrofitdemo;

import android.app.Application;
import android.content.Context;

import com.example.dany.retrofitdemo.greendao.Manager.GreenDaoManager;

/**
 * Created by dan.y on 2016/9/21.
 */
public class MyApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        GreenDaoManager.getInstance();
    }

    public static Context getContext() {
        return mContext;
    }
}
