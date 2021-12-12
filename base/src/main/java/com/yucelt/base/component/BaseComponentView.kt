package com.yucelt.base.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseComponentView<DB : ViewDataBinding, VM : BaseComponentViewObserver<*>>(
    context: Context,
    attributeSet: AttributeSet? = null,
    int: Int = 0
) : ConstraintLayout(context, attributeSet, int) {
    var dataBinding: DB? = null
    var viewModel: VM? = null

    init {
        this.init(context)
    }

    private fun init(context: Context) {
        if (this.isInEditMode) {
            View.inflate(context, this.provideLayoutId(), this)
        } else {
            this.viewModel = this.provideViewModel()
            this.dataBinding = DataBindingUtil.inflate(
                LayoutInflater.from(context),
                this.provideLayoutId(),
                this,
                true
            )
            this.bindViewModel(this.dataBinding)
        }
    }

    abstract fun provideViewModel(): VM

    abstract fun bindViewModel(binding: DB?)

    abstract fun provideLayoutId(): Int
}
