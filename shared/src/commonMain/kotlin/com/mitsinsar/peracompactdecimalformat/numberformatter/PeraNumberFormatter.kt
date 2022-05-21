package com.mitsinsar.peracompactdecimalformat.numberformatter

import com.mitsinsar.peracompactdecimalformat.utils.PeraDecimal
import com.mitsinsar.peracompactdecimalformat.utils.PeraRoundingMode

internal expect class PeraNumberFormatter internal constructor(
    localeConstant: String,
    peraRoundingMode: PeraRoundingMode,
    minimumFractionalDigit: Int,
    maximumFractionalDigit: Int,
    useGrouping: Boolean,
    groupingSize: Int
) : NumberFormatter {

    override fun format(number: PeraDecimal): String
}
