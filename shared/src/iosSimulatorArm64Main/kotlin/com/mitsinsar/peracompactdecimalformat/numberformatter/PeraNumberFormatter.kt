package com.mitsinsar.peracompactdecimalformat.numberformatter

import java.math.BigDecimal

actual class PeraNumberFormatter(override val localeConstant: String) : NumberFormatter {
    actual override fun format(number: BigDecimal): String {
        return ""
    }

    actual companion object {
        actual fun getInstance(localeConstant: String): NumberFormatter = PeraNumberFormatter(localeConstant)
    }
}

