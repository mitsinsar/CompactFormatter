package com.mitsinsar.peracompactdecimalformat.utils

import platform.Foundation.NSDecimalNumber

fun NSDecimalNumber.toPeraDecimal(): PeraDecimal {
    return PeraDecimal(stringValue)
}
