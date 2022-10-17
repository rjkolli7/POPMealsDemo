package com.popmeals.utils

import android.content.Context
import android.util.DisplayMetrics
import android.widget.Toast
import kotlin.math.roundToInt

fun Context.dpToPx(dp: Int) : Int {
    val displayMetrics = resources.displayMetrics
    return (dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT)).roundToInt()
}

fun Context.toastShortMsg(msg: String?) {
    if (!msg.isNullOrBlank()) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}