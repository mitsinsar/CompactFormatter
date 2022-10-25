package com.mitsinsar.peracompactdecimalformat

import com.mitsinsar.peracompactdecimalformat.locals.base.BaseLocale
import com.mitsinsar.peracompactdecimalformat.model.CompactDecimal
import com.mitsinsar.peracompactdecimalformat.model.ParsedNumber
import com.mitsinsar.peracompactdecimalformat.numberformatter.NumberFormatter
import com.mitsinsar.peracompactdecimalformat.numberformatter.PeraNumberParser.parseNumber
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants
import com.mitsinsar.peracompactdecimalformat.utils.PeraDecimal
import com.mitsinsar.peracompactdecimalformat.utils.fractionaldigit.FractionalDigit

class PeraCompactDecimalFormat internal constructor(
    private val locale: BaseLocale,
    private val style: CompactStyle,
    private val numberFormatter: NumberFormatter,
    private val fractionalDigitCreator: FractionalDigit.FractionalDigitCreator
) {

    fun format(number: PeraDecimal): CompactDecimal {
        val parsedNumber = parseNumber(number)
        val formattedNumber = getFormattedNumber(parsedNumber)
        val localizedSuffix = getLocalizedSuffix(
            numberConstants = NumberConstants.getByIndex(parsedNumber.shiftCount),
            minimumCompactNumber = fractionalDigitCreator.minimumCompactNumber
        )
        return CompactDecimal(number, formattedNumber, localizedSuffix)
    }

    private fun getLocalizedSuffix(numberConstants: NumberConstants, minimumCompactNumber: NumberConstants): String? {
        if (minimumCompactNumber.ordinal > numberConstants.ordinal) return null
        return with(locale) {
            when (style) {
                CompactStyle.SHORT -> getShortSuffix(numberConstants)
                CompactStyle.LONG -> getLongSuffix(numberConstants)
            }
        }
    }

    private fun getFormattedNumber(parsedNumber: ParsedNumber): String {
        return with(parsedNumber) {
            val fractionalDigit = fractionalDigitCreator.create(rawNumber)
            val numberToFormat = if (rawNumber < fractionalDigitCreator.minimumCompactNumber.value) {
                rawNumber
            } else {
                this.parsedNumber
            }
            numberFormatter.format(numberToFormat, fractionalDigit)
        }
    }
}
