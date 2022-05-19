package com.mitsinsar.peracompactdecimalformat.numberformatter

import java.math.BigDecimal

interface NumberFormatter {

    val localeConstant: String

    fun format(number: BigDecimal): String

    object Constants {
        const val FORMAT_PATTERN = "#,##0.00"
    }
}
