package com.popmeals.modules

import android.os.Bundle
import com.popmeals.R
import com.popmeals.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun getLayoutResId(): Int {
        return R.layout.activity_main
    }

    override fun init() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}