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

// TODO: Test functions running as Snackbar actions

/**
 * Helper function to easily display a [Snackbar] in the given [View].
 *
 * @param message The message to display in the [Snackbar].
 * @param length The length to display the [Snackbar]. Valid values are [Snackbar.LENGTH_SHORT],
 * [Snackbar.LENGTH_LONG], and [Snackbar.LENGTH_INDEFINITE]
 * @param function The function to run when the [Snackbar] action is clicked.
 */
fun View.snack(message: String, length: Int = Snackbar.LENGTH_LONG, function: (Snackbar.() -> Unit) = {}) {
    val snack = Snackbar.make(this, message, length).apply { animationBugWorkaround(this) }
    snack.function()
    snack.show()
}

/**
 * Helper function to easily display a [Snackbar] in the given [View].
 *
 * @param message The message to display in the [Snackbar].
 * @param length The length to display the [Snackbar]. Valid values are [Snackbar.LENGTH_SHORT],
 * [Snackbar.LENGTH_LONG], and [Snackbar.LENGTH_INDEFINITE]
 * @param function The function to run when the [Snackbar] action is clicked.
 */
fun View.snack(@StringRes message: Int, length: Int = Snackbar.LENGTH_LONG, function: (Snackbar.() -> Unit) = {}) {
    snack(resources.getString(message), length, function)
}

/**
 * Helper function to easily display a [Snackbar] in the given [Fragment].
 *
 * @param message The message to display in the [Snackbar].
 * @param length The length to display the [Snackbar]. Valid values are [Snackbar.LENGTH_SHORT],
 * [Snackbar.LENGTH_LONG], and [Snackbar.LENGTH_INDEFINITE]
 * @param function The function to run when the [Snackbar] action is clicked.
 */
fun Fragment.snack(message: String, length: Int = Snackbar.LENGTH_LONG, function: (Snackbar.() -> Unit) = {}) {
    if (this.view == null) {
        return
    }

    val snack = Snackbar.make(this.view!!, message, length).apply { animationBugWorkaround(this) }
    snack.function()
    snack.show()
}

/**
 * Helper function to easily display a [Snackbar] in the given [Fragment].
 *
 * @param message The message to display in the [Snackbar].
 * @param length The length to display the [Snackbar]. Valid values are [Snackbar.LENGTH_SHORT],
 * [Snackbar.LENGTH_LONG], and [Snackbar.LENGTH_INDEFINITE]
 * @param function The function to run when the [Snackbar] action is clicked.
 */
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
