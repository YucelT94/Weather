package com.yucelt.base.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewStub
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.yucelt.base.R
import com.yucelt.base.domain.ResourceState
import com.yucelt.common.extensions.showToast

abstract class BaseFragment<DB : ViewDataBinding, VM : BaseViewModel> : Fragment() {

    lateinit var navigationController: NavController

    var dataBinding: DB? = null
    var viewModel: VM? = null

    private var containerView: ViewStub? = null

    private var rootView: View? = null
    private var progressBar: ProgressBar? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.base_fragment, container, false)
        containerView = rootView?.findViewById(R.id.base_fragment_container)
        progressBar = rootView?.findViewById(R.id.progress_bar)

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
        navigationController = Navigation.findNavController(view)
        this.bindViewModel(this.dataBinding)
    }

    private fun observeRequestStatus() {
        viewModel?.resourceLiveData?.observe(viewLifecycleOwner, { resourceState ->
            if (resourceState != null) {
                when (resourceState.status) {
                    ResourceState.LOADING -> {
                        progressBar?.visibility = View.VISIBLE
                    }
                    ResourceState.SUCCESS -> {
                        progressBar?.visibility = View.GONE
                    }
                    ResourceState.ERROR -> {
                        progressBar?.visibility = View.GONE
                        resourceState.message?.let { message ->
                            (activity as AppCompatActivity).showToast(message)
                        }
                    }
                }
            }
        })
    }

    abstract fun provideViewModel(): Class<VM>

    abstract fun bindViewModel(binding: DB?)

    abstract fun provideLayoutId(): Int
}