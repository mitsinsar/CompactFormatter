package com.mitsinsar.peracompactdecimalformat.numberformatter

import java.math.BigDecimal

expect class PeraNumberFormatter : NumberFormatter {

    override fun format(number: BigDecimal): String

    companion object {
        fun getInstance(localeConstant: String): NumberFormatter
    }
}
