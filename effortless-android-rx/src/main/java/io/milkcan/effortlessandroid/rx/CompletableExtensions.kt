@file:JvmName("CompletableExtensions")
@file:Suppress("NOTHING_TO_INLINE", "unused")

package io.milkcan.effortlessandroid.rx

import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * A collection of helper extensions for [Completable].
 *
 * @author Eric Bachhuber (bachhuberdesign@gmail.com)
 * @version 1.1.0
 * @since 1.0.0
 */

/**
 * Sets the [Completable] stream to subscribe on [Schedulers.io] and observe on
 * [AndroidSchedulers.mainThread].
 *
 * @return The new [Completable] instance.
 */
inline fun Completable.defaultThreads(): Completable {
    return subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}

/**
 * Sets the [Completable] stream to subscribe and observe on [Schedulers.io],
 *
 * @return The new [Completable] instance.
 */
inline fun Completable.asyncThreads(): Completable {
    return subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
}