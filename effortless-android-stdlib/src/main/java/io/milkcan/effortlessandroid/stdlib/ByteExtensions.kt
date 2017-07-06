@file:JvmName("ByteExtensions")
@file:Suppress("NOTHING_TO_INLINE", "unused")

package io.milkcan.effortlessandroid.stdlib

/**
 * A collection of helpful functions that extend [Byte].
 *
 * @author Eric Bachhuber (bachhuberdesign@gmail.com)
 * @version 1.0.2
 * @since 1.0.2
 */

/**
 * @return Conversion of the byte to unsigned integer.
 */
inline fun Byte.toUnsignedInt(): Int = this.toInt() and 0xff