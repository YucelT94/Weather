package com.yucelt.weather.component.temperature

import android.content.Context
import android.util.AttributeSet
import androidx.databinding.BindingAdapter
import com.yucelt.base.component.BaseComponentView
import com.yucelt.weather.R
import com.yucelt.weather.databinding.ComponentTemperatureViewBinding

@BindingAdapter("viewData")
fun TemperatureView.setData(viewData: TemperatureViewData?) {
    viewData?.let { viewObserver?.handleInput(it) }
}

/**
 * Usage:
 * <com.yucelt.weather.component.temperature.TemperatureView
 *      viewData="@{viewModel.viewDataObservableField}" />
 */
class TemperatureView :
    BaseComponentView<ComponentTemperatureViewBinding, TemperatureViewObserver> {

    companion object {
        const val LAYOUT_RES_ID = R.layout.component_temperature_view
    }

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun provideLayoutId() = LAYOUT_RES_ID

    override fun provideViewModel() = TemperatureViewObserver()

    override fun bindViewModel(binding: ComponentTemperatureViewBinding?) {
        binding?.viewObserver = viewObserver
    }
}