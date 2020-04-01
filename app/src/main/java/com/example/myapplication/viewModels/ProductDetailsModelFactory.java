package com.example.myapplication.viewModels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.data.network.ProDetailsRepository;

public class ProductDetailsModelFactory extends ViewModelProvider.NewInstanceFactory {

    private ProDetailsRepository repository;

    public ProductDetailsModelFactory(ProDetailsRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new ProDetailsViewModel(repository);
    }
}
