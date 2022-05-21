package com.mitsinsar.peracompactdecimalformat.numberformatter

import com.mitsinsar.peracompactdecimalformat.model.ParsedNumber
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants
import com.mitsinsar.peracompactdecimalformat.utils.PeraDecimal

internal object PeraNumberParser {

    private const val THOUSAND_EXPONENT_POWER = 3

    fun parseNumber(number: PeraDecimal): ParsedNumber {
        val (shiftCount, parsedNumber) = getParsedNumber(number)
        return ParsedNumber(number, parsedNumber, shiftCount)
    }

    private fun getParsedNumber(number: PeraDecimal): Pair<Int, PeraDecimal> {
        var shiftedNumber = number
        var shiftCount = 0
        while (shiftedNumber >= NumberConstants.THOUSAND.value) {
            shiftedNumber = shiftedNumber.scaleByPowerOfTen(-THOUSAND_EXPONENT_POWER)
            shiftCount++
        }
        return shiftCount to shiftedNumber
    }
}
