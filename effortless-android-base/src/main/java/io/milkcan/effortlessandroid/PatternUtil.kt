@file:JvmName("PatternUtil")
@file:Suppress("NOTHING_TO_INLINE", "unused")

package io.milkcan.effortlessandroid

/**
 * @author Eric Bachhuber (bachhuberdesign@gmail.com)
 * @version 1.0.4
 * @since 1.0.4
 */

inline fun String?.isValidEmail(): Boolean {
    return !this.isNullOrBlank() && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

inline fun CharSequence?.isValidEmail(): Boolean {
    return !this.isNullOrBlank() && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

inline fun String?.isValidIpAddress(): Boolean {
    return !this.isNullOrBlank() && android.util.Patterns.IP_ADDRESS.matcher(this).matches()
}

inline fun CharSequence?.isValidIpAddress(): Boolean {
    return !this.isNullOrBlank() && android.util.Patterns.IP_ADDRESS.matcher(this).matches()
}

inline fun String?.isValidPhone(): Boolean {
    return !this.isNullOrBlank() && android.util.Patterns.PHONE.matcher(this).matches()
}

inline fun CharSequence?.isValidPhone(): Boolean {
    return !this.isNullOrBlank() && android.util.Patterns.PHONE.matcher(this).matches()
}