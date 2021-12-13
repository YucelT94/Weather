package com.yucelt.weather.ui.search

import com.yucelt.base.ui.fragment.BaseFragment
import com.yucelt.weather.R
import com.yucelt.weather.databinding.SearchFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : BaseFragment<SearchFragmentBinding, SearchViewModel>() {
    companion object {
        val TAG = SearchFragment::class.java.simpleName
        private const val LAYOUT_RES_ID = R.layout.search_fragment

        fun newInstance() = SearchFragment()
    }

    override fun provideViewModel() = SearchViewModel::class.java

    override fun provideLayoutId() = LAYOUT_RES_ID

    override fun bindViewModel(binding: SearchFragmentBinding?) {
        binding?.viewModel = viewModel
    }
}