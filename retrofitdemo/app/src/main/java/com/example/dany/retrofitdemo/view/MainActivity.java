package com.example.dany.retrofitdemo.view;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dany.retrofitdemo.Contract.RecievedIdentityCardContract;
import com.example.dany.retrofitdemo.Presenter.RecievedIdentityCardPresenter;
import com.example.dany.retrofitdemo.R;
import com.example.dany.retrofitdemo.greendao.Manager.IdentityCardDaoManager;
import com.example.dany.retrofitdemo.model.RecievedIdentityCard;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements RecievedIdentityCardContract.View {
    @BindView(R.id.tv_show)
    TextView mShowTv;
    @BindView(R.id.et_input)
    EditText mInputEt;
    @BindView(R.id.btn_query)
    Button btnQuery;
    @BindView(R.id.tv_address)
    TextView mAddressTv;
    @BindView(R.id.tv_birthday)
    TextView mBirthdayTv;
    @BindView(R.id.tv_sex)
    TextView mSexTv;
    @BindView(R.id.ll_result)
    LinearLayout mResultLl;
    private RecievedIdentityCardContract.Presenter mPresenter;
    private String mIdentityCardId;
//    RecievedIdentityCard.ShowApiResBody.IdentityCard mIdentityCard;
//    private final static int MSG_SHOW_IDENTITY_CARD_INFO = 0x0001;
//    private Handler mHandler = new Handler(){           //    rxjava已经做出线程转换问题了，无需再使用handler
//        @Override
//        public void handleMessage(Message msg) {
//            switch (msg.what){
//                case MSG_SHOW_IDENTITY_CARD_INFO:
//                    showIdentityCarfInfo(mIdentityCard);
//                    break;
//                default:
//                    break;
//            }
//            super.handleMessage(msg);
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        new RecievedIdentityCardPresenter(this);
    }

    @Override
    public void showInfo(RecievedIdentityCard.ShowApiResBody.IdentityCard bean) {
        showIdentityCarfInfo(bean);
//        mIdentityCard = bean;
//        mHandler.sendEmptyMessage(MSG_SHOW_IDENTITY_CARD_INFO);
    }

    private void showIdentityCarfInfo(RecievedIdentityCard.ShowApiResBody.IdentityCard bean) {
        if(bean !=null){
            mResultLl.setVisibility(View.VISIBLE);
            mAddressTv.setText("地址："+bean.getAddress());
            mBirthdayTv.setText("生日："+bean.getBirthday());
            mSexTv.setText("性别："+(bean.getSex().equals("M")?"男":"女"));
            IdentityCardDaoManager.getInstance().insertIdentityCard(null,mIdentityCardId,
                    bean.getAddress(),bean.getBirthday(),bean.getSex());
        }else{
            Toast.makeText(this, "无此证件号", Toast.LENGTH_SHORT).show();
            mResultLl.setVisibility(View.GONE);
            IdentityCardDaoManager.getInstance().insertIdentityCard(null,mIdentityCardId,
                    "无","无","无");
        }
    }

    @Override
    public void setPresenter(Object presenter) {
        mPresenter = (RecievedIdentityCardContract.Presenter) presenter;
    }

    @OnClick(R.id.btn_query)
    public void onClick() {
        mIdentityCardId = mInputEt.getText().toString();
        mPresenter.start();
        mPresenter.loadInfo(mIdentityCardId);
    }
}
