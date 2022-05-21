package com.mitsinsar.peracompactdecimalformat.utils

enum class NumberConstants(val value: PeraDecimal) {
    ZERO(PeraDecimal("0")),
    THOUSAND(PeraDecimal("1000")),
    MILLION(PeraDecimal("1000000")),
    BILLION(PeraDecimal("1000000000")),
    TRILLION(PeraDecimal("1000000000000")),
    QUADRILLION(PeraDecimal("1000000000000000")),
    QUINTILLION(PeraDecimal("1000000000000000000")),
    MAX_UINT64(PeraDecimal(ULong.MAX_VALUE.toString()));

    companion object {
        fun getByIndex(index: Int): NumberConstants = values()[index]
    }
}
