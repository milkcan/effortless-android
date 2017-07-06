@file:JvmName("BooleanExtensions")
@file:Suppress("NOTHING_TO_INLINE", "unused")

package io.milkcan.effortlessandroid.stdlib

/**
 * @author Eric Bachhuber (bachhuberdesign@gmail.com)
 * @version 1.0.2
 * @since 1.0.2
 */

/**
 * @return 1 if the [Boolean] value is true, 0 if false.
 */
inline fun Boolean.asInt(): Int = if (this) 1 else 0

/**
 * Provides a "Kotlinized" ternary operator similar to Java.
 *
 * Original source: https://stackoverflow.com/questions/16336500/kotlin-ternary-conditional-operator/39687177#39687177
 */
inline infix fun <T> Boolean.then(t: T): T? = if (this) t else null