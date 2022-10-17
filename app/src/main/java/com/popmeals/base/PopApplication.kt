package com.popmeals.base

import android.app.Application
import com.popmeals.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

class PopApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PopApplication)
            loadKoinModules(
                appModules
            )
        }
    }
}