package com.mitsinsar.peracompactdecimalformat

import com.mitsinsar.peracompactdecimalformat.locals.base.BaseLocale
import com.mitsinsar.peracompactdecimalformat.locals.base.NumberLocaleIndexProvider
import com.mitsinsar.peracompactdecimalformat.numberformatter.NumberFormatter
import com.mitsinsar.peracompactdecimalformat.numberformatter.PeraNumberParser.parseNumber
import java.math.BigDecimal

class PeraCompactDecimalFormat internal constructor(
    private val indexProvider: NumberLocaleIndexProvider,
    private val locale: BaseLocale,
    private val style: CompactStyle,
    private val numberFormatter: NumberFormatter
) {

    fun format(number: BigDecimal): CompactDecimal {
        val parsedNumber = parseNumber(number)
        val formattedNumber = numberFormatter.format(parsedNumber)
        val localizedSuffix = getLocalizedSuffix(number)
        return CompactDecimal(number, formattedNumber, localizedSuffix)
    }

    private fun getLocalizedSuffix(number: BigDecimal): String {
        return with(locale) {
            when (style) {
                CompactStyle.SHORT -> getShortSuffix(number, indexProvider)
                CompactStyle.LONG -> getLongSuffix(number, indexProvider)
            }
        }
    }
}
