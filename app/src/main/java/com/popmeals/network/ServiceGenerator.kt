package com.popmeals.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Authenticator
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ServiceGenerator {
    private const val timeOutSeconds: Long = 100
    private var retrofit: Retrofit? = null
    private val httpClient = OkHttpClient.Builder().connectTimeout(timeOutSeconds, TimeUnit.SECONDS)
        .readTimeout(timeOutSeconds, TimeUnit.SECONDS)
    private var builder =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .baseUrl("http://staging-api.dahmakan.com/")

    fun <T> createService(serviceClass: Class<T>): T {
        httpClient.interceptors().add(Interceptor { chain ->
            var response = chain.proceed(chain.request());
            response
        })
        val client = httpClient.build()
        retrofit = builder.client(client).build()
        return retrofit!!.create(serviceClass)
    }

    fun addNetworkInterceptor(interceptor: Interceptor) {
        httpClient.addNetworkInterceptor(interceptor)
    }

    fun addNetworkAuthenticator(authenticator: Authenticator) {
        httpClient.authenticator(authenticator)
    }
}