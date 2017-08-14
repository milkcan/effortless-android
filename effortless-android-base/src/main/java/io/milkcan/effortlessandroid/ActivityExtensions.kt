@file:JvmName("ActivityExtensions")
@file:Suppress("NOTHING_TO_INLINE", "unused")

package io.milkcan.effortlessandroid

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.inputmethod.InputMethodManager

/**
 * A collection of helpful functions that extend [Activity].
 *
 * @author Eric Bachhuber (bachhuberdesign@gmail.com)
 * @version 1.0.4
 * @since 1.0.0
 */

/**
 *
 */
fun Activity.hideKeyboard() {
    val inputMethodManager = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(this.window.decorView.rootView.windowToken, 0)
}
