package com.mitsinsar.peracompactdecimalformat.numberformatter

import com.mitsinsar.peracompactdecimalformat.utils.PeraDecimal
import com.mitsinsar.peracompactdecimalformat.utils.PeraRoundingMode

interface NumberFormatter {

    val localeConstant: String
    val peraRoundingMode: PeraRoundingMode
    val minimumFractionalDigit: Int
    val maximumFractionalDigit: Int
    val useGrouping: Boolean
    val groupingSize: Int

    fun format(number: PeraDecimal): String

    object Constants {
        const val FORMAT_PATTERN = "0.00"
    }
}
