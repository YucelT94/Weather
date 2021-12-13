package com.yucelt.base.ui.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewStub
import android.widget.ProgressBar
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.yucelt.base.R
import com.yucelt.base.domain.ResourceState
import com.yucelt.common.extensions.showToast
import com.yucelt.common.extensions.toGone
import com.yucelt.common.extensions.toVisible

abstract class BaseBottomSheetFragment<DB : ViewDataBinding, VM : BaseBottomSheetViewModel> :
    BottomSheetDialogFragment() {

    var dataBinding: DB? = null
    var viewModel: VM? = null

    private var containerView: ViewStub? = null

    private var rootView: View? = null
    private var titleView: AppCompatTextView? = null
    private var progressBar: ProgressBar? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.base_bottom_sheet_fragment, container, false)
        containerView = rootView?.findViewById(R.id.bottom_sheet_container)
        titleView = rootView?.findViewById(R.id.bottom_sheet_title)
        progressBar = rootView?.findViewById(R.id.progress_bar)

        titleView?.text = provideTitle()
        containerView?.layoutResource = provideLayoutId()

        if (containerView != null) {
            val inflatedView = containerView!!.inflate()
            dataBinding = DataBindingUtil.bind<DB>(inflatedView)
            dataBinding?.lifecycleOwner = this
        }

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.viewModel = ViewModelProvider(this).get(provideViewModel())
        viewModel?.let { lifecycle.addObserver(it) }
        observeRequestStatus()
        this.bindViewModel(this.dataBinding)
    }

    private fun observeRequestStatus() {
        viewModel?.resourceLiveData?.observe(viewLifecycleOwner, { resourceState ->
            if (resourceState != null) {
                when (resourceState.status) {
                    ResourceState.LOADING -> {
                        progressBar?.toVisible()
                    }
                    ResourceState.SUCCESS -> {
                        progressBar?.toGone()
                    }
                    ResourceState.ERROR -> {
                        progressBar?.toGone()
                        resourceState.message?.let { message ->
                            (activity as AppCompatActivity).showToast(message)
                        }
                    }
                }
            }
        })
    }

    @LayoutRes
    abstract fun provideLayoutId(): Int

    abstract fun provideViewModel(): Class<VM>

    abstract fun provideTitle(): String

    abstract fun bindViewModel(binding: DB?)
}
