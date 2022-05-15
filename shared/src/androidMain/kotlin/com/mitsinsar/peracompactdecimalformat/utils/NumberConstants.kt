package com.mitsinsar.peracompactdecimalformat.utils

import java.math.BigDecimal

enum class NumberConstants(val value: BigDecimal) {
    ZERO(BigDecimal.ZERO),
    THOUSAND(BigDecimal("1000")),
    MILLION(BigDecimal("1000000")),
    BILLION(BigDecimal("1000000000")),
    TRILLION(BigDecimal("1000000000000")),
    QUADRILLION(BigDecimal("1000000000000000")),
    QUINTILLION(BigDecimal("1000000000000000000")),
    MAX_UINT64(BigDecimal(ULong.MAX_VALUE.toString()))
}
