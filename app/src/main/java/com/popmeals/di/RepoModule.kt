package com.popmeals.di
import com.popmeals.modules.myaccount.MyAccountApi
import com.popmeals.modules.myaccount.repository.MyAccountRepo
import com.popmeals.network.ServiceGenerator
import org.koin.dsl.module

val repoModule = module {
    single {
        MyAccountRepo(get())
    }
}