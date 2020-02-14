package com.example.myapplication.data.network;

import com.example.myapplication.data.bean.Product;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ProductsNetwork {


    public ArrayList<Product> fetchDetails() {
        ArrayList<Product> productList = new ArrayList<>();
        //下面请求网络并解析数据
        ProductsInfoService service = ServiceCreator.create();
        Call<List> call = service.getInfoList();
        call.enqueue(new Callback<List>() {
            @Override
            public void onResponse(Call<List> call, Response<List> response) {

            }

            @Override
            public void onFailure(Call<List> call, Throwable t) {

            }
        });

        return productList;
    }


}
