@file:JvmName("BundleExtensions")
@file:Suppress("NOTHING_TO_INLINE", "unused")

package io.milkcan.effortlessandroid

import android.os.Bundle

/**
 * A collection of helpful functions that extend [Bundle].
 *
 * @author Eric Bachhuber (bachhuberdesign@gmail.com)
 * @version 1.1.0
 * @since 1.1.0
 */

/**
 * Iterate through all keys in a Bundle (if any), and prints the key:value pair to debug log.
 * Useful for discovering unknown values that are passed in an Intent.
 *
 * @param tag Tag for the debug output log. Defaults to "Bundle Extras".
 */
inline fun Bundle?.printExtras(tag: String = "Bundle Extras") {
    this?.keySet()?.forEach { key ->
        this.get(key)?.let {
            d(tag, "$key, $it, ${it::class.java.name}")
        }
    }
}