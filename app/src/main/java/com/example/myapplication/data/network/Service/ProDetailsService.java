package com.example.myapplication.data.network.Service;

import com.example.myapplication.data.bean.ProDetails;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

public interface ProDetailsService {
    @GET
    @FormUrlEncoded
    Call<ProDetails> getProDetails(@Field("category") String category);
}
