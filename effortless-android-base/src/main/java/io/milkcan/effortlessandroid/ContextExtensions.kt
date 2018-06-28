@file:JvmName("ContextExtensions")
@file:Suppress("NOTHING_TO_INLINE", "unused", "MissingPermission")

package io.milkcan.effortlessandroid

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.graphics.drawable.Drawable
import android.net.ConnectivityManager
import android.os.Build
import android.preference.PreferenceManager
import android.support.annotation.RequiresApi
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.Toast

/**
 * A collection of helpful functions that extend [Context].
 *
 * @author Eric Bachhuber (bachhuberdesign@gmail.com)
 * @version 1.1.1
 * @since 1.0.0
 */

/**
 * @param resourceId The ID of the String resource to display.
 */
fun Context.toast(resourceId: Int) {
    Toast.makeText(this, resourceId, Toast.LENGTH_SHORT).show()
}

/**
 * @param message The message to display.
 */
fun Context.toast(message: String?) {
    message?.let { Toast.makeText(this, it, Toast.LENGTH_SHORT).show() }
}

/**
 * @param resourceId The ID of the String resource to display.
 */
fun Context.toastLong(resourceId: Int) {
    Toast.makeText(this, resourceId, Toast.LENGTH_LONG).show()
}

/**
 * @param message The message to display.
 */
fun Context.toastLong(message: String?) {
    message?.let { Toast.makeText(this, it, Toast.LENGTH_LONG).show() }
}

/**
 * @param key
 * @return
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
 * Converts absolute pixels (px) to scale-independent pixels (sp).
 * https://stackoverflow.com/questions/2025282/what-is-the-difference-between-px-dp-dip-and-sp-on-android
 *
 * @param px Absolute pixels (px) to convert.
 */
fun Context.pxToSp(px: Int): Float {
    return (px * resources.displayMetrics.scaledDensity)
}

/**
 * Checks if permissions have been granted or not.
 *
 * @param permission Name of the permission(s) to check (i.e. Manifest.permission.CAMERA).
 * @return True if all permissions have been granted.
 */
fun Context.isPermissionsGranted(vararg permission: String): Boolean {
    return permission.all { ContextCompat.checkSelfPermission(this, it) == PackageManager.PERMISSION_GRANTED }
}

/**
 * @param resourceId
 * @return A single color value in the form 0xAARRGGBB.
 */
fun Context.getColorCompat(resourceId: Int): Int {
    return ContextCompat.getColor(this, resourceId)
}

/**
 * @param resourceId
 * @return
 */
fun Context.getDrawableCompat(resourceId: Int): Drawable {
    return ContextCompat.getDrawable(this, resourceId)!!
}

/**
 * Checks if network is connected or currently in the process of connecting.
 *
 * Requires android.permission.ACCESS_NETWORK_STATE to call.
 *
 * @return True if the network is connected or connecting.
 */
@SuppressLint("MissingPermission")
fun Context.isNetworkConnectedOrConnecting(): Boolean {
    val manager = this.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    return manager.activeNetworkInfo != null && manager.activeNetworkInfo.isConnectedOrConnecting
}

/**
 * @return
 */
fun Context.isLandscape() = this.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

/**
 * @return
 */
fun Context.isPortrait() = this.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT

/**
 * @return
 */
@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
fun Context.isLeftToRight() = this.resources.configuration.layoutDirection == View.LAYOUT_DIRECTION_LTR

/**
 * @return
 */
@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
fun Context.isRightToLeft() = this.resources.configuration.layoutDirection == View.LAYOUT_DIRECTION_RTL

/**
 * @return Default SharedPreferences instance for the provided context.
 */
fun Context.getDefaultSharedPreferences(): SharedPreferences {
    return PreferenceManager.getDefaultSharedPreferences(this)
}