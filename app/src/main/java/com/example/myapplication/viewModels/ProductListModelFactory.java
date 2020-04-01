package com.example.myapplication.viewModels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.data.network.ProListRepository;

public class ProductListModelFactory extends ViewModelProvider.NewInstanceFactory {

    private ProListRepository repository;

    public ProductListModelFactory(ProListRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new ProListViewModel(repository);
    }
}
