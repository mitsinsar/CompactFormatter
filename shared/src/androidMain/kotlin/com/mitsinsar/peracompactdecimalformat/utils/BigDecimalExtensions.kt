package com.mitsinsar.peracompactdecimalformat.utils

import java.math.BigDecimal

fun BigDecimal.toPeraDecimal(): PeraDecimal {
    return PeraDecimal(toPlainString())
}
