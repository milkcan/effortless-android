@file:JvmName("LogExtensions")
@file:Suppress("NOTHING_TO_INLINE")

package io.milkcan.effortlessandroid

import android.util.Log

/**
 * A collection of helpful functions that extend [Log].
 *
 * @author Eric Bachhuber (bachhuberdesign@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 */

/**
 * @param tag
 * @param message
 */
inline fun v(tag: String, message: String) {
    Log.v(tag, message)
}

/**
 * @param tag
 * @param message
 */
inline fun d(tag: String, message: String) {
    Log.d(tag, message)
}

/**
 * @param tag
 * @param message
 */
inline fun i(tag: String, message: String) {
    Log.i(tag, message)
}

/**
 * @param tag
 * @param message
 */
inline fun w(tag: String, message: String) {
    Log.w(tag, message)
}

/**
 * @param tag
 * @param message
 */
inline fun e(tag: String, message: String) {
    Log.e(tag, message)
}

/**
 *  @param tag
 *  @param message
 *  @param throwable
 */
inline fun e(tag: String, message: String, throwable: Throwable) {
    Log.e(tag, message, throwable)
}

/**
 * @param tag
 * @param message
 */
inline fun wtf(tag: String, message: String) {
    Log.wtf(tag, message)
}

/**
 * @param message
 */
inline fun Any.v(message: String) {
    Log.v(this::class.java.name, message)
}

/**
 * @param message
 */
inline fun Any.d(message: String) {
    Log.d(this::class.java.name, message)
}

/**
 * @param message
 */
inline fun Any.i(message: String) {
    Log.i(this::class.java.name, message)
}

/**
 * @param message
 */
inline fun Any.w(message: String) {
    Log.w(this::class.java.name, message)
}

/**
 * @param message
 */
inline fun Any.e(message: String) {
    Log.e(this::class.java.name, message)
}

/**
 * @param message
 * @param throwable
 */
inline fun Any.e(message: String, throwable: Throwable) {
    Log.e(this::class.java.name, message, throwable)
}

/**
 * @param message
 */
inline fun Any.wtf(message: String) {
    Log.wtf(this::class.java.name, message)
}

/**
 * @param message
 * @param throwable
 */
inline fun Any.wtf(message: String, throwable: Throwable) {
    Log.wtf(this::class.java.name, message, throwable)
}