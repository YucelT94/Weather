package com.yucelt.common.manager.navigation

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.yucelt.common.R
import javax.inject.Inject

class NavigationManager @Inject constructor(private val activity: FragmentActivity) {
    fun openFragment(
        fragment: Fragment,
        fragmentContainer: Int,
        animation: Animation = Animation.NONE,
        transaction: Transaction = Transaction.REPLACE,
        addToBackStack: Boolean = true
    ) {
        try {
            val fragmentTransaction = activity.supportFragmentManager.beginTransaction()

            when (animation) {
                Animation.HORIZONTAL -> fragmentTransaction.setCustomAnimations(
                    R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right
                )
                Animation.VERTICAL -> fragmentTransaction.setCustomAnimations(
                    R.anim.slide_in_up, R.anim.slide_out_down, R.anim.slide_in_down, R.anim.slide_out_up
                )
                Animation.FADE -> fragmentTransaction.setCustomAnimations(
                    R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out
                )
                Animation.NONE -> {
                }
            }

            when (transaction) {
                Transaction.ADD -> fragmentTransaction.add(
                    fragmentContainer, fragment, fragment.javaClass.name
                )
                Transaction.REPLACE -> fragmentTransaction.replace(
                    fragmentContainer, fragment, fragment.javaClass.name
                )
            }

            if (addToBackStack) {
                fragmentTransaction.addToBackStack(fragment.javaClass.name)
            }

            fragmentTransaction.commit()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun showHideFragment(willBeShownFragment: Fragment, willBeHidedFragment: Fragment) {
        activity.supportFragmentManager.beginTransaction()
            .hide(willBeHidedFragment)
            .show(willBeShownFragment)
            .commit()
    }

    fun popBackStack() {
        activity.supportFragmentManager.popBackStack()
    }

    fun getLastBackStackEntryName(): String? {
        return if (activity.supportFragmentManager.backStackEntryCount == 0) {
            ""
        } else {
            activity.supportFragmentManager.getBackStackEntryAt(activity.supportFragmentManager.backStackEntryCount - 1).name
        }
    }

    fun getBackStackEntryCount(): Int {
        return activity.supportFragmentManager.backStackEntryCount
    }

    fun findFragmentByTag(tag: String): Fragment? {
        return activity.supportFragmentManager.findFragmentByTag(tag)
    }

    fun restartApp() {
        // val intent = Intent(activity, SplashActivity::class.java)
        // intent.putExtra(SplashActivity.EXTRA_APP_RESTART, true)
        // activity.startActivity(intent)
        // activity.finishAffinity()
    }

    fun restartActivity(appCompatActivity: AppCompatActivity) {
        val intent = Intent(activity, appCompatActivity.javaClass)
        activity.startActivity(intent)
        activity.finishAffinity()
    }

    fun redirectToBrowser(url: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        activity.startActivity(browserIntent)
    }

    fun removeFragment(fragment: Fragment?) {

        fragment?.let {
            val fragmentTransaction = activity.supportFragmentManager.beginTransaction()
            activity.supportFragmentManager.findFragmentByTag(fragment.javaClass.name)
                ?.let { frag ->
                    fragmentTransaction.remove(
                        frag
                    ).commit()
                }

        }
    }

    enum class Transaction { ADD, REPLACE }

    enum class Animation { HORIZONTAL, VERTICAL, FADE, NONE }
}
