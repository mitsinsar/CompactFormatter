package com.mitsinsar.peracompactdecimalformat.utils.fractionaldigit

import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants
import com.mitsinsar.peracompactdecimalformat.utils.PeraDecimal
import kotlin.jvm.JvmStatic

abstract class FractionalDigit constructor(
    val minDigit: Int?,
    val maxDigit: Int
) {

    override fun equals(other: Any?): Boolean {
        return other is FractionalDigit && other.maxDigit == maxDigit && other.minDigit == minDigit
    }

    override fun hashCode(): Int {
        var result = minDigit ?: 1
        result = 31 * result + maxDigit
        return result
    }

    interface FractionalDigitCreator {
        fun create(number: PeraDecimal): FractionalDigit
    }

    companion object {

        private const val DEFAULT_MIN_FRACTIONAL_DIGIT = 2

        @JvmStatic
        protected fun getMinFractionalDigit(number: PeraDecimal, maximumFractionalDigit: Int): Int? {
            val minFractionalDigit = DEFAULT_MIN_FRACTIONAL_DIGIT.takeIf { number < NumberConstants.MILLION.value }
            return if (minFractionalDigit == null) null else minOf(maximumFractionalDigit, minFractionalDigit)
        }
    }
}
