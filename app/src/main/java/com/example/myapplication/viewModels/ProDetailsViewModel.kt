package com.example.myapplication.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.bean.ProDetailsInfo
import com.example.myapplication.data.network.ProDetailsRepository

class ProDetailsViewModel(private val repository: ProDetailsRepository) : ViewModel() {

    var productDetails = MutableLiveData<ProDetailsInfo>()

    var isLoading = MutableLiveData<Boolean>()

    suspend fun getProDetails(id: Int): ProDetailsInfo {
        return repository.getProDetails(id)
    }

}