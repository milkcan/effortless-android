@file:JvmName("BooleanExtensions")
@file:Suppress("NOTHING_TO_INLINE", "unused")

package io.milkcan.effortlessandroid.stdlib

/**
 * A collection of helpful functions that extend [Boolean].
 *
 * @author Eric Bachhuber (bachhuberdesign@gmail.com)
 * @version 1.1.0
 * @since 1.0.2
 */

/**
 * @return 1 if the [Boolean] value is true, 0 if false.
 */
inline fun Boolean.toInt(): Int = if (this) 1 else 0