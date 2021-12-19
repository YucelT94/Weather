package com.yucelt.weather.ui.favorite

import com.yucelt.base.ui.fragment.BaseFragment
import com.yucelt.common.extensions.showToast
import com.yucelt.domain.model.FavoriteCity
import com.yucelt.weather.R
import com.yucelt.weather.databinding.FavoriteFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : BaseFragment<FavoriteFragmentBinding, FavoriteViewModel>(),
    FavoriteListAdapter.FavoriteCityEventHandler {
    companion object {
        val TAG = FavoriteFragment::class.java.simpleName
        private const val LAYOUT_RES_ID = R.layout.favorite_fragment
    }

    override fun provideViewModel() = FavoriteViewModel::class.java

    override fun provideLayoutId() = LAYOUT_RES_ID

    override fun bindViewModel(binding: FavoriteFragmentBinding?) {
        binding?.viewModel = viewModel
        viewModel?.getAllFavoriteCities()
        setListeners()
    }

    private fun setListeners() {
        viewModel?.run {
            favoriteListLiveData.observe(viewLifecycleOwner, {
                if (it.isNotEmpty()) {
                    dataBinding?.run {
                        val adapter = FavoriteListAdapter()
                        adapter.eventHandler = this@FavoriteFragment
                        adapter.submitData(it)
                        favoriteCityList.setHasFixedSize(true)
                        favoriteCityList.adapter = adapter
                    }
                }
            })
        }
    }

    override fun onFavoriteCityClicked(viewData: FavoriteCity) {
        activity?.showToast("${viewData.id} ${viewData.name}")
    }
}