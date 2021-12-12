package com.yucelt.weather.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.yucelt.common.manager.navigation.NavigationManager
import com.yucelt.weather.R
import com.yucelt.weather.databinding.ActivityMainBinding
import com.yucelt.weather.ui.first.FirstFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var navigationManager: NavigationManager

    private lateinit var binding: ActivityMainBinding
    private var viewModel: MainViewModel? = null

    companion object {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        this.viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel?.let { lifecycle.addObserver(it) }

        setContentView(binding.root)
        setUpNavigation()
        addInitialFragment()
    }

    private fun addInitialFragment() {
        navigationManager.openFragment(
            fragment = FirstFragment.newInstance(),
            fragmentContainer = R.id.fragment_container,
            animation = NavigationManager.Animation.FADE,
            transaction = NavigationManager.Transaction.ADD
        )
    }

    private fun setUpNavigation() {
        binding.run {
            setSupportActionBar(toolbar)
        }
    }
}