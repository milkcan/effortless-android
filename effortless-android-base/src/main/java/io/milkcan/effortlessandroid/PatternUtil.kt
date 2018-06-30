@file:JvmName("PatternUtil")
@file:Suppress("NOTHING_TO_INLINE", "unused")

package io.milkcan.effortlessandroid

/**
 * A collection of helper extensions for basic pattern matching.
 *
 * @author Eric Bachhuber (bachhuberdesign@gmail.com)
 * @version 1.0.4
 * @since 1.0.4
 */

/**
 * Check if the given [String] is a valid email address using the built in
 * [android.util.Patterns.EMAIL_ADDRESS] regex pattern.
 *
 * @return True if the [String] is a valid email address.
 */
inline fun String?.isValidEmail(): Boolean {
    return !this.isNullOrBlank() && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

/**
 * Check if the given [CharSequence] is a valid email address using the built in
 * [android.util.Patterns.EMAIL_ADDRESS] regex pattern.
 *
 * @return True if the [CharSequence] is a valid email address.
 */
inline fun CharSequence?.isValidEmail(): Boolean {
    return !this.isNullOrBlank() && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

/**
 * Check if the given [String] is a valid IP address using the built in
 * [android.util.Patterns.IP_ADDRESS] regex pattern.
 *
 * @return True if the [String] is a valid IP address.
 */
inline fun String?.isValidIpAddress(): Boolean {
    return !this.isNullOrBlank() && android.util.Patterns.IP_ADDRESS.matcher(this).matches()
}

/**
 * Check if the given [CharSequence] is a valid IP address using the built in
 * [android.util.Patterns.IP_ADDRESS] regex pattern.
 *
 * @return True if the [CharSequence] is a valid IP address.
 */
inline fun CharSequence?.isValidIpAddress(): Boolean {
    return !this.isNullOrBlank() && android.util.Patterns.IP_ADDRESS.matcher(this).matches()
}

/**
 * Check if the given [String] is a valid phone number using the built in
 * [android.util.Patterns.PHONE] regex pattern.
 *
 * @return True if the [String] is a valid phone number.
 */
inline fun String?.isValidPhone(): Boolean {
    return !this.isNullOrBlank() && android.util.Patterns.PHONE.matcher(this).matches()
}

/**
 * Check if the given [CharSequence] is a valid phone number using the built in
 * [android.util.Patterns.IP_ADDRESS] regex pattern.
 *
 * @return True if the [CharSequence] is a valid phone number.
 */
inline fun CharSequence?.isValidPhone(): Boolean {
    return !this.isNullOrBlank() && android.util.Patterns.PHONE.matcher(this).matches()
}