@file:JvmName("DisposableExtensions")
@file:Suppress("NOTHING_TO_INLINE", "unused")

package io.milkcan.effortlessandroid.rx

import io.reactivex.disposables.Disposable

/**
 * @author Eric Bachhuber (bachhuberdesign@gmail.com)
 * @version 1.0.5
 * @since 1.0.5
 */

inline fun Disposable?.safeDispose() {
    if (this != null && !this.isDisposed) {
        this.dispose()
    }
}
