package com.mitsinsar.peracompactdecimalformat.locals.base

import java.math.BigDecimal

interface NumberLocaleIndexProvider {
    fun getSuffixIndex(number: BigDecimal): Int
}
