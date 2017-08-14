@file:JvmName("AnyExtensions")
@file:Suppress("NOTHING_TO_INLINE", "unused")

package io.milkcan.effortlessandroid.stdlib

/**
 * @author Eric Bachhuber (bachhuberdesign@gmail.com)
 * @version 1.0.4
 * @since 1.0.4
 */

/**
 * @return The name of the class.
 */
fun Any.className(): String = this::class.java.name

/**
 * @return The simple name of the class.
 */
fun Any.classSimpleName(): String = this::class.java.simpleName

/**
 * @return The canonical name of the class.
 */
fun Any.classCanonicalName(): String = this::class.java.canonicalName