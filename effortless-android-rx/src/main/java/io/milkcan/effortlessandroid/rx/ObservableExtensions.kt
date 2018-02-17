@file:JvmName("ObservableExtensions")
@file:Suppress("NOTHING_TO_INLINE", "unused")

package io.milkcan.effortlessandroid.rx

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * A collection of helpful functions that extend [Observable].
 *
 * @author Eric Bachhuber (bachhuberdesign@gmail.com)
 * @version 1.0.5
 * @since 1.0.0
 */

/**
 * @return
 */
inline fun <T> Observable<T>.defaultThreads(): Observable<T> {
    return subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}

/**
 * @return
 */
inline fun <T> Observable<T>.asyncThreads(): Observable<T> {
    return subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
}