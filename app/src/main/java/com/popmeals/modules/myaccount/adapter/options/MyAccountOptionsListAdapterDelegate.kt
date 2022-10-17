package com.popmeals.modules.myaccount.adapter.options

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.popmeals.R
import com.popmeals.base.list.ListItem
import com.popmeals.base.list.RecyclerViewAdapter
import com.popmeals.base.list.RecyclerViewAdapterDelegate
import com.popmeals.base.list.RecyclerViewHolder
import com.popmeals.databinding.LayoutMyAccountOptionsBinding
import com.popmeals.modules.myaccount.model.MyAccountOptionModel

class MyAccountOptionsListAdapterDelegate(private val context: Context) :
    RecyclerViewAdapterDelegate<MyAccountOptionModel>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        adapter: RecyclerViewAdapter<MyAccountOptionModel>,
        viewType: Int
    ): RecyclerViewHolder<MyAccountOptionModel> {
        return MyAccountOptionsListAdapterViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.layout_my_account_options,
                parent,
                false
            ) as LayoutMyAccountOptionsBinding, adapter
        )
    }

    override fun isDelegateForDataType(data: ListItem): Boolean {
        return data is MyAccountOptionModel
    }
}