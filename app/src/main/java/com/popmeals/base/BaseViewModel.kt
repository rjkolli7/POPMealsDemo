package com.popmeals.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.popmeals.R
import com.popmeals.event.Event
import com.popmeals.network.MyException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel(application: Application) : AndroidViewModel(application), CoroutineScope {
    private val _errorMsgLiveData = MutableLiveData<Event<String?>>()
    val errorMsgLiveData: LiveData<Event<String?>>
        get() = _errorMsgLiveData

    fun setError(throwable: Throwable) {
        when (throwable) {
            is MyException -> _errorMsgLiveData.postValue(Event(throwable.errorMsg))
            is UnknownHostException -> _errorMsgLiveData.postValue(
                Event(
                    getApplication<PopApplication>().getString(
                        R.string.no_internet_connection
                    )
                )
            )
            is SocketTimeoutException,
            is TimeoutException -> _errorMsgLiveData.postValue(
                Event(
                    getApplication<PopApplication>().getString(
                        R.string.poor_internet_connection
                    )
                )
            )
            else -> _errorMsgLiveData.postValue(Event(throwable.message))
        }
    }

    fun setCustomError(errorMsg: String) {
        _errorMsgLiveData.postValue(Event(errorMsg))
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + SupervisorJob()

    override fun onCleared() {
        super.onCleared()
        coroutineContext.cancel()
    }
}