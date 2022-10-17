package com.popmeals.base.list

import android.view.View
import kotlinx.android.extensions.LayoutContainer

abstract class RecyclerViewHolder<T : ListItem>(view: View, internal var adapter: RecyclerViewAdapter<T>)
    : androidx.recyclerview.widget.RecyclerView.ViewHolder(view),
    LayoutContainer {
    abstract fun bindData(data: T)

    override val containerView: View?
        get() = itemView
}
