package com.mitsinsar.peracompactdecimalformat.utils

import java.math.BigDecimal

actual class PeraDecimal actual constructor(private val value: String) {

    override fun toString(): String {
        return value
    }

    actual fun scaleByPowerOfTen(power: Int): PeraDecimal {
        return BigDecimal(value).scaleByPowerOfTen(power).toPeraDecimal()
    }

    actual operator fun compareTo(other: PeraDecimal): Int {
        return BigDecimal(value).compareTo(BigDecimal(other.value))
    }

    actual override fun equals(other: Any?): Boolean {
        return other is PeraDecimal && value == other.value
    }

    fun toBigDecimal(): BigDecimal {
        return BigDecimal(value)
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }
}
