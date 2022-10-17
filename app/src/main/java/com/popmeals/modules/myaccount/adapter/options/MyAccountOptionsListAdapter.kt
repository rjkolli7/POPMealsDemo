package com.popmeals.modules.myaccount.adapter.options

import android.content.Context
import com.popmeals.R
import com.popmeals.base.list.ListItem
import com.popmeals.base.list.RecyclerViewAdapter
import com.popmeals.base.list.RecyclerViewAdapterDelegate
import com.popmeals.modules.myaccount.model.MyAccountOptionModel

class MyAccountOptionsListAdapter(context: Context) : RecyclerViewAdapter<ListItem>() {
    init {
        delegateManager.addDelegates(MyAccountOptionsListAdapterDelegate(context) as RecyclerViewAdapterDelegate<ListItem>)
        setItems(
            listOf(
                MyAccountOptionModel(
                    iconResourceId = R.drawable.icon_user,
                    title = R.string.my_profile
                ),
                MyAccountOptionModel(
                    iconResourceId = R.drawable.icon_location,
                    title = R.string.my_address
                )
            )
        )
    }
}