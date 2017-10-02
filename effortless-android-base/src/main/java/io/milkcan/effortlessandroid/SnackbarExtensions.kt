@file:JvmName("SnackbarExtensions")
@file:Suppress("NOTHING_TO_INLINE", "unused")

package io.milkcan.effortlessandroid

import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.View

/**
 * @author Eric Bachhuber (bachhuberdesign@gmail.com)
 * @version 1.0.3
 * @since 1.0.3
 */

fun View.snack(message: String, length: Int = Snackbar.LENGTH_LONG, function: (Snackbar.() -> Unit) = {}) {
    val snack = Snackbar.make(this, message, length)
    snack.function()
    snack.show()
}

fun View.snack(@StringRes message: Int, length: Int = Snackbar.LENGTH_LONG, function: (Snackbar.() -> Unit) = {}) {
    snack(resources.getString(message), length, function)
}

fun Fragment.snack(message: String, length: Int = Snackbar.LENGTH_LONG, function: (Snackbar.() -> Unit) = {}) {
    if (this.view == null) {
        return
    }

    val snack = Snackbar.make(this.view!!, message, length)
    snack.function()
    snack.show()
}

fun Fragment.snack(@StringRes message: Int, length: Int = Snackbar.LENGTH_LONG, function: (Snackbar.() -> Unit) = {}) {
    if (this.view == null) {
        return
    }

    snack(resources.getString(message), length, function)
}