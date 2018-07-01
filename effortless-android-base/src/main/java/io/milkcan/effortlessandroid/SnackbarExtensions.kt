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
 * @version 1.1.1
 * @since 1.0.4
 */

/**
 * Helper function to easily display a [Snackbar] in the given [View]. If a non-null [actionText]
 * parameter is passed, the [Snackbar] will be displayed with an action that runs function [action]
 * when clicked.
 *
 * @param message The message to display in the [Snackbar].
 * @param length The length to display the [Snackbar]. Valid values are [Snackbar.LENGTH_SHORT],
 * [Snackbar.LENGTH_LONG], and [Snackbar.LENGTH_INDEFINITE]
 * @param actionText The text to display for the [Snackbar]'s action. Defaults to null.
 * @param action The function to run when the [Snackbar] action is clicked.
 */
fun View.snack(
        message: String,
        length: Int = Snackbar.LENGTH_LONG,
        actionText: String? = null,
        action: (() -> Unit) = {}
): Snackbar {
    val snackbar = Snackbar.make(this, message, length).apply { animationBugWorkaround(this) }

    actionText?.let { snackbar.setAction(it) { action() } }

    snackbar.show()

    return snackbar
}

/**
 * Helper function to easily display a [Snackbar] in the given [View]. If a non-null [actionText]
 * parameter is passed, the [Snackbar] will be displayed with an action that runs function [action]
 * when clicked.
 *
 * @param message The message to display in the [Snackbar].
 * @param length The length to display the [Snackbar]. Valid values are [Snackbar.LENGTH_SHORT],
 * [Snackbar.LENGTH_LONG], and [Snackbar.LENGTH_INDEFINITE]
 * @param actionText The text to display for the [Snackbar]'s action. Defaults to null.
 * @param action The function to run when the [Snackbar] action is clicked.
 */
fun View.snack(
        @StringRes message: Int,
        length: Int = Snackbar.LENGTH_LONG,
        actionText: String? = null,
        action: (() -> Unit) = {}
): Snackbar {
    return snack(resources.getString(message), length, actionText, action)
}

/**
 * Helper function to easily display a [Snackbar] in the given [Fragment]. If a non-null [actionText]
 * parameter is passed, the [Snackbar] will be displayed with an action that runs function [action]
 * when clicked.
 *
 * @param message The message to display in the [Snackbar].
 * @param length The length to display the [Snackbar]. Valid values are [Snackbar.LENGTH_SHORT],
 * [Snackbar.LENGTH_LONG], and [Snackbar.LENGTH_INDEFINITE]
 * @param actionText The text to display for the [Snackbar]'s action. Defaults to null.
 * @param action The function to run when the [Snackbar] action is clicked.
 */
fun Fragment.snack(
        message: String,
        length: Int = Snackbar.LENGTH_LONG,
        actionText: String? = null,
        action: (() -> Unit) = {}
): Snackbar? {
    if (this.view == null) {
        return null
    }

    val snackbar = Snackbar.make(this.view!!, message, length).apply { animationBugWorkaround(this) }

    actionText?.let { snackbar.setAction(it) { action() } }

    snackbar.show()

    return snackbar
}

/**
 * Helper function to easily display a [Snackbar] in the given [Fragment]. If a non-null [actionText]
 * parameter is passed, the [Snackbar] will be displayed with an action that runs function [action]
 * when clicked.
 *
 * @param message The message to display in the [Snackbar].
 * @param length The length to display the [Snackbar]. Valid values are [Snackbar.LENGTH_SHORT],
 * [Snackbar.LENGTH_LONG], and [Snackbar.LENGTH_INDEFINITE]
 * @param actionText The text to display for the [Snackbar]'s action. Defaults to null.
 * @param action The function to run when the [Snackbar] action is clicked.
 */
fun Fragment.snack(
        @StringRes message: Int,
        length: Int = Snackbar.LENGTH_LONG,
        actionText: String? = null,
        action: (() -> Unit) = {}
): Snackbar? {
    if (this.view == null) {
        return null
    }

    return snack(resources.getString(message), length, actionText, action)
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
