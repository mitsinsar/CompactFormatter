package com.mitsinsar.peracompactdecimalformat.numberformatter

import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants
import java.math.BigDecimal

internal object PeraNumberParser {

    // TODO Write doc
    fun parseNumber(number: BigDecimal): BigDecimal {
        val integerBigLength = number.toBigInteger().toString().length
        return if (integerBigLength > 6) {
            getParsedNumber(number)
        } else {
            number
        }
    }

    private fun getParsedNumber(number: BigDecimal): BigDecimal {
        var shiftedNumber = number
        while (shiftedNumber >= NumberConstants.THOUSAND.value) {
            shiftedNumber = shiftedNumber.scaleByPowerOfTen(-3)
        }
        return shiftedNumber
    }
}
