package com.popmeals.di
import com.popmeals.modules.myaccount.MyAccountApi
import com.popmeals.network.ServiceGenerator
import org.koin.dsl.module

val apiModule = module {
    single<MyAccountApi> { provideMyAccountApi() }
}

fun provideMyAccountApi() = ServiceGenerator.createService(MyAccountApi::class.java)