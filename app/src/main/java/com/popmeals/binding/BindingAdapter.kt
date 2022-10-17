package com.popmeals.binding

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import androidx.viewpager2.widget.ViewPager2
import com.popmeals.base.list.ListItem
import com.popmeals.base.list.RecyclerViewAdapter

@BindingAdapter("linerLayoutManager")
fun bindLinerLayoutManager(view: RecyclerView?, typeId: Int = RecyclerView.VERTICAL) {
    view?.apply {
        layoutManager = LinearLayoutManager(context, typeId, false)
    }
}

@BindingAdapter("recyclerViewListAdapter")
fun bindRecyclerViewAdapter(view: RecyclerView?, _adapter: RecyclerViewAdapter<ListItem>?) {
    view?.apply {
        _adapter?.run {
            adapter = _adapter
        }
    }
}

@BindingAdapter("viewPagerAdapter")
fun bindRecyclerViewAdapter(view: ViewPager2?, _adapter: RecyclerViewAdapter<ListItem>?) {
    view?.apply {
        _adapter?.run {
            adapter = _adapter
        }
    }
}

@BindingAdapter("setImageResource")
fun bindImageResource(view: ImageView?, imageId: Int?) {
    view?.apply {
        imageId?.let { id ->
            view.setImageResource(id)
        }
    }
}

@BindingAdapter("setTextResource")
fun bindTextResource(view: TextView?, imageId: Int?) {
    view?.apply {
        imageId?.let { id ->
            view.setText(id)
        }
    }
}

@BindingAdapter("setText")
fun bindText(view: TextView?, text: String?) {
    view?.apply {
        text?.let { text ->
            view.text = text
        }
    }
}

@BindingAdapter("setVisible")
fun bindVisibility(view: View?, visible: Boolean = true) {
    view?.apply {
            view.visibility = if(visible) View.VISIBLE else View.GONE
    }
}