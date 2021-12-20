package com.yucelt.weather.component.temperature

import androidx.databinding.ObservableField
import com.yucelt.base.component.BaseComponentViewObserver


class TemperatureViewObserver : BaseComponentViewObserver<TemperatureViewData>() {

    var viewDataObservableField = ObservableField<TemperatureViewData>()

    override fun handleInput(viewData: TemperatureViewData?) {
        viewData?.run {
            viewDataObservableField.set(viewData)
        }
    }
}
