package com.mitsinsar.peracompactdecimalformat.model

import com.mitsinsar.peracompactdecimalformat.utils.PeraDecimal

data class ParsedNumber(
    val rawNumber: PeraDecimal,
    val parsedNumber: PeraDecimal,
    val shiftCount: Int
)
