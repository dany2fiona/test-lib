package com.example.dany.retrofitdemo.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.dany.retrofitdemo.Contract.RecievedIdentityCardContract;
import com.example.dany.retrofitdemo.Presenter.RecievedIdentityCardPresenter;
import com.example.dany.retrofitdemo.R;
import com.example.dany.retrofitdemo.model.RecievedIdentityCard;

public class MainActivity extends AppCompatActivity implements RecievedIdentityCardContract.View{
    private RecievedIdentityCardContract.Presenter mPresenter;
    private TextView mShowTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowTv = (TextView) findViewById(R.id.tv_show);
        new RecievedIdentityCardPresenter(this);
        mPresenter.start();
    }

    @Override
    public void showInfo(RecievedIdentityCard bean) {
        mShowTv.setText("danny2fiona");
    }

    @Override
    public void setPresenter(Object presenter) {
        mPresenter = (RecievedIdentityCardContract.Presenter) presenter;
    }
}
