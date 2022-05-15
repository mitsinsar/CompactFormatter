package com.mitsinsar.peracompactdecimalformat.utils

import android.util.Range
import java.math.BigDecimal

internal infix fun BigDecimal.until(other: BigDecimal): Range<BigDecimal> {
    return Range(this, other.minus(BigDecimal.ZERO))
}

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
