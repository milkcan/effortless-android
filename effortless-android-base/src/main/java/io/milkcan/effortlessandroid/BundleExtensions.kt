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
 * @param tag
 */
inline fun Bundle?.printExtras(tag: String = "Bundle Extras") {
    this?.keySet()?.forEach { key ->
        this.get(key)?.let {
            d(tag, "$key, $it, ${it::class.java.name}")
        }
    }
}