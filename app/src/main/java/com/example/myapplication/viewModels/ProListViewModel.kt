package com.example.myapplication.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.bean.ItemInfo
import com.example.myapplication.data.network.ProListRepository

class ProListViewModel(private val repository: ProListRepository) : ViewModel() {

    var itemList = MutableLiveData<List<ItemInfo>>()

    var isLoading = MutableLiveData<Boolean>()

    suspend fun getProList(category: String): List<ItemInfo>? {
        return repository.getProList(category)
    }
}