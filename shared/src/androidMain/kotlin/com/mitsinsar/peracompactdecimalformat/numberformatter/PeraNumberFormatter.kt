package com.mitsinsar.peracompactdecimalformat.numberformatter

import com.mitsinsar.peracompactdecimalformat.numberformatter.NumberFormatter.Constants.FORMAT_PATTERN
import com.mitsinsar.peracompactdecimalformat.utils.PeraDecimal
import com.mitsinsar.peracompactdecimalformat.utils.PeraRoundingMode
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

internal actual class PeraNumberFormatter actual constructor(
    override val localeConstant: String,
    override val peraRoundingMode: PeraRoundingMode,
    override val minimumFractionalDigit: Int,
    override val maximumFractionalDigit: Int,
    override val useGrouping: Boolean,
    override val groupingSize: Int
) : NumberFormatter {

    private val locale = Locale(localeConstant)
    private val decimalFormatSymbols = DecimalFormatSymbols(locale)

    actual override fun format(number: PeraDecimal): String {
        return getFormatter().format(number.toBigDecimal())
    }

    private fun getFormatter(): DecimalFormat {
        return DecimalFormat(FORMAT_PATTERN, DecimalFormatSymbols(locale)).apply {
            maximumFractionDigits = maximumFractionalDigit
            minimumFractionDigits = minimumFractionalDigit
            roundingMode = peraRoundingMode.roundingMode
            if (useGrouping) {
                decimalFormatSymbols = this@PeraNumberFormatter.decimalFormatSymbols
                groupingSize = this@PeraNumberFormatter.groupingSize
                isGroupingUsed = true
            }
        }
    }
}
