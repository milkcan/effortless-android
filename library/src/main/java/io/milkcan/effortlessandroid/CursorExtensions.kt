@file:JvmName("CursorExtensions")

package io.milkcan.effortlessandroid

import android.database.Cursor

/**
 * A collection of helpful functions that extend [Cursor].
 *
 * @author Eric Bachhuber (bachhuberdesign@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 */

/**
 *
 */
fun Cursor.getBooleanFromColumn(columnName: String): Boolean {
    val columnValue = getInt(getColumnIndex(columnName))

    when (columnValue) {
        0 -> return false
        1 -> return true
        else -> throw IndexOutOfBoundsException("$columnName value was $columnValue, expected 0 or 1.")
    }
}

/**
 *
 */
fun Cursor.getIntFromColumn(columnName: String): Int {
    return getInt(getColumnIndex(columnName))
}

/**
 *
 */
fun Cursor.getLongFromColumn(columnName: String): Long {
    return getLong(getColumnIndex(columnName))
}

/**
 *
 */
fun Cursor.getStringFromColumn(columnName: String): String {
    return getString(getColumnIndex(columnName))
}

/**
 *
 */
fun Cursor.getDoubleFromColumn(columnName: String): Double {
    return getDouble(getColumnIndex(columnName))
}

/**
 *
 */
fun Cursor.getFloatFromColumn(columnName: String): Float {
    return getFloat(getColumnIndex(columnName))
}

/**
 *
 */
fun Cursor.getBlobFromColumn(columnName: String): ByteArray {
    return getBlob(getColumnIndex(columnName))
}
