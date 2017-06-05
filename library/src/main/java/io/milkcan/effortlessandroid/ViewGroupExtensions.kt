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
