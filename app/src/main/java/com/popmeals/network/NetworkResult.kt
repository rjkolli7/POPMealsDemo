package com.popmeals.network

import retrofit2.Response

sealed class NetworkResult<out T : Any?> {
    data class Success<out T : Any?>(val data: T) : NetworkResult<T>()
    data class Error(val exception: Throwable) : NetworkResult<Nothing>()
}

fun <T : Any?> handleApiError(resp: Response<T>): NetworkResult.Error {
    return NetworkResult.Error(MyException(resp.message(), resp.code()))
}

fun <T : Any?> handleSuccess(response: Response<T>): NetworkResult<T> {
    val body = response.body()
    return if (response.isSuccessful && body != null) {
        NetworkResult.Success(body)
    } else {
        NetworkResult.Error(MyException(response.message(), response.code()))
    }
}
