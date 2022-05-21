package com.mitsinsar.peracompactdecimalformat.numberformatter

import com.mitsinsar.peracompactdecimalformat.utils.PeraDecimal
import com.mitsinsar.peracompactdecimalformat.utils.PeraRoundingMode
import platform.Foundation.NSDecimalNumber
import platform.Foundation.NSLocale
import platform.Foundation.NSNumberFormatter
import platform.Foundation.NSNumberFormatterDecimalStyle

internal actual class PeraNumberFormatter actual constructor(
    override val localeConstant: String,
    override val peraRoundingMode: PeraRoundingMode,
    override val minimumFractionalDigit: Int,
    override val maximumFractionalDigit: Int,
    override val useGrouping: Boolean,
    override val groupingSize: Int
) : NumberFormatter {

    actual override fun format(number: PeraDecimal): String {
        return getFormatter().stringFromNumber(NSDecimalNumber(number.value)).orEmpty()
    }

    private fun getFormatter(): NSNumberFormatter {
        return NSNumberFormatter().apply {
            locale = NSLocale(localeConstant)
            maximumFractionDigits = maximumFractionalDigit.toULong()
            minimumFractionDigits = minimumFractionalDigit.toULong()
            roundingMode = this@PeraNumberFormatter.peraRoundingMode.roundingMode
            if (useGrouping) {
                numberStyle = NSNumberFormatterDecimalStyle.apply {
                    groupingSize = this@PeraNumberFormatter.groupingSize.toULong()
                }
            }
        }
    }
}
