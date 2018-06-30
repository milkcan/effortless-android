@file:JvmName("FlowableExtensions")
@file:Suppress("NOTHING_TO_INLINE", "unused")

package io.milkcan.effortlessandroid.rx

import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * A collection of helper extensions for [Flowable].
 *
 * @author Eric Bachhuber (bachhuberdesign@gmail.com)
 * @version 1.1.0
 * @since 1.0.0
 */

/**
 * Sets the [Flowable] stream to subscribe on [Schedulers.io] and observe on
 * [AndroidSchedulers.mainThread].
 *
 * @return The new [Flowable] instance.
 */
inline fun <T> Flowable<T>.defaultThreads(): Flowable <T> {
    return subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}

/**
 * Sets the [Flowable] stream to subscribe and observe on [Schedulers.io],
 *
 * @return The new [Flowable] instance.
 */
inline fun <T> Flowable<T>.asyncThreads(): Flowable<T> {
    return subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
}