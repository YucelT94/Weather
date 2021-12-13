package com.yucelt.weather.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.yucelt.weather.R
import com.yucelt.weather.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navigationController: NavController
    private lateinit var dataBinding: ActivityMainBinding
    private var viewModel: MainViewModel? = null

    private val listener =
        NavController.OnDestinationChangedListener { _, destination, _ ->
            dataBinding.toolbar.title = destination.label
        }

    companion object {
        val TAG = MainActivity::class.java.name
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(dataBinding.root)

        setUpViewModel()
        setUpToolbar()
        setUpNavigation()
    }

    override fun onSupportNavigateUp(): Boolean {
        navigationController.navigateUp()
        return super.onSupportNavigateUp()
    }

    override fun onResume() {
        super.onResume()
        navigationController.addOnDestinationChangedListener(listener)
    }

    override fun onPause() {
        navigationController.removeOnDestinationChangedListener(listener)
        super.onPause()
    }

    private fun setUpToolbar() {
        setSupportActionBar(dataBinding.toolbar)
    }

    private fun setUpViewModel() {
        this.viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel?.let { lifecycle.addObserver(it) }
    }

    private fun setUpNavigation() {
        dataBinding.run {
            navigationController = findNavController(R.id.main_navigation_host)

            val appBarConfiguration = AppBarConfiguration(
                setOf(
                    R.id.navigation_first, R.id.navigation_second, R.id.navigation_third
                )
            )

            setupActionBarWithNavController(navigationController, appBarConfiguration)
            bottomNavigation.setupWithNavController(navigationController)
        }
    }
}