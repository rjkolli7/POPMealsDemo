package com.popmeals.base

import com.popmeals.network.NetworkResult
import com.popmeals.network.handleApiError
import com.popmeals.network.handleSuccess
import retrofit2.Response

abstract class BaseRepo {
    fun <T : Any?> handleResponse(response: Response<T>): NetworkResult<T> {
        return if (response.isSuccessful) {
            handleSuccess(response)
        } else {
            handleApiError(response)
        }
    }
}
