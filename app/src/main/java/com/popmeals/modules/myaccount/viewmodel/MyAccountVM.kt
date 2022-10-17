package com.popmeals.modules.myaccount.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.popmeals.base.BaseViewModel
import com.popmeals.modules.myaccount.model.OrderItem
import com.popmeals.modules.myaccount.repository.MyAccountRepo
import com.popmeals.network.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyAccountVM(application: Application, private val repo: MyAccountRepo) :
    BaseViewModel(application) {
    val ordersListLiveData = MutableLiveData<ArrayList<OrderItem>>()
    var isLoading: MutableLiveData<Boolean> = MutableLiveData()
    var isRefreshing: MutableLiveData<Boolean> = MutableLiveData()

    fun getOrders() {
        isLoading.postValue(false)
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repo.orders()) {
                is NetworkResult.Success -> {
                    result.data.let { response ->
                        response.ordersList?.let { orders ->
                            val ordersList =
                                orders.filter { item -> item.arrives_at_utc != null }.toList()
                            ordersListLiveData.postValue(ordersList as ArrayList<OrderItem>?)
                        }
                    }
                    isLoading.postValue(false)
                    isRefreshing.postValue(false)
                }
                is NetworkResult.Error -> {
                    setError(result.exception)
                    isLoading.postValue(false)
                    isRefreshing.postValue(false)
                }
            }
        }
    }
}