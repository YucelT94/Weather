package com.yucelt.common.binding

import android.view.View
import androidx.databinding.BindingAdapter


object CommonBindingAdapter {
    /**
     * View
     */
    @BindingAdapter("visibleGone")
    @JvmStatic
    fun View.bindVisibleGone(isVisible: Boolean?) {
        this.visibility = if (isVisible == true) View.VISIBLE else View.GONE
    }
} 