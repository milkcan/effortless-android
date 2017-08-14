@file:JvmName("DateExtensions")
@file:Suppress("NOTHING_TO_INLINE", "unused")

package io.milkcan.effortlessandroid.stdlib

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 * @author Eric Bachhuber (bachhuberdesign@gmail.com)
 * @version 1.0.4
 * @since 1.0.4
 */

/**
 * @param format
 * @return
 */
fun Date.asString(format: String): String = asString(SimpleDateFormat(format))

/**
 * @param format
 * @return
 */
fun Date.asString(format: DateFormat): String = format.format(this)
