package com.mitsinsar.peracompactdecimalformat.numberformatter

import platform.Foundation.NSLocale
import platform.Foundation.NSNumberFormatter
import platform.Foundation.NSNumberFormatterRoundDown
import java.math.BigDecimal

actual class PeraNumberFormatter(override val localeConstant: String) : NumberFormatter {
    actual override fun format(number: BigDecimal): String {
        return NSNumberFormatter().apply {
            locale = NSLocale(localeConstant)
            maximumFractionDigits = 2L.toULong()
            roundingMode = NSNumberFormatterRoundDown
        }.negativeFormat()
    }

    // BigDecimal -> NSDecimal
    // Locale -> NSLocale

    /*

    extension Formatter {
 static func separatorWith(fraction value: Int, suffix: String? = nil) -> NumberFormatter {
    let formatter = NumberFormatter()
    formatter.locale = Locale.preferred()
    formatter.currencySymbol = ""
    formatter.numberStyle = .currencyAccounting
    formatter.minimumFractionDigits = value == 0 ? 0 : 2
    if let suffix = suffix, !suffix.isEmptyOrBlank {
      formatter.roundingMode = .down
      formatter.maximumFractionDigits = 2
    } else {
      formatter.maximumFractionDigits = value
    }
    formatter.negativeSuffix = suffix
    formatter.positiveSuffix = suffix
    return formatter
  }
}
     */
    actual companion object {
        actual fun getInstance(localeConstant: String): NumberFormatter = PeraNumberFormatter(localeConstant)
    }
}
