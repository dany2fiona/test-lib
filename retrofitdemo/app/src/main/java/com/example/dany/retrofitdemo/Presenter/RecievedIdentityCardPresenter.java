package com.example.dany.retrofitdemo.Presenter;

import com.example.dany.retrofitdemo.Contract.RecievedIdentityCardContract;
import com.example.dany.retrofitdemo.model.RecievedIdentityCard;

/**
 * Created by Administrator on 2016/9/8.
 */
public class RecievedIdentityCardPresenter implements RecievedIdentityCardContract.Presenter{
    RecievedIdentityCardContract.View view;

    public RecievedIdentityCardPresenter(RecievedIdentityCardContract.View view){
        this.view = view;
        view.setPresenter(this);
    }


    @Override
    public void loadInfo() {
        RecievedIdentityCard bean = null;
        view.showInfo(bean);
    }

    @Override
    public void start() {
        loadInfo();
    }


}
