package com.mitsinsar.peracompactdecimalformat.utils

import java.math.BigDecimal

internal infix fun BigDecimal.isBiggerThan(other: BigDecimal): Boolean {
    return this.compareTo(other) == 1
}

internal infix fun BigDecimal.isLessThan(other: BigDecimal): Boolean {
    return this.compareTo(other) == -1
}

internal infix fun BigDecimal.isEqualTo(other: BigDecimal): Boolean {
    return this.compareTo(other) == 0
}

internal infix fun BigDecimal.isNotEqualTo(other: BigDecimal): Boolean {
    return this.compareTo(other) != 0
}
