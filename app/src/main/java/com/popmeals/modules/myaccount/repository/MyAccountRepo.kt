package com.popmeals.modules.myaccount.repository

import com.popmeals.base.BaseRepo
import com.popmeals.modules.myaccount.MyAccountApi
import com.popmeals.modules.myaccount.model.OrdersResponse
import com.popmeals.network.NetworkResult

class MyAccountRepo(private val api: MyAccountApi) : BaseRepo() {
    suspend fun orders(): NetworkResult<OrdersResponse> {
        return try {
            handleResponse(api.orders())
        } catch (e: Exception) {
            NetworkResult.Error(e)
        }
    }
}