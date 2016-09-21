package com.example.dany.retrofitdemo.greendao.Manager;

import com.example.dany.retrofitdemo.MyApplication;
import com.example.dany.retrofitdemo.greendao.gen.DaoMaster;
import com.example.dany.retrofitdemo.greendao.gen.DaoSession;

/**
 * Created by dan.y on 2016/9/21.
 */
public class GreenDaoManager {
    private static GreenDaoManager mInstance;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    private GreenDaoManager(){
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(MyApplication.getContext(),"test-db",null);
        mDaoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        mDaoSession = mDaoMaster.newSession();
    }

    public static GreenDaoManager getInstance(){
        if(mInstance == null){
            mInstance = new GreenDaoManager();
        }
        return mInstance;
    }

    public DaoMaster getDaoMaster() {
        return mDaoMaster;
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public DaoSession getNewDaoSession(){
        mDaoSession = mDaoMaster.newSession();
        return mDaoSession;
    }
}
