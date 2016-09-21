package com.example.dany.retrofitdemo.greendao.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by dan.y on 2016/9/21.
 */
@Entity
public class IdentityCard {
    @Id
    private Long id;
    private String cardNo;
    private String address;
    private String birthday;
    private String sex;
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getBirthday() {
        return this.birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCardNo() {
        return this.cardNo;
    }
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
    @Generated(hash = 1337798616)
    public IdentityCard(Long id, String cardNo, String address, String birthday,
            String sex) {
        this.id = id;
        this.cardNo = cardNo;
        this.address = address;
        this.birthday = birthday;
        this.sex = sex;
    }
    @Generated(hash = 1367070082)
    public IdentityCard() {
    }

}
