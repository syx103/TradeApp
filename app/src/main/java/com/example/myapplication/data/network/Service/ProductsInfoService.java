package com.example.myapplication.data.network.Service;

import com.example.myapplication.data.bean.ItemInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ProductsInfoService {
    @POST
    @FormUrlEncoded
    Call<List<ItemInfo>> getInfoList(@Field("category") String category);
}
