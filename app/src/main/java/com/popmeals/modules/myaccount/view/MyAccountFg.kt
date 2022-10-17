package com.popmeals.modules.myaccount.view

import android.os.Bundle
import android.view.View
import com.google.android.material.tabs.TabLayoutMediator
import com.popmeals.R
import com.popmeals.base.BaseFragment
import com.popmeals.databinding.FragmentMyAccountBinding
import com.popmeals.event.EventObserver
import com.popmeals.modules.myaccount.adapter.options.MyAccountOptionsListAdapter
import com.popmeals.modules.myaccount.adapter.orders.MyAccountOrdersListAdapter
import com.popmeals.modules.myaccount.viewmodel.MyAccountVM
import com.popmeals.utils.PagerMarginItemDecoration
import com.popmeals.utils.dpToPx
import com.popmeals.utils.toastShortMsg
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.lang.Math.abs

class MyAccountFg : BaseFragment() {

    private lateinit var myAccountBinding: FragmentMyAccountBinding
    private lateinit var optionsAdapter: MyAccountOptionsListAdapter
    private lateinit var ordersAdapter: MyAccountOrdersListAdapter

    private val viewModel: MyAccountVM by viewModel()

    override fun getLayoutResId() = R.layout.fragment_my_account

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getOrders()
        myAccountBinding = viewBinding as FragmentMyAccountBinding
        optionsAdapter = MyAccountOptionsListAdapter(requireContext())
        ordersAdapter = MyAccountOrdersListAdapter(requireContext())
        myAccountBinding.optionsAdapter = optionsAdapter
        myAccountBinding.ordersAdapter = ordersAdapter
        setupPager()
        myAccountBinding.lifecycleOwner = this
        myAccountBinding.executePendingBindings()
        viewModel.ordersListLiveData.observe(viewLifecycleOwner) { orders ->
            ordersAdapter.clear()
            ordersAdapter.setItems(orders)
            refreshTab()
            myAccountBinding.myAccountRefLayout.isRefreshing = false
        }
        viewModel.errorMsgLiveData.observe(viewLifecycleOwner, errorMsgObserver)
        myAccountBinding.myAccountRefLayout.setOnRefreshListener {
            viewModel.isRefreshing.postValue(true)
            viewModel.getOrders()
        }
    }

    private fun setupPager() {
        myAccountBinding.ordersPager.offscreenPageLimit = 1
        val nextItemVisibleWidth = requireContext().dpToPx(20)
        val currentItemMargin = requireContext().dpToPx(12)
        val pageTranslation = nextItemVisibleWidth + currentItemMargin
        myAccountBinding.ordersPager.setPageTransformer { page: View, position: Float ->
            page.translationX = -pageTranslation * position
            page.scaleY = 1 - (0.25f * kotlin.math.abs(position))
            page.alpha = 0.25f + (1 - kotlin.math.abs(position))
        }
        val itemDecoration = PagerMarginItemDecoration(
            requireContext(), requireContext().dpToPx(20)
        )
        myAccountBinding.ordersPager.addItemDecoration(itemDecoration)
    }

    private fun refreshTab() {
        TabLayoutMediator(myAccountBinding.ordersDotsTab, myAccountBinding.ordersPager) { tab, position ->
        }.attach()
    }
    private val errorMsgObserver = EventObserver<String?> {
        ordersAdapter.clear()
        refreshTab()
        myAccountBinding.myAccountRefLayout.isRefreshing = false
        requireContext().toastShortMsg(it)
    }
}