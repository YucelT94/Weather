package com.yucelt.base.ui.bottomsheet

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import com.yucelt.base.domain.Resource

abstract class BaseBottomSheetViewModel constructor(
    application: Application
) : AndroidViewModel(application), LifecycleObserver {

    abstract val resourceLiveData: LiveData<Resource<*>>
}