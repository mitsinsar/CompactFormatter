package com.mitsinsar.peracompactdecimalformat.utils

import platform.Foundation.NSDecimalNumber

actual class PeraDecimal actual constructor(val value: String) {

    actual fun scaleByPowerOfTen(power: Int): PeraDecimal {
        return NSDecimalNumber(value)
            .decimalNumberByMultiplyingByPowerOf10(power.toShort())
            .toPeraDecimal()
    }

    actual operator fun compareTo(other: PeraDecimal): Int {
        return NSDecimalNumber(value).compare(NSDecimalNumber(other.value)).toInt()
    }

    fun toNSDecimalNumber(): NSDecimalNumber {
        return NSDecimalNumber(value)
    }

    override fun toString(): String {
        return value
    }

    actual override fun equals(other: Any?): Boolean {
        return other is PeraDecimal && other.value == value
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }
}
