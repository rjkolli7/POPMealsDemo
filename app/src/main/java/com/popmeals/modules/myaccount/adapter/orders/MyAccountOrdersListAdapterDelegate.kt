package com.popmeals.modules.myaccount.adapter.orders

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.popmeals.R
import com.popmeals.base.list.ListItem
import com.popmeals.base.list.RecyclerViewAdapter
import com.popmeals.base.list.RecyclerViewAdapterDelegate
import com.popmeals.base.list.RecyclerViewHolder
import com.popmeals.databinding.LayoutOrderItemBinding
import com.popmeals.modules.myaccount.model.OrderItem

class MyAccountOrdersListAdapterDelegate(private val context: Context) :
    RecyclerViewAdapterDelegate<OrderItem>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        adapter: RecyclerViewAdapter<OrderItem>,
        viewType: Int
    ): RecyclerViewHolder<OrderItem> {
        return MyAccountOrdersListAdapterViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.layout_order_item,
                parent,
                false
            ) as LayoutOrderItemBinding, adapter
        )
    }

    override fun isDelegateForDataType(data: ListItem): Boolean {
        return data is OrderItem
    }
}