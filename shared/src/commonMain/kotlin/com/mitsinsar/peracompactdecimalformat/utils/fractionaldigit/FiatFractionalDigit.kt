package com.mitsinsar.peracompactdecimalformat.utils.fractionaldigit

import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants
import com.mitsinsar.peracompactdecimalformat.utils.PeraDecimal
import com.mitsinsar.peracompactdecimalformat.utils.PeraDecimalConstants.ONE

class FiatFractionalDigit private constructor(
    minDigit: Int?,
    maxDigit: Int
) : FractionalDigit(minDigit, maxDigit) {

    companion object : FractionalDigitCreator {

        private const val LESS_THAN_ONE_MAX_FRACTIONAL_DIGIT = 6
        private const val DEFAULT_MAX_FRACTIONAL_LIMIT = 2

        override val minimumCompactNumber = NumberConstants.MILLION

        private fun getMaxFractionalLimit(number: PeraDecimal): Int {
            return when {
                number < ONE -> LESS_THAN_ONE_MAX_FRACTIONAL_DIGIT
                else -> DEFAULT_MAX_FRACTIONAL_LIMIT
            }
        }

        override fun create(number: PeraDecimal): FractionalDigit {
            val maxDigit = getMaxFractionalLimit(number)
            return FiatFractionalDigit(
                minDigit = getMinFractionalDigit(number, maxDigit, minimumCompactNumber),
                maxDigit = maxDigit
            )
        }
    }
}
