package com.example.myapplication.data.network

import com.example.myapplication.data.bean.ProDetailsInfo
import com.example.myapplication.data.network.Service.ProDetailsService
import com.example.myapplication.utils.await

class ProDetailsNetwork {
    private val proDetailsService = ServiceCreator
            .create("http://114.55.145.30:8090/school/second/", ProDetailsService::class.java)

    suspend fun fetchProDetails(id: Int): ProDetailsInfo  = proDetailsService.getProDetails(id).await().detailsInfo

    companion object {
        private var network: ProDetailsNetwork? = null
        fun getInstance(): ProDetailsNetwork? {
            if (network == null) {
                synchronized(ProDetailsNetwork::class.java) {
                    if (network == null) {
                        network = ProDetailsNetwork()
                    }
                }
            }
            return network
        }
    }
}