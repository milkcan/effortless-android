@file:JvmName("MaybeExtensions")
@file:Suppress("NOTHING_TO_INLINE", "unused")

package io.milkcan.effortlessandroid.rx

import io.reactivex.Maybe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * A collection of helper extensions for [Maybe].
 *
 * @author Eric Bachhuber (bachhuberdesign@gmail.com)
 * @version 1.1.0
 * @since 1.1.0
 */

/**
 * Sets the [Maybe] stream to subscribe on [Schedulers.io] and observe on
 * [AndroidSchedulers.mainThread].
 *
 * @return The new [Maybe] instance.
 */
inline fun <T> Maybe<T>.asyncThreads(): Maybe<T> {
    return subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
}

/**
 * Sets the [Maybe] stream to subscribe and observe on [Schedulers.io],
 *
 * @return The new [Maybe] instance.
 */
inline fun <T> Maybe<T>.defaultThreads(): Maybe<T> {
    return subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}