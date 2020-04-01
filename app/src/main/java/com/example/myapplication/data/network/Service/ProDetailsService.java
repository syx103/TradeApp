package com.example.myapplication.data.network.Service;

import com.example.myapplication.data.bean.ProDetails;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ProDetailsService {
    @GET("msg")
    Call<ProDetails> getProDetails(@Query("id") int id);
}
