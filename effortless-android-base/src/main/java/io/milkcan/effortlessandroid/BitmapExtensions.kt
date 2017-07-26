@file:JvmName("BitmapExtensions")

package io.milkcan.effortlessandroid

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Matrix
import android.graphics.RectF

/**
 * A collection of helpful functions that extend [Bitmap].
 *
 * @author Eric Bachhuber (bachhuberdesign@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 */

/**
 * Scales a Bitmap while retaining it's original aspect ratio.
 *
 * @param maxWidth The max width of the scaled bitmap
 * @param maxHeight The max height of the scaled bitmap
 * @return The scaled bitmap
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

/**
 * Scales and center crops a Bitmap to exactly [newWidth] x [newHeight].
 *
 * @param source
 * @param newWidth The width of the finished Bitmap
 * @param newHeight The height of the finished Bitmap
 * @return The scaled and cropped bitmap
 */
fun Bitmap.scaleCenterCrop(newWidth: Int, newHeight: Int): Bitmap {
    val sourceWidth = this.width
    val sourceHeight = this.height

    val scale = Math.max(newWidth.toFloat() / sourceWidth, newHeight.toFloat() / sourceHeight)

    val scaledWidth = scale * sourceWidth
    val scaledHeight = scale * sourceHeight

    val left = (newWidth - scaledWidth) / 2
    val top = (newHeight - scaledHeight) / 2

    val targetRect = RectF(left, top, left + scaledWidth, top + scaledHeight)

    val scaledBitmap = Bitmap.createBitmap(newWidth, newHeight, this.config)

    val canvas = Canvas(scaledBitmap)
    canvas.drawBitmap(this, null, targetRect, null)

    return scaledBitmap
}