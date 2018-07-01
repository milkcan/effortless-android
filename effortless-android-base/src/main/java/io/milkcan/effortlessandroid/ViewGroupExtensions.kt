@file:JvmName("ViewGroupExtensions")
@file:Suppress("NOTHING_TO_INLINE", "unused")

package io.milkcan.effortlessandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * A collection of helpful functions that extend [ViewGroup].
 *
 * @author Eric Bachhuber (bachhuberdesign@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 */

/**
 * @param layoutRes Int resource of the layout that will be inflated.
 * @return The inflated [View].
 */
fun ViewGroup.inflate(layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}

/**
 * @param position The position at which to get the view from.
 * @return The [View] contained within [ViewGroup] at [position], or null if the position does not
 * exist within the [ViewGroup].
 */
operator fun ViewGroup.get(position: Int): View? = getChildAt(position)

/**
 * Check if [childView] is contained within the given [ViewGroup].
 *
 * @param childView The [View] to check.
 * @return True if ViewGroup contains [childView].
 */
fun ViewGroup.contains(childView: View): Boolean = indexOfChild(childView) != -1

/**
 * Iterates through the given [ViewGroup].
 *
 * @param action The action to perform during each iteration.
 * @see [ViewGroup.forEachIndexed]
 */
inline fun ViewGroup.forEach(action: (View) -> Unit) {
    (0 until childCount).forEach { i ->
        action(getChildAt(i))
    }
}

/**
 * Iterates through the given [ViewGroup] with the index exposed.
 *
 * @param action The action to perform during each iteration.
 * @see [ViewGroup.forEach]
 */
inline fun ViewGroup.forEachIndexed(action: (Int, View) -> Unit) {
    (0 until childCount).forEach { i ->
        action(i, getChildAt(i))
    }
}
