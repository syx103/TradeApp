package com.example.myapplication.data.network;

import android.util.Log;

import com.example.myapplication.data.bean.ItemInfo;
import com.example.myapplication.data.network.Service.ProductsInfoService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductListNetwork {
    private List<ItemInfo> productList = new ArrayList<>();
    public List<ItemInfo> fetchProList(String category) {
        //下面请求网络并解析数据
        ProductsInfoService service = ServiceCreator.create("https://ip地址/merchandiseList/",
                ProductsInfoService.class);
        Call<List<ItemInfo>> call = service.getInfoList(category);
        call.enqueue(new Callback<List<ItemInfo>>() {
            @Override
            public void onResponse(Call<List<ItemInfo>> call, Response<List<ItemInfo>> response) {
                if (response.isSuccessful()) {
                    productList = response.body();
                }
            }

            @Override
            public void onFailure(Call<List<ItemInfo>> call, Throwable t) {
                Log.d("ttw", "onFailure: " + t.toString());
            }
        });
        return productList;
    }
}
