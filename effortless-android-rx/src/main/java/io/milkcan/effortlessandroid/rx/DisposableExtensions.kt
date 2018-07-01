@file:JvmName("DisposableExtensions")
@file:Suppress("NOTHING_TO_INLINE", "unused")

package io.milkcan.effortlessandroid.rx

import io.reactivex.disposables.Disposable

/**
 * A collection of helper extensions for [Disposable].
 *
 * @author Eric Bachhuber (bachhuberdesign@gmail.com)
 * @version 1.1.1
 * @since 1.1.0
 */

/**
 * Helper to safely dispose a [Disposable] if it is not null and is not currently disposed.
 *
 * @return True if the [Disposable] was disposed by this call.
 */
inline fun Disposable?.safeDispose(): Boolean {
    return if (this != null && !this.isDisposed) {
        this.dispose()
        true
    } else {
        false
    }
}
