@file:JvmName("SnackbarExtensions")
@file:Suppress("NOTHING_TO_INLINE", "unused")

package io.milkcan.effortlessandroid

import android.support.annotation.StringRes
import android.support.design.widget.BaseTransientBottomBar
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.View
import android.view.accessibility.AccessibilityManager

/**
 * @author Eric Bachhuber (bachhuberdesign@gmail.com)
 * @version 1.0.4
 * @since 1.0.4
 */

fun View.snack(message: String, length: Int = Snackbar.LENGTH_LONG, function: (Snackbar.() -> Unit) = {}) {
    val snack = Snackbar.make(this, message, length).apply { animationBugWorkaround(this) }
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

    val snack = Snackbar.make(this.view!!, message, length).apply { animationBugWorkaround(this) }
    snack.function()
    snack.show()
}

fun Fragment.snack(@StringRes message: Int, length: Int = Snackbar.LENGTH_LONG, function: (Snackbar.() -> Unit) = {}) {
    if (this.view == null) {
        return
    }

    snack(resources.getString(message), length, function)
}

/**
 * Reflection hack to enable Snackbar animation when accessibility features are enabled on the
 * device (i.e. password manager auto-fill, screen readers, etc.).
 *
 * Credit for workaround : https://stackoverflow.com/a/43811447/5564847
 * Details about bug : https://issuetracker.google.com/issues/37092972
 */
private fun animationBugWorkaround(snackbar: Snackbar) {
    try {
        val mAccessibilityManagerField = BaseTransientBottomBar::class.java.getDeclaredField("mAccessibilityManager")
        mAccessibilityManagerField.isAccessible = true

        val accessibilityManager = mAccessibilityManagerField.get(snackbar)
        val mIsEnabledField = AccessibilityManager::class.java.getDeclaredField("mIsEnabled")
        mIsEnabledField.isAccessible = true
        mIsEnabledField.setBoolean(accessibilityManager, false)
        mAccessibilityManagerField.set(snackbar, accessibilityManager)
    } catch (e: Exception) {
        e("Snackbar", "Reflection error: $e", e)
    }
}
