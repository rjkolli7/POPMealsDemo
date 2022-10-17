package com.popmeals.network

data class MyException(var errorMsg: String?, var code: Int?) : Exception(errorMsg)
