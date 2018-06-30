@file:JvmName("ObservableExtensions")
@file:Suppress("NOTHING_TO_INLINE", "unused")

package io.milkcan.effortlessandroid.rx

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * A collection of helper extensions for [Observable].
 *
 * @author Eric Bachhuber (bachhuberdesign@gmail.com)
 * @version 1.1.0
 * @since 1.0.0
 */

/**
 * Sets the [Observable] stream to subscribe on [Schedulers.io] and observe on
 * [AndroidSchedulers.mainThread].
 *
 * @return The new [Observable] instance.
 */
inline fun <T> Observable<T>.defaultThreads(): Observable<T> {
    return subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}

/**
 * Sets the [Observable] stream to subscribe and observe on [Schedulers.io],
 *
 * @return The new [Observable] instance.
 */
inline fun <T> Observable<T>.asyncThreads(): Observable<T> {
    return subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
}