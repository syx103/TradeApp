package com.example.myapplication.data.network

import com.example.myapplication.data.bean.ProDetailsInfo

class ProDetailsRepository(private val network: ProDetailsNetwork) {
    suspend fun getProDetails(id: Int): ProDetailsInfo {
        return network.fetchProDetails(id)
    }

    companion object {
        private lateinit var instance: ProDetailsRepository
        fun getInstance(network: ProDetailsNetwork): ProDetailsRepository {
            //可以通过属性引用的 isInitialized来检测该lateinit var是否已初始化   this:: 用来访问类的成员，this可以省略
            if (!::instance.isInitialized) {
                synchronized(ProDetailsRepository::class.java) {
                    if (!::instance.isInitialized) {
                        instance = ProDetailsRepository(network)
                    }
                }
            }
            return instance
        }
    }
}