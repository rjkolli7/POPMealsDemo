package com.popmeals.base.list

import android.view.ViewGroup

interface AdapterDelegate<T : ListItem> {
    fun onCreateViewHolder(parent: ViewGroup, adapter: RecyclerViewAdapter<T>, viewType: Int): RecyclerViewHolder<T>

    fun onBindViewHolder(viewHolder: RecyclerViewHolder<T>, data: T)

    fun isDelegateForDataType(data: ListItem): Boolean
}