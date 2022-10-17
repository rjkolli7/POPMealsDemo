package com.popmeals.modules.myaccount.model

import com.google.gson.annotations.SerializedName
import com.popmeals.base.list.ListItem
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

data class OrdersResponse(
    @SerializedName("orders") val ordersList: ArrayList<OrderItem>? = null,
)

data class OrderItem(
    @SerializedName("order_id") val order_id: Int? = null,
    @SerializedName("arrives_at_utc") val arrives_at_utc: Long? = null,
    @SerializedName("paid_with") val paid_with: String? = null,
    @SerializedName("total_paid") val total_paid: Double? = null,
): ListItem {
    fun arriveAt() : String {
        arrives_at_utc?.run {
            val calender = Calendar.getInstance()
            calender.timeInMillis = this
            return SimpleDateFormat("hh:mm a", Locale.getDefault()).format(calender.time)
        }
        return ""
    }

    fun totalPaid() : String {
        total_paid?.run {
            return String.format("%2f", this)
        }
        return "0.00"
    }

    fun orderId() : String {
        order_id?.run {
            return "#${order_id}"
        }
        return ""
    }
}