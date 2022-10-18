package com.mitsinsar.peracompactdecimalformat

import com.mitsinsar.peracompactdecimalformat.locals.base.BaseLocale
import com.mitsinsar.peracompactdecimalformat.model.CompactDecimal
import com.mitsinsar.peracompactdecimalformat.model.ParsedNumber
import com.mitsinsar.peracompactdecimalformat.numberformatter.NumberFormatter
import com.mitsinsar.peracompactdecimalformat.numberformatter.PeraNumberParser.parseNumber
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants
import com.mitsinsar.peracompactdecimalformat.utils.PeraDecimal
import com.mitsinsar.peracompactdecimalformat.utils.fractionaldigit.AssetFractionalDigit
import com.mitsinsar.peracompactdecimalformat.utils.fractionaldigit.FractionalDigit

class PeraCompactDecimalFormat internal constructor(
    private val locale: BaseLocale,
    private val style: CompactStyle,
    private val numberFormatter: NumberFormatter,
    private val fractionalDigitCreator: FractionalDigit.FractionalDigitCreator
) {

    fun format(number: PeraDecimal, compactForAndAfter: NumberConstants = NumberConstants.MILLION): CompactDecimal {
        val parsedNumber = parseNumber(number)
        val shouldCompact = parsedNumber.rawNumber >= compactForAndAfter.value
        val formattedNumber = getFormattedNumber(parsedNumber, shouldCompact)
        val localizedSuffix =
            if (shouldCompact) getLocalizedSuffix(NumberConstants.getByIndex(parsedNumber.shiftCount)) else null
        return CompactDecimal(number, formattedNumber, localizedSuffix)
    }

    private fun getLocalizedSuffix(numberConstants: NumberConstants): String? {
        return with(locale) {
            when (style) {
                CompactStyle.SHORT -> getShortSuffix(numberConstants)
                CompactStyle.LONG -> getLongSuffix(numberConstants)
            }
        }
    }

    private fun getFormattedNumber(parsedNumber: ParsedNumber, shouldCompact: Boolean): String {
        return with(parsedNumber) {
            val fractionalDigit = AssetFractionalDigit.create(rawNumber)
            val numberToFormat = if (shouldCompact) this.parsedNumber else rawNumber
            numberFormatter.format(numberToFormat, fractionalDigit)
        }
    }
}
