@file:JvmName("FragmentExtensions")
@file:Suppress("NOTHING_TO_INLINE", "unused")

package io.milkcan.effortlessandroid

import android.app.Fragment
import android.support.v4.app.DialogFragment

/**
 * A collection of helper extensions for Fragments..
 *
 * @author Eric Bachhuber (bachhuberdesign@gmail.com)
 * @version 1.1.1
 * @since 1.0.0
 */

/**
 * @param resourceId The ID of the String resource to display.
 */
inline fun Fragment.toast(resourceId: Int) = activity?.toast(resourceId)

/**
 * @param resourceId The ID of the String resource to display.
 */
inline fun android.support.v4.app.Fragment.toast(resourceId: Int) = activity?.toast(resourceId)

/**
 * @param message The message to display.
 */
inline fun Fragment.toast(message: String?) = activity?.toast(message)

/**
 * @param message The message to display.
 */
inline fun android.support.v4.app.Fragment.toast(message: String?) = activity?.toast(message)

/**
 * @param resourceId The ID of the String resource to display.
 */
inline fun Fragment.toastLong(resourceId: Int) = activity?.toast(resourceId)

/**
 * @param resourceId The ID of the String resource to display.
 */
inline fun android.support.v4.app.Fragment.toastLong(resourceId: Int) = activity?.toast(resourceId)

/**
 * @param message The message to display.
 */
inline fun Fragment.toastLong(message: String?) = activity?.toast(message)

/**
 * @param message The message to display.
 */
inline fun android.support.v4.app.Fragment.toastLong(message: String?) = activity?.toast(message)

/**
 * Helper to safely dismiss a [DialogFragment] if it is not null and is currently added to the view.
 *
 * @param allowStateLoss If true, [DialogFragment.dismissAllowingStateLoss] will be used rather
 * than [DialogFragment.dismiss].
 * @return True if dismiss on the [DialogFragment] was called.
 */
inline fun DialogFragment?.safeDismiss(allowStateLoss: Boolean = true): Boolean {
    return if (this != null && this.isAdded) {
        if (allowStateLoss) this.dismissAllowingStateLoss() else this.dismiss()

        true
    } else {
        false
    }
}
