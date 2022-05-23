package com.mitsinsar.peracompactdecimalformat.model

import com.mitsinsar.peracompactdecimalformat.utils.PeraDecimal

data class CompactDecimal(
    val number: PeraDecimal,
    val formattedNumber: String,
    val suffix: String?
) {

    val formattedNumberWithSuffix: String
        get() = "$formattedNumber${suffix.orEmpty()}"
}
