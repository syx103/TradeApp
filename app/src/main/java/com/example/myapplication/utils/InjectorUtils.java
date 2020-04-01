package com.example.myapplication.utils;

import com.example.myapplication.data.network.ProDetailsNetwork;
import com.example.myapplication.data.network.ProDetailsRepository;
import com.example.myapplication.data.network.ProListNetwork;
import com.example.myapplication.data.network.ProListRepository;
import com.example.myapplication.viewModels.ProductDetailsModelFactory;
import com.example.myapplication.viewModels.ProductListModelFactory;

import java.util.Objects;

public class InjectorUtils {

    public static InjectorUtils injectorUtils = new InjectorUtils();

    private ProListRepository getProductListRepository() {
        return ProListRepository.Companion.getInstance(Objects.requireNonNull(ProListNetwork.Companion.getInstance()));
    }

    private ProDetailsRepository getProDetailsRepository() {
        return ProDetailsRepository.Companion.getInstance(Objects.requireNonNull(ProDetailsNetwork.Companion.getInstance()));
    }

    public ProductListModelFactory getProductListModelFactory() {
        return new ProductListModelFactory(getProductListRepository());
    }

    public ProductDetailsModelFactory getProductDetailsModelFactory() {
        return new ProductDetailsModelFactory(getProDetailsRepository());
    }
}
