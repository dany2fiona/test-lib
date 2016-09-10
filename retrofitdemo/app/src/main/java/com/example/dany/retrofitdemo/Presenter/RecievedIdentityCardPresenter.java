package com.example.dany.retrofitdemo.Presenter;

import com.example.dany.retrofitdemo.Contract.RecievedIdentityCardContract;
import com.example.dany.retrofitdemo.common.Constants;
import com.example.dany.retrofitdemo.model.RecievedIdentityCard;
import com.example.dany.retrofitdemo.retrofit.ShowService;

import java.text.SimpleDateFormat;
import java.util.Date;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/9/8.
 */
public class RecievedIdentityCardPresenter implements RecievedIdentityCardContract.Presenter,Constants{
    RecievedIdentityCardContract.View view;

    public RecievedIdentityCardPresenter(RecievedIdentityCardContract.View view){
        this.view = view;
        view.setPresenter(this);
    }


    @Override
    public void loadInfo(String id) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_TIME_FORMAT);
        String timeStamp = dateFormat.format(new Date());
        rx.Observable<RecievedIdentityCard> ridObservable = ShowService.createService().
                recievedIdentityCard(id,appid,secret,timeStamp);
        ridObservable.subscribeOn(Schedulers.io())
                     .observeOn(AndroidSchedulers.mainThread())
                     .map(new Func1<RecievedIdentityCard, RecievedIdentityCard.ShowApiResBody.IdentityCard>() {
                         @Override
                         public RecievedIdentityCard.ShowApiResBody.IdentityCard call(RecievedIdentityCard recievedIdentityCard) {
                             return recievedIdentityCard.getShowapi_res_body().getRetData();
                         }
                     })
                     .subscribe(new Subscriber<RecievedIdentityCard.ShowApiResBody.IdentityCard>() {
                         @Override
                         public void onStart() {
                             super.onStart();
                             //调用刷新图标动作
                         }

                         @Override
                         public void onCompleted() {

                         }

                         @Override
                         public void onError(Throwable e) {

                         }

                         @Override
                         public void onNext(RecievedIdentityCard.ShowApiResBody.IdentityCard identityCard) {
                             RecievedIdentityCard.ShowApiResBody.IdentityCard bean = identityCard;
                             view.showInfo(bean);
                         }
                     });

    }

    @Override
    public void start() {
//        loadInfo();
    }


}
