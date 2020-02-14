package com.example.myapplication.data.network;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ServiceCreator {
    public static Object create(String url, Class serviceClass) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        return retrofit.create(serviceClass);
    }
}
