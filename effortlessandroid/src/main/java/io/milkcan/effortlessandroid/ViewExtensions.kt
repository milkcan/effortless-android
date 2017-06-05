@file:JvmName("ViewExtensions")

package io.milkcan.effortlessandroid

import android.view.View

/**
 * A collection of helpful functions that extend [View].
 *
 * @author Eric Bachhuber (bachhuberdesign@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 */

/**
 * Sets a view's visibility to [View.VISIBLE].
 */
fun View.visible() {
    visibility = View.VISIBLE
}

/**
 * Sets a view's visibility to [View.INVISIBLE].
 */
fun View.invisible() {
    visibility = View.INVISIBLE
}

/**
 * Sets a view's visibility to [View.GONE].
 */
fun View.gone() {
    visibility = View.GONE
}

/**
 * Sets a view to gone if currently visible, or visible if it is currently gone or invisible.
 */
fun View.toggleVisibility(): Unit = if (visibility == View.VISIBLE) gone() else visible()