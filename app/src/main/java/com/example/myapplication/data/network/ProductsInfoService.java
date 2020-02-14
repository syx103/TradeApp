package com.example.myapplication.data.network;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ProductsInfoService {
    @POST
    @FormUrlEncoded
    Call<String> getInfoList(@Field("category") String category);
}
