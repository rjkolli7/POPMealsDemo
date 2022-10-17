package com.popmeals.modules.myaccount.adapter.options

import com.popmeals.base.list.RecyclerViewAdapter
import com.popmeals.base.list.RecyclerViewHolder
import com.popmeals.databinding.LayoutMyAccountOptionsBinding
import com.popmeals.modules.myaccount.model.MyAccountOptionModel


class MyAccountOptionsListAdapterViewHolder(
        private val binding: LayoutMyAccountOptionsBinding,
        adapter: RecyclerViewAdapter<MyAccountOptionModel>
) : RecyclerViewHolder<MyAccountOptionModel>(binding.root, adapter) {
    override fun bindData(data: MyAccountOptionModel) {
        binding.model = data
        binding.executePendingBindings()
    }
}