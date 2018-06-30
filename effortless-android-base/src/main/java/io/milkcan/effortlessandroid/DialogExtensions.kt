@file:JvmName("DialogExtensions")
@file:Suppress("NOTHING_TO_INLINE", "unused")

package io.milkcan.effortlessandroid

import android.app.ProgressDialog
import android.support.v7.app.AlertDialog

/**
 * A collection of helper extensions for AlertDialogs.
 *
 * @author Eric Bachhuber (bachhuberdesign@gmail.com)
 * @version 1.1.0
 * @since 1.1.0
 */

/**
 * Helper to safely dismiss a [ProgressDialog] if it is not null and is currently displayed.
 *
 * @return True if dismiss on the [ProgressDialog] was called.
 */
@Suppress("DEPRECATION")
inline fun ProgressDialog?.safeDismiss(): Boolean {
    return if (this != null && this.isShowing) {
        this.dismiss()
        true
    } else {
        false
    }
}

/**
 * Helper to safely dismiss an [AlertDialog] if it is not null and is currently displayed.
 *
 * @return True if dismiss on the [AlertDialog] was called.
 */
inline fun AlertDialog?.safeDismiss(): Boolean {
    return if (this != null && this.isShowing) {
        this.dismiss()
        true
    } else {
        false
    }
}