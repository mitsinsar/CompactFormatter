package com.mitsinsar.peracompactdecimalformat.utils.fractionaldigit

import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants
import com.mitsinsar.peracompactdecimalformat.utils.PeraDecimal

class CollectibleFractionalDigit private constructor(
    minDigit: Int?,
    maxDigit: Int
) : FractionalDigit(minDigit, maxDigit) {

    companion object : FractionalDigitCreator {

        override val minimumCompactNumber = NumberConstants.ZERO

        private const val DEFAULT_MAX_FRACTIONAL_LIMIT = 1

        private fun getMaxFractionalLimit(): Int {
            return DEFAULT_MAX_FRACTIONAL_LIMIT
        }

        override fun create(number: PeraDecimal): FractionalDigit {
            val maxDigit = getMaxFractionalLimit()
            return CollectibleFractionalDigit(
                minDigit = getMinFractionalDigit(number, maxDigit, minimumCompactNumber),
                maxDigit = maxDigit
            )
        }
    }
}
