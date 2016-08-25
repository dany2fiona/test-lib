package com.example.dany.retrofitdemo.retrofit;

import com.example.dany.retrofitdemo.model.RecievedIdentityCard;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by user on 2016/8/25.
 */
public interface ShowService {
    @GET("25-3")
    Call<List<RecievedIdentityCard>> list();
}
