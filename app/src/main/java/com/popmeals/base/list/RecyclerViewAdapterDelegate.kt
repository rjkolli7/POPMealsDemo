package com.popmeals.base.list


abstract class RecyclerViewAdapterDelegate<T : ListItem> : AdapterDelegate<T> {
    override fun onBindViewHolder(viewHolder: RecyclerViewHolder<T>, data: T) {
        viewHolder.bindData(data)
    }
}
