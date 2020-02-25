package com.example.myapplication.ui.productsDetails;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.data.ProDetailsRepository;
import com.example.myapplication.data.bean.ProDetails;

public class ProductDetailsViewModel extends ViewModel {
    ProDetailsRepository repository;

    public ProductDetailsViewModel(ProDetailsRepository repository) {
        this.repository = repository;
    }

    MutableLiveData<ProDetails> proDetails = new MutableLiveData<>();

    private ProDetails getProDetails(String category) {
        return repository.getProDetails(category);
    }

}
