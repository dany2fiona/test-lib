package com.example.dany.retrofitdemo.retrofit;

import com.example.dany.retrofitdemo.model.RecievedIdentityCard;
import com.example.dany.retrofitdemo.model.Room;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by dan.y on 2016/8/25.
 */
public interface ShowAPI {
   @GET("25-3")
    Observable<RecievedIdentityCard> recievedIdentityCard(@Query("id") String id,@Query("showapi_appid") String showapi_appid,@Query("showapi_sign") String showapi_sign,
                                                          @Query("showapi_timestamp") String showapi_timestamp/*,@Query("showapi_sign_method") String showapi_sign_method,
                                                          @Query("showapi_res_gzip") String showapi_res_gzip*/);
    @GET("rooms/")
    Observable<Room> getRooms();

}
