package com.popmeals.base.list

import android.view.ViewGroup
import java.util.*


open class DelegateManager<T : ListItem>(private var adapter: RecyclerViewAdapter<T>) {
    private val delegates = ArrayList<RecyclerViewAdapterDelegate<T>>()

    fun addDelegates(delegate: RecyclerViewAdapterDelegate<T>): DelegateManager<T> {
        delegates.add(delegate)
        return this
    }

    fun addDelegates(position: Int, delegate: RecyclerViewAdapterDelegate<T>): DelegateManager<T> {
        delegates.add(position, delegate)
        return this
    }

    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder<T> {
        return delegates[viewType].onCreateViewHolder(parent, adapter, viewType)
    }

    fun onBindViewHolder(viewHolder: RecyclerViewHolder<T>, data: T) {
        val viewType = viewHolder.itemViewType
        delegates[viewType].onBindViewHolder(viewHolder, data)
    }

    fun getViewType(data: ListItem): Int {
        delegates
                .filter { it.isDelegateForDataType(data) }
                .forEach {
                    return delegates.indexOf(it)
                }
        throw IllegalArgumentException("No AdapterDelegate found for data: $data")
    }
}