@file:JvmName("ViewExtensions")
@file:Suppress("NOTHING_TO_INLINE", "unused")

package io.milkcan.effortlessandroid

import android.view.View
import io.milkcan.effortlessandroid.adapter.DelayedOnClickListener

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

/**
 * Sets a click listener that ignores subsequent clicks within a certain threshold. By default, any
 * clicks within 500 milliseconds of the initial click are ignored. Use when you want to prevent
 * accidental double clicks on a View.
 *
 * @param function The function to be executed when [View] is clicked.
 * @see View.setDelayedOnClickListener(function, int)
 */
inline fun View.setDelayedOnClickListener(crossinline function: (view: View) -> Unit) {
    this.setOnClickListener(object : DelayedOnClickListener(500) {
        override fun onSingleClick(view: View) = function(view)
    })
}

/**
 * Sets a click listener that ignores subsequent clicks within a certain threshold.
 *
 * @param function The function to be executed when [View] is clicked.
 * @param delayMilliseconds Duration before the click listener is active again.
 */
inline fun View.setDelayedOnClickListener(crossinline function: () -> Unit, delayMilliseconds: Int) {
    this.setOnClickListener(object : DelayedOnClickListener(delayMilliseconds) {
        override fun onSingleClick(view: View) = function()
    })
}
