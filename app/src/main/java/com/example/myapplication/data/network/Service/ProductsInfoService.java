package com.example.myapplication.data.network.Service;

import com.example.myapplication.data.bean.ProItemOuter;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductsInfoService {
    @GET("school/second/merchandiseList")
    Call<ProItemOuter> getInfoList();
}
