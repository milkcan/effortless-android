@file:JvmName("BitmapExtensions")

package io.milkcan.effortlessandroid

import android.graphics.Bitmap
import android.graphics.Matrix

/**
 * A collection of helpful functions that extend [Bitmap].
 *
 * @author Eric Bachhuber (bachhuberdesign@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 */

/**
 * @param maxWidth
 * @param maxHeight
 * @return
 */
fun Bitmap.scaleAndMaintainAspectRatio(maxWidth: Int, maxHeight: Int): Bitmap {
    if (maxHeight > 0 && maxWidth > 0) {
        val ratioBitmap = this.width.toFloat() / this.height.toFloat()
        val ratioMax = maxWidth.toFloat() / maxHeight.toFloat()
        var finalWidth = maxWidth
        var finalHeight = maxHeight

        if (ratioMax > 1) {
            finalWidth = (maxHeight.toFloat() * ratioBitmap).toInt()
        } else {
            finalHeight = (maxWidth.toFloat() / ratioBitmap).toInt()
        }

        return Bitmap.createScaledBitmap(this, finalWidth, finalHeight, true)
    } else {
        return this
    }
}

/**
 * Flips a bitmap image 180 degrees (i.e. mirrors).
 *
 * @return The mirrored bitmap
 */
fun Bitmap.mirror(): Bitmap {
    val matrix = Matrix()
    matrix.preScale(-1f, 1f)

    return Bitmap.createBitmap(this, 0, 0, this.width, this.height, matrix, false)
}