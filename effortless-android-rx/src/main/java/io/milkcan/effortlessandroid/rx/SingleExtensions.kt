@file:JvmName("SingleExtensions")
@file:Suppress("NOTHING_TO_INLINE", "unused")

package io.milkcan.effortlessandroid.rx

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * A collection of helper extensions for [Single].
 *
 * @author Eric Bachhuber (bachhuberdesign@gmail.com)
 * @version 1.1.0
 * @since 1.0.0
 */

/**
 * Sets the [Single] stream to subscribe on [Schedulers.io] and observe on
 * [AndroidSchedulers.mainThread].
 *
 * @return The new [Single] instance.
 */
inline fun <T> Single<T>.defaultThreads(): Single<T> {
    return subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}

/**
 * Sets the [Single] stream to subscribe and observe on [Schedulers.io],
 *
 * @return The new [Single] instance.
 */
inline fun <T> Single<T>.asyncThreads(): Single<T> {
    return subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
}
