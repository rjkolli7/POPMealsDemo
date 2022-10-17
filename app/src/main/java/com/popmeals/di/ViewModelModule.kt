package com.popmeals.di

import com.popmeals.modules.myaccount.viewmodel.MyAccountVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        MyAccountVM(get(), get())
    }
}