@file:JvmName("ViewGroupExtensions")

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
 *
 */
fun ViewGroup.inflate(layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}

/**
 * @return True if ViewGroup contains [childView].
 */
fun ViewGroup.contains(childView: View): Boolean {
    return indexOfChild(childView) != -1
}

/**
 *
 */
inline fun ViewGroup.forEach(action: (View) -> Unit) {
    (0 until childCount).forEach { i ->
        action(getChildAt(i))
    }
}

/**
 *
 */
inline fun ViewGroup.forEachIndexed(action: (Int, View) -> Unit) {
    (0 until childCount).forEach { i ->
        action(i, getChildAt(i))
    }
}