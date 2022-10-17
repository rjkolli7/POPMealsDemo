package com.popmeals.modules.myaccount.model

import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import com.google.gson.annotations.SerializedName
import com.popmeals.base.list.ListItem

data class MyAccountOptionModel(
    @DrawableRes val iconResourceId: Int,
    @StringRes val title: Int,
) : ListItem
