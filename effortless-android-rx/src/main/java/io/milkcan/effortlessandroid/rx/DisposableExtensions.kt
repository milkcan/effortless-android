@file:JvmName("DisposableExtensions")
@file:Suppress("NOTHING_TO_INLINE", "unused")

package io.milkcan.effortlessandroid.rx

import io.reactivex.disposables.Disposable

/**
 * @author Eric Bachhuber (bachhuberdesign@gmail.com)
 * @version 1.1.1
 * @since 1.1.0
 */

/**
 * @return True if the [Disposable] was disposed by this call. False if the Disposable is null or if
 * it was previously disposed before calling this function.
 */
inline fun Disposable?.safeDispose(): Boolean {
    return if (this != null && !this.isDisposed) {
        this.dispose()
        true
    } else {
        false
    }
}
