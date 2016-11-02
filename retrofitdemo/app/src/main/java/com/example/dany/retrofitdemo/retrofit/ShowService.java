package com.example.dany.retrofitdemo.retrofit;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/9/10.
 */
public class ShowService {
    private ShowService(){
    }

    public static ShowAPI createService(){
        Retrofit.Builder builder = new Retrofit.Builder()
//                            .baseUrl("http://route.showapi.com/")
                            .baseUrl("http://222.73.0.213:8300/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create());

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Request newReq = request.newBuilder().build();
                return chain.proceed(newReq);
            }
        }).build();

        builder.client(client);
        return builder.build().create(ShowAPI.class);
    }

}
