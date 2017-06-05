@file:JvmName("ContextExtensions")

package io.milkcan.effortlessandroid

import android.content.Context
import android.content.pm.PackageManager
import android.support.v4.content.ContextCompat
import android.widget.Toast

/**
 * A collection of helpful functions that extend [Context].
 *
 * @author Eric Bachhuber (bachhuberdesign@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 */

/**
 * @param resourceId
 */
fun Context.toast(resourceId: Int) {
    Toast.makeText(this, resourceId, Toast.LENGTH_SHORT).show()
}

/**
 * @param message
 */
fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

/**
 * @param resourceId
 */
fun Context.toastLong(resourceId: Int) {
    Toast.makeText(this, resourceId, Toast.LENGTH_LONG).show()
}

/**
 * @param message
 */
fun Context.toastLong(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

/**
 *
 */
fun Context.getStringResourceByName(key: String): String {
    val resourceId = this.resources.getIdentifier(key, "string", this.packageName)
    return this.getString(resourceId)
}

/**
 * Converts density-independent pixels (dp/dip) to absolute pixels (px).
 * https://stackoverflow.com/questions/2025282/what-is-the-difference-between-px-dp-dip-and-sp-on-android
 *
 * @param dp Density-independent pixels to convert.
 */
fun Context.dpToPx(dp: Int): Float {
    val scale = this.resources.displayMetrics.density
    return dp * scale + 0.5f
}

/**
 * Converts absolute pixels (px) to density-independent pixels (dp/dip).
 * https://stackoverflow.com/questions/2025282/what-is-the-difference-between-px-dp-dip-and-sp-on-android
 *
 * @param px Absolute pixels (px) to convert.
 */
fun Context.pxToDp(px: Int): Float {
    val displayMetrics = this.resources.displayMetrics
    return (px / displayMetrics.density + 0.5).toFloat()
}

/**
 * Checks if permission has been granted or not.
 *
 * @param permission Name of the permission to check (i.e. Manifest.permission.CAMERA).
 * @return True if permission is granted, false if it has not yet been granted.
 */
fun Context.isPermissionGranted(permission: String): Boolean {
    return ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED
}