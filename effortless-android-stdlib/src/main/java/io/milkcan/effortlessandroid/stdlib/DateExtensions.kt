@file:JvmName("DateExtensions")
@file:Suppress("NOTHING_TO_INLINE", "unused")

package io.milkcan.effortlessandroid.stdlib

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 * @author Eric Bachhuber (bachhuberdesign@gmail.com)
 * @version 1.1.1
 * @since 1.0.4
 */

/**
 * Builds a [String] representation of the given date using the [format] provided.
 *
 * @param format The format to use when building the string.
 * @return The given [Date] formatted as a String.
 * @see [https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html]
 */
fun Date.asString(format: String): String = asString(SimpleDateFormat(format, Locale.getDefault()))

/**
 * Builds a [String] representation of the given date using the [format] provided.
 *
 * @param format The [DateFormat] to use when building the string.
 * @return The given [Date] formatted as a String.
 * @see [https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html]
 */
fun Date.asString(format: DateFormat): String = format.format(this)
