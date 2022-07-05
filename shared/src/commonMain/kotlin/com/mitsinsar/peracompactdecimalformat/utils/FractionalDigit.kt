package com.mitsinsar.peracompactdecimalformat.utils

import com.mitsinsar.peracompactdecimalformat.utils.PeraDecimalConstants.ONE
import com.mitsinsar.peracompactdecimalformat.utils.PeraDecimalConstants.TEN

class FractionalDigit private constructor(
    val minDigit: Int,
    val maxDigit: Int
) {

    override fun equals(other: Any?): Boolean {
        return other is FractionalDigit && other.maxDigit == maxDigit && other.minDigit == minDigit
    }

    override fun hashCode(): Int {
        var result = minDigit
        result = 31 * result + maxDigit
        return result
    }

    companion object {

        private const val DEFAULT_MIN_FRACTIONAL_DIGIT = 2
        private const val LESS_THAN_ONE_MAX_FRACTIONAL_DIGIT = 6
        private const val LESS_THAN_TEN_MAX_FRACTIONAL_DIGIT = 4
        private const val DEFAULT_MAX_FRACTIONAL_LIMIT = 2

        private val MAX_NUMBER_TO_SHOW_DECIMAL = PeraDecimal("9999")

        fun create(number: PeraDecimal): FractionalDigit {
            val maxDigit = getMaxFractionalLimit(number)
            return FractionalDigit(
                minDigit = minOf(maxDigit, DEFAULT_MIN_FRACTIONAL_DIGIT),
                maxDigit = maxDigit
            )
        }

        private fun getMaxFractionalLimit(number: PeraDecimal): Int {
            return when {
                number < ONE -> LESS_THAN_ONE_MAX_FRACTIONAL_DIGIT
                number < TEN -> LESS_THAN_TEN_MAX_FRACTIONAL_DIGIT
                number > MAX_NUMBER_TO_SHOW_DECIMAL && number < NumberConstants.MILLION.value -> 0
                else -> DEFAULT_MAX_FRACTIONAL_LIMIT
            }
        }
    }
}
