package com.popmeals.modules.myaccount.adapter.orders

import com.popmeals.base.list.RecyclerViewAdapter
import com.popmeals.base.list.RecyclerViewHolder
import com.popmeals.databinding.LayoutOrderItemBinding
import com.popmeals.modules.myaccount.model.OrderItem


class MyAccountOrdersListAdapterViewHolder(
        private val binding: LayoutOrderItemBinding,
        adapter: RecyclerViewAdapter<OrderItem>
) : RecyclerViewHolder<OrderItem>(binding.root, adapter) {
    override fun bindData(data: OrderItem) {
        binding.model = data
        binding.executePendingBindings()
    }
}