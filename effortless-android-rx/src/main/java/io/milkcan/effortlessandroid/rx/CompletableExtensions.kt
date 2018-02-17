@file:JvmName("CompletableExtensions")
@file:Suppress("NOTHING_TO_INLINE", "unused")

package io.milkcan.effortlessandroid.rx

import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * A collection of helpful functions that extend [Completable].
 *
 * @author Eric Bachhuber (bachhuberdesign@gmail.com)
 * @version 1.0.5
 * @since 1.0.0
 */

/**
 * @return
 */
inline fun Completable.defaultThreads(): Completable {
    return subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}

/**
 * @return
 */
inline fun Completable.asyncThreads(): Completable {
    return subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
}