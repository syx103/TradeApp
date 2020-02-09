package com.example.myapplication.ui.usedProducts;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.data.ProductsRepository;
import com.example.myapplication.data.bean.Product;

import java.util.ArrayList;

public class ProductsUrlViewModel extends ViewModel {
    public ProductsUrlViewModel(ProductsRepository repository) {
        this.repository = repository;
    }

    private ProductsRepository repository;

    private MutableLiveData<ArrayList<Product>> product;

    private void getProductsList() {
        product.setValue(repository.getProductsDetails());
    }
}
