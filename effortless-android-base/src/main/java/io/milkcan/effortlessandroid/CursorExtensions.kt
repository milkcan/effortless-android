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
 * @param columnName
 * @return
 */
fun Cursor.getBooleanFromColumn(columnName: String): Boolean {
    val columnValue = getInt(getColumnIndex(columnName))

    return when (columnValue) {
        0 -> false
        1 -> true
        else -> throw IndexOutOfBoundsException("$columnName value was $columnValue, expected 0 or 1.")
    }
}

/**
 * @param columnName
 * @return
 */
fun Cursor.getIntFromColumn(columnName: String): Int {
    return getInt(getColumnIndex(columnName))
}

/**
 * @param columnName
 * @return
 */
fun Cursor.getLongFromColumn(columnName: String): Long {
    return getLong(getColumnIndex(columnName))
}

/**
 * @param columnName
 * @return
 */
fun Cursor.getStringFromColumn(columnName: String): String {
    return getString(getColumnIndex(columnName))
}

/**
 * @param columnName
 * @return
 */
fun Cursor.getDoubleFromColumn(columnName: String): Double {
    return getDouble(getColumnIndex(columnName))
}

/**
 * @param columnName
 * @return
 */
fun Cursor.getFloatFromColumn(columnName: String): Float {
    return getFloat(getColumnIndex(columnName))
}

/**
 * @param columnName
 * @return
 */
fun Cursor.getBlobFromColumn(columnName: String): ByteArray {
    return getBlob(getColumnIndex(columnName))
}
