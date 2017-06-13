@file:JvmName("FragmentExtensions")
@file:Suppress("NOTHING_TO_INLINE", "unused")
package io.milkcan.effortlessandroid

import android.app.Fragment

/**
 * A collection of helpful functions that extend [Fragment].
 *
 * @author Eric Bachhuber (bachhuberdesign@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 */

/**
 * @param resourceId
 */
inline fun Fragment.toast(resourceId: Int) = activity.toast(resourceId)

/**
 * @param message
 */
inline fun Fragment.toast(message: String) = activity.toast(message)

/**
 * @param resourceId
 */
inline fun Fragment.toastLong(resourceId: Int) = activity.toast(resourceId)

/**
 * @param message
 */
inline fun Fragment.toastLong(message: String) = activity.toast(message)