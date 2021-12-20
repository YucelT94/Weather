package com.yucelt.common.extensions

import java.text.SimpleDateFormat
import java.util.*

fun Long.toPrettyDate(): String {
    val date = if (this.mod(1000) == 0) Date(this) else Date(this * 1000)
    val formatter = SimpleDateFormat("dd MMMM EEEE, HH:mm", Locale.getDefault())
    return formatter.format(date)
}