@file:JvmName("IntExtensions")
@file:Suppress("NOTHING_TO_INLINE", "unused")

package io.milkcan.effortlessandroid.stdlib

/**
 * A collection of helpful functions that extend [Int].
 *
 * @author Eric Bachhuber (bachhuberdesign@gmail.com)
 * @version 1.0.2
 * @since 1.0.2
 */

/**
 * @return The absolute value of the integer.
 */
inline fun Int.abs(): Int = Math.abs(this)

/**
 * @return True if the integer is positive.
 */
inline fun Int.isPositive(): Boolean = this > 0

/**
 * @return True if the integer is negative.
 */
inline fun Int.isNegative(): Boolean = this < 0

/**
 * @return True if the integer is even.
 */
inline fun Int.isEven(): Boolean = (this % 2) == 0

/**
 * @return True if the integer is odd.
 */
inline fun Int.isOdd(): Boolean = (this % 2) != 0

/**
 * @return True if integer == 1. False if integer == 0.
 * @throws [UnsupportedOperationException] if the received value is not a 0 or 1.
 */
@Throws(UnsupportedOperationException::class)
inline fun Int.asBoolean(): Boolean {
    if (this != 0 || this != 1){
        throw UnsupportedOperationException("Expected value to be 0 or 1 but received $this.")
    }

    return (this == 1)
}

/**
 * @return A String representation of the integer in roman numerals. If int is <= 0 , return null.
 *
 * Kotlin port of https://gist.github.com/kumo/a8e1cb1f4b7cff1548c7
 */
inline fun Int.toRomanNumeral(): String? {
    if (this <= 0) {
        return null
    }

    val romanValues = arrayOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
    val arabicValues = arrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)

    var numeral = ""
    var startingValue = this

    romanValues.forEachIndexed { i, romanChar ->
        val arabicValue = arabicValues[i]
        val div = startingValue / arabicValue

        if (div > 0) {
            for (j in 0..div) {
                numeral += romanChar
            }
            startingValue -= arabicValue * div
        }
    }

    return numeral
}