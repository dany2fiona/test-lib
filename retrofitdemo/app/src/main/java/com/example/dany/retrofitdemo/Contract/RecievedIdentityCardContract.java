package com.example.dany.retrofitdemo.Contract;

import com.example.dany.retrofitdemo.Presenter.BasePresenter;
import com.example.dany.retrofitdemo.model.RecievedIdentityCard;

/**
 * Created by dan.y on 2016/9/8.
 */
public interface RecievedIdentityCardContract {
    interface View extends BaseView{
        void showInfo(RecievedIdentityCard bean);
    }
    interface Presenter extends BasePresenter{
        void loadInfo();
    }
}
