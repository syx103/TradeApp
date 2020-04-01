package com.example.myapplication.data.network

import com.example.myapplication.data.bean.ItemInfo

class ProListRepository(val network: ProListNetwork) {

    companion object {
        private lateinit var instance: ProListRepository
        fun getInstance(network: ProListNetwork): ProListRepository {
            if (!::instance.isInitialized) {
                synchronized(ProListRepository::class.java) {
                    if (!::instance.isInitialized) {
                        instance = ProListRepository(network)
                    }
                }
            }
            return instance
        }
    }

    suspend fun getProList(category: String): List<ItemInfo> {
        return network.fetchProList(category).itemList
    }
}