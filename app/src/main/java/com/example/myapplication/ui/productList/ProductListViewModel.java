package com.example.myapplication.ui.productList;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.data.ProductListRepository;
import com.example.myapplication.data.bean.ItemInfo;

import java.util.List;

public class ProductListViewModel extends ViewModel {
    public ProductListViewModel(ProductListRepository repository) {
        this.repository = repository;
    }

    private ProductListRepository repository;

    private String category;

    private MutableLiveData<List<ItemInfo>> product;

    //下面的方法在活动中调用（待完成）
    private void getProductsList(String category) {
        product.setValue(repository.getProductsList(category));
    }
}
