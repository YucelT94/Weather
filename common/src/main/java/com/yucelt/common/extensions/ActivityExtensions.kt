package com.yucelt.common.extensions

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast

fun Activity.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Activity.hideKeyboard() {
    val imm: InputMethodManager =
        this.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    var view: View? = this.currentFocus
    if (view == null) {
        view = View(this)
    }
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}

fun Activity.setSoftInputMode(layoutParams: Int) {
    this.window.setSoftInputMode(layoutParams)
}
