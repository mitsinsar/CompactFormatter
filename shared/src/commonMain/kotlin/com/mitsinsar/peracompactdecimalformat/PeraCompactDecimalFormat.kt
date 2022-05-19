package com.mitsinsar.peracompactdecimalformat

import com.mitsinsar.peracompactdecimalformat.locals.base.BaseLocale
import com.mitsinsar.peracompactdecimalformat.model.CompactDecimal
import com.mitsinsar.peracompactdecimalformat.model.ParsedNumber
import com.mitsinsar.peracompactdecimalformat.numberformatter.NumberFormatter
import com.mitsinsar.peracompactdecimalformat.numberformatter.PeraNumberParser.parseNumber
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants
import java.math.BigDecimal

class PeraCompactDecimalFormat internal constructor(
    private val locale: BaseLocale,
    private val style: CompactStyle,
    private val numberFormatter: NumberFormatter,
    private val excludedShorteningNumbersSet: Set<NumberConstants>
) {

    fun format(number: BigDecimal): CompactDecimal {
        val parsedNumber = parseNumber(number)
        val formattedNumber = getFormattedNumber(parsedNumber)
        val localizedSuffix = getLocalizedSuffix(NumberConstants.getByIndex(parsedNumber.shiftCount))
        return CompactDecimal(number, formattedNumber, localizedSuffix)
    }

    private fun getLocalizedSuffix(numberConstants: NumberConstants): String? {
        if (excludedShorteningNumbersSet.contains(numberConstants)) return null
        return with(locale) {
            when (style) {
                CompactStyle.SHORT -> getShortSuffix(numberConstants)
                CompactStyle.LONG -> getLongSuffix(numberConstants)
            }
        }
    }

    private fun getFormattedNumber(parsedNumber: ParsedNumber): String {
        val numberToFormat: BigDecimal = with(parsedNumber) {
            val floorNumber = NumberConstants.getByIndex(parsedNumber.shiftCount)
            if (excludedShorteningNumbersSet.contains(floorNumber)) rawNumber else this.parsedNumber
        }
        return numberFormatter.format(numberToFormat)
    }
}
