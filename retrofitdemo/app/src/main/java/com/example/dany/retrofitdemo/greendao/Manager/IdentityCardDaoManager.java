package com.example.dany.retrofitdemo.greendao.Manager;

import com.example.dany.retrofitdemo.greendao.entity.IdentityCard;
import com.example.dany.retrofitdemo.greendao.gen.IdentityCardDao;

/**
 * Created by Administrator on 2016/9/21.
 */
public class IdentityCardDaoManager {
    private static IdentityCardDaoManager mInstance;
    private static IdentityCardDao mIdentityCardDao;

    private IdentityCardDaoManager(){
        mIdentityCardDao = GreenDaoManager.getInstance().getDaoSession().getIdentityCardDao();
    }

    public static IdentityCardDaoManager getInstance(){
        if(mInstance == null){
            mInstance = new IdentityCardDaoManager();
        }
        return mInstance;
    }

    /**
     * 增加一条记录
     * @param id
     * @param address
     * @param birthday
     * @param sex
     */
    public void insertIdentityCard(Long id,String cardNo,String address,String birthday,String sex){
        IdentityCard identityCard = new IdentityCard(id,cardNo,address,birthday,sex);
        mIdentityCardDao.insert(identityCard);
    }

}
