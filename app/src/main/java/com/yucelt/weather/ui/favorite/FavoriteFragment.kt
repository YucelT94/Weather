package com.yucelt.weather.ui.favorite

import com.yucelt.base.ui.fragment.BaseFragment
import com.yucelt.weather.R
import com.yucelt.weather.databinding.FavoriteFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : BaseFragment<FavoriteFragmentBinding, FavoriteViewModel>() {
    companion object {
        val TAG = FavoriteFragment::class.java.simpleName
        private const val LAYOUT_RES_ID = R.layout.favorite_fragment

        fun newInstance() = FavoriteFragment()
    }

    override fun provideViewModel() = FavoriteViewModel::class.java

    override fun provideLayoutId() = LAYOUT_RES_ID

    override fun bindViewModel(binding: FavoriteFragmentBinding?) {
        binding?.viewModel = viewModel
        viewModel?.getAllFavoriteCities()
    }
}