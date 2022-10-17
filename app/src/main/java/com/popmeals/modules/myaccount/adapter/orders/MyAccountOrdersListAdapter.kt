package com.popmeals.modules.myaccount.adapter.orders

import android.content.Context
import com.popmeals.base.list.ListItem
import com.popmeals.base.list.RecyclerViewAdapter
import com.popmeals.base.list.RecyclerViewAdapterDelegate

class MyAccountOrdersListAdapter(context: Context) : RecyclerViewAdapter<ListItem>() {
    init {
        delegateManager.addDelegates(MyAccountOrdersListAdapterDelegate(context) as RecyclerViewAdapterDelegate<ListItem>)
    }
}