@file:JvmName("LogExtensions")

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
fun v(tag: String, message: String) {
    Log.v(tag, message)
}

/**
 * @param tag
 * @param message
 */
fun d(tag: String, message: String) {
    Log.d(tag, message)
}

/**
 * @param tag
 * @param message
 */
fun i(tag: String, message: String) {
    Log.i(tag, message)
}

/**
 * @param tag
 * @param message
 */
fun w(tag: String, message: String) {
    Log.w(tag, message)
}

/**
 * @param tag
 * @param message
 */
fun e(tag: String, message: String) {
    Log.e(tag, message)
}

/**
 * @param tag
 * @param message
 */
fun wtf(tag: String, message: String) {
    Log.wtf(tag, message)
}

/**
 * @param message
 */
fun Any.v(message: String) {
    Log.v(this::class.java.name, message)
}

/**
 * @param message
 */
fun Any.d(message: String) {
    Log.d(this::class.java.name, message)
}

/**
 * @param message
 */
fun Any.i(message: String) {
    Log.i(this::class.java.name, message)
}

/**
 * @param message
 */
fun Any.w(message: String) {
    Log.w(this::class.java.name, message)
}

/**
 * @param message
 */
fun Any.e(message: String) {
    Log.e(this::class.java.name, message)
}

/**
 * @param message
 */
fun Any.wtf(message: String) {
    Log.wtf(this::class.java.name, message)
}