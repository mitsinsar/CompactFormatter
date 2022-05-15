package com.mitsinsar.peracompactdecimalformat

import java.math.BigDecimal

data class CompactDecimal(
    val number: BigDecimal,
    val formattedNumber: String,
    val suffix: String
) {

    val formattedNumberWithSuffix: String
        get() = "$formattedNumber$suffix"
}
