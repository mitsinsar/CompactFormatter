package com.mitsinsar.peracompactdecimalformat.numberformatter

import com.mitsinsar.peracompactdecimalformat.numberformatter.NumberFormatter.Constants.FORMAT_PATTERN
import com.mitsinsar.peracompactdecimalformat.utils.PeraDecimal
import com.mitsinsar.peracompactdecimalformat.utils.PeraRoundingMode
import com.mitsinsar.peracompactdecimalformat.utils.fractionaldigit.FractionalDigit
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

internal actual class PeraNumberFormatter actual constructor(
    override val localeConstant: String,
    override val peraRoundingMode: PeraRoundingMode,
    override val useGrouping: Boolean,
    override val groupingSize: Int
) : NumberFormatter {

    private val locale = Locale(localeConstant)
    private val decimalFormatSymbols = DecimalFormatSymbols(locale)

    actual override fun format(number: PeraDecimal, fractionalDigit: FractionalDigit): String {
        return getFormatter(fractionalDigit).format(number.toBigDecimal())
    }

    private fun getFormatter(fractionalDigit: FractionalDigit): DecimalFormat {
        return DecimalFormat(FORMAT_PATTERN, DecimalFormatSymbols(locale)).apply {
            maximumFractionDigits = fractionalDigit.maxDigit
            if (fractionalDigit.minDigit != null) {
                minimumFractionDigits = fractionalDigit.minDigit
            }
            roundingMode = peraRoundingMode.roundingMode
            if (useGrouping) {
                decimalFormatSymbols = this@PeraNumberFormatter.decimalFormatSymbols
                groupingSize = this@PeraNumberFormatter.groupingSize
                isGroupingUsed = true
            }
        }
    }
}
