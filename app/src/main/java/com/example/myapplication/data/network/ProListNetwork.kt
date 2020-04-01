package com.example.myapplication.data.network

import com.example.myapplication.data.bean.ProItemOuter
import com.example.myapplication.data.network.Service.ProductsInfoService
import com.example.myapplication.utils.await

class ProListNetwork {
    private val proListService: ProductsInfoService =
            ServiceCreator.create("http://114.55.145.30:8090/", ProductsInfoService::class.java)

    suspend fun fetchProList(category: String): ProItemOuter = proListService.infoList.await()


    companion object {
        private var network: ProListNetwork? = null

        fun getInstance(): ProListNetwork? {
            if (network == null) {
                synchronized(ProListNetwork::class.java) {
                    if (network == null) {
                        network = ProListNetwork()
                    }
                }
            }
            return network
        }
    }
}