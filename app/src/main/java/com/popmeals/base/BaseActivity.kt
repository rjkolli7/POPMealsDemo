package com.popmeals.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    /**
     * Get layout resource id which inflate in onCreate.
     */
    @LayoutRes
    abstract fun getLayoutResId(): Int

    abstract fun init()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
        init()
    }
}