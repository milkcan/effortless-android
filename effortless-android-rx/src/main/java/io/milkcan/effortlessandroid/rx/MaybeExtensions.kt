@file:JvmName("MaybeExtensions")
@file:Suppress("NOTHING_TO_INLINE", "unused")

package io.milkcan.effortlessandroid.rx

import io.reactivex.Maybe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * A collection of helpful functions that extend [Maybe].
 *
 * @author Eric Bachhuber (bachhuberdesign@gmail.com)
 * @version 1.0.5
 * @since 1.0.5
 */

/**
 * @return
 */
inline fun <T> Maybe<T>.asyncThreads(): Maybe<T> {
    return subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
}

/**
 * @return
 */
inline fun <T> Maybe<T>.defaultThreads(): Maybe<T> {
    return subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}