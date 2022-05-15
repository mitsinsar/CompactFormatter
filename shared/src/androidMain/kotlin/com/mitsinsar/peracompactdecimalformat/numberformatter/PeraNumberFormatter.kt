package com.mitsinsar.peracompactdecimalformat.numberformatter

import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

class PeraNumberFormatter private constructor(private val locale: Locale) : NumberFormatter {

    // TODO Create custom exception
    override fun format(number: BigDecimal): String {
        return DecimalFormat(FORMAT_PATTERN, DecimalFormatSymbols(locale)).apply {
            roundingMode = RoundingMode.DOWN
        }.format(number)
    }

    companion object {

        private const val FORMAT_PATTERN = "#,##0.00"
        private val DEFAULT_LOCALE = Locale.ENGLISH

        fun getInstance(locale: Locale = DEFAULT_LOCALE) = PeraNumberFormatter(locale)
    }
}
