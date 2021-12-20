package com.yucelt.common.binding

import android.annotation.SuppressLint
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
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

    /**
     * AppCompatImageView
     */
    @SuppressLint("UseCompatLoadingForDrawables")
    @BindingAdapter("setImageResId")
    @JvmStatic
    fun AppCompatImageView.bindResId(imageResId: Int?) {
        imageResId?.let {
            if (it != -1 && it != 0) {
                val drawable = this.context.getDrawable(it)
                drawable?.let { imageRes -> this.setImageDrawable(imageRes) }
            } else {
                this.visibility == View.GONE
            }
        }
    }
} 