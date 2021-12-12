package com.yucelt.common.util

import android.content.res.Resources
import android.util.TypedValue
import androidx.appcompat.app.AppCompatActivity

object WindowSizeUtils {
    fun getStatusBarSize(activity: AppCompatActivity): Int {
        var result = 0
        val resourceId = activity.resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = activity.resources.getDimensionPixelSize(resourceId)
        }
        return result
    }

    fun getWidthOfScreen(): Int {
        return Resources.getSystem().displayMetrics.widthPixels
    }

    fun getActionBarHeight(activity: AppCompatActivity): Int {
        var actionBarHeight = 0
        val typedValue = TypedValue()
        if (activity.theme.resolveAttribute(android.R.attr.actionBarSize, typedValue, true)) {
            actionBarHeight = TypedValue.complexToDimensionPixelSize(
                typedValue.data, activity.resources.displayMetrics
            )
        }
        return actionBarHeight
    }
}
