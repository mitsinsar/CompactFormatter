package com.mitsinsar.peracompactdecimalformat.numberformatter

import com.mitsinsar.peracompactdecimalformat.utils.PeraDecimal
import com.mitsinsar.peracompactdecimalformat.utils.PeraRoundingMode
import com.mitsinsar.peracompactdecimalformat.utils.fractionaldigit.FractionalDigit
import platform.Foundation.NSDecimalNumber
import platform.Foundation.NSLocale
import platform.Foundation.NSNumberFormatter
import platform.Foundation.NSNumberFormatterDecimalStyle

internal actual class PeraNumberFormatter actual constructor(
    override val localeConstant: String,
    override val peraRoundingMode: PeraRoundingMode,
    override val useGrouping: Boolean,
    override val groupingSize: Int
) : NumberFormatter {

    actual override fun format(number: PeraDecimal, fractionalDigit: FractionalDigit): String {
        return getFormatter(fractionalDigit).stringFromNumber(NSDecimalNumber(number.value)).orEmpty()
    }

    private fun getFormatter(fractionalDigit: FractionalDigit): NSNumberFormatter {
        return NSNumberFormatter().apply {
            locale = NSLocale(localeConstant)
            maximumFractionDigits = fractionalDigit.maxDigit.toULong()
            if (fractionalDigit.minDigit != null) {
                minimumFractionDigits = fractionalDigit.minDigit.toULong()
            }
            roundingMode = this@PeraNumberFormatter.peraRoundingMode.roundingMode
            if (useGrouping) {
                numberStyle = NSNumberFormatterDecimalStyle.apply {
                    groupingSize = this@PeraNumberFormatter.groupingSize.toULong()
                }
            }
        }
    }
}
