package com.popmeals.modules.myaccount

import com.popmeals.modules.myaccount.model.OrdersResponse
import retrofit2.Response
import retrofit2.http.GET

interface MyAccountApi {
    @GET("test/orders")
    suspend fun orders(): Response<OrdersResponse>

}