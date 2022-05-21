package com.mitsinsar.peracompactdecimalformat.utils

expect class PeraDecimal(value: String) {

    fun scaleByPowerOfTen(power: Int): PeraDecimal

    operator fun compareTo(other: PeraDecimal): Int

    override operator fun equals(other: Any?): Boolean
}
