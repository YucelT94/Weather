package com.yucelt.common.util

import android.content.Context
import android.util.TypedValue

object ViewUtils {
    internal fun getPixels(context: Context, valueInDp: Int): Int {
        val resources = context.resources
        val pixels = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, valueInDp.toFloat(), resources.displayMetrics)
        return pixels.toInt()
    }

    internal fun getPixels(context: Context, valueInDp: Float): Int {
        val resources = context.resources
        val pixels = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, valueInDp, resources.displayMetrics)
        return pixels.toInt()
    }

    internal fun getPixelsSp(context: Context, valueInSp: Int): Int {
        val resources = context.resources
        val pixels = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, valueInSp.toFloat(), resources.displayMetrics)
        return pixels.toInt()
    }

    internal fun getPixelsSp(context: Context, valueInSp: Float): Int {
        val resources = context.resources
        val pixels = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, valueInSp, resources.displayMetrics)
        return pixels.toInt()
    }
}
