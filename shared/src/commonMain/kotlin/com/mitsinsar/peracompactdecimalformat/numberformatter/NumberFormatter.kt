package com.mitsinsar.peracompactdecimalformat.numberformatter

import com.mitsinsar.peracompactdecimalformat.utils.FractionalDigit
import com.mitsinsar.peracompactdecimalformat.utils.PeraDecimal
import com.mitsinsar.peracompactdecimalformat.utils.PeraRoundingMode

interface NumberFormatter {

    val localeConstant: String
    val peraRoundingMode: PeraRoundingMode
    val useGrouping: Boolean
    val groupingSize: Int

    fun format(number: PeraDecimal, fractionalDigit: FractionalDigit): String

    object Constants {
        const val FORMAT_PATTERN = "0.00"
    }
}
