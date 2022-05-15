package com.mitsinsar.peracompactdecimalformat.numberformatter

import java.math.BigDecimal

interface NumberFormatter {

    fun format(number: BigDecimal): String
}
