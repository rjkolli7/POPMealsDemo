package com.popmeals.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.popmeals.event.EventObserver
import com.popmeals.utils.toastShortMsg
import kotlinx.coroutines.internal.SynchronizedObject

abstract class BaseFragment: Fragment() {

    /**
     * Get layout resource id which inflate in onCreateView.
     */
    @LayoutRes
    abstract fun getLayoutResId(): Int

    lateinit var viewBinding: ViewBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false)
        return viewBinding.root
    }
}