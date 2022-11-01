package com.example.getdata;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;

public interface RetroApi {

    @GET("posts")
    Call<List<StoreData>> getStoreData();

}
