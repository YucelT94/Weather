package com.yucelt.weather.ui.third

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.yucelt.base.domain.Resource
import com.yucelt.base.ui.fragment.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ThirdViewModel @Inject constructor(
    application: Application
) : BaseViewModel(application) {
    override val resourceLiveData: MutableLiveData<Resource<*>>
        get() = _resource

    private val _resource = MutableLiveData<Resource<*>>()
}