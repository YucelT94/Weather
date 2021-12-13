package com.yucelt.weather.ui.favorite

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.yucelt.base.domain.Resource
import com.yucelt.base.domain.ResourceState
import com.yucelt.base.ui.fragment.BaseViewModel
import com.yucelt.domain.model.FavoriteCity
import com.yucelt.domain.usecase.GetAllFavoriteCitiesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val getAllFavoriteCitiesUseCase: GetAllFavoriteCitiesUseCase,
    application: Application
) : BaseViewModel(application) {
    override val resourceLiveData: MutableLiveData<Resource<*>>
        get() = _resource

    private val _resource = MutableLiveData<Resource<*>>()

    val favoriteListLiveData: MutableLiveData<List<FavoriteCity>>
        get() = _favoriteList

    private val _favoriteList = MutableLiveData<List<FavoriteCity>>()

    fun getAllFavoriteCities() {
        viewModelScope.launch {
            val response = getAllFavoriteCitiesUseCase.execute()
            _resource.postValue(response)
            if (response.status == ResourceState.SUCCESS) {
                response.data?.let { data ->
                    _favoriteList.postValue(data)
                }
            }
        }
    }
}