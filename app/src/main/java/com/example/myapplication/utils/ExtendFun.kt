package com.example.myapplication.utils

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

//声明retrofit全局异步请求处理扩展函数
suspend fun <T> Call<T>.await(): T {
    return suspendCoroutine { continuation ->
        enqueue(object : Callback<T> {
            override fun onFailure(call: Call<T>, t: Throwable) {
                continuation.resumeWithException(t)
            }

            override fun onResponse(call: Call<T>, response: Response<T>) {
                val body = response.body()
                if (body != null) {
                    //resume函数的作用：恢复父协程的执行并将传入的参数返回给父协程
                    continuation.resume(body)
                } else {
                    continuation.resumeWithException(RuntimeException("return date is null !"))
                }
            }
        })
    }
}