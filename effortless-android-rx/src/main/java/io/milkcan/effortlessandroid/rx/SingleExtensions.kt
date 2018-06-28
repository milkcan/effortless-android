@file:JvmName("SingleExtensions")
@file:Suppress("NOTHING_TO_INLINE", "unused")

package io.milkcan.effortlessandroid.rx

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * A collection of helpful functions that extend [Single].
 *
 * @author Eric Bachhuber (bachhuberdesign@gmail.com)
 * @version 1.1.0
 * @since 1.0.0
 */

/**
 * @return
 */
inline fun <T> Single<T>.defaultThreads(): Single<T> {
    return subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}

/**
 * @return
 */
inline fun <T> Single<T>.asyncThreads(): Single<T> {
    return subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
}
