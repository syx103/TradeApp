package com.example.myapplication.data.network;

import com.example.myapplication.data.bean.ProDetails;
import com.example.myapplication.data.network.Service.ProDetailsService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProDetailsNetwork {
    ProDetails proDetails;

    public ProDetails fetchProDetails(String category) {
        ProDetailsService service = ServiceCreator.create("https://ip地址/merchandiseList/",
                ProDetailsService.class);
        Call<ProDetails> call = service.getProDetails(category);
        call.enqueue(new Callback<ProDetails>() {
            @Override
            public void onResponse(Call<ProDetails> call, Response<ProDetails> response) {
                if (response.isSuccessful()) {
                    proDetails = response.body();
                }
            }

            @Override
            public void onFailure(Call<ProDetails> call, Throwable t) {

            }
        });
        return proDetails;
    }
}
