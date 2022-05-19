package com.mitsinsar.peracompactdecimalformat.model

import java.math.BigDecimal

data class ParsedNumber(
    val rawNumber: BigDecimal,
    val parsedNumber: BigDecimal,
    val shiftCount: Int
)
