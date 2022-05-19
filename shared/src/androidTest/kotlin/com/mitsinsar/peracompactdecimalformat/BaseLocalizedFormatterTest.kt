package com.mitsinsar.peracompactdecimalformat

import java.math.BigDecimal

abstract class BaseLocalizedFormatterTest {

    protected lateinit var formatter: PeraCompactDecimalFormat

    abstract fun `check if minimum small number works`()

    abstract fun `check if random small number works`()

    abstract fun `check if maximum small number works`()

    abstract fun `check if minimum thousand works`()

    abstract fun `check if random thousand works`()

    abstract fun `check if maximum thousand works`()

    abstract fun `check if minimum million works`()

    abstract fun `check if mid million works`()

    abstract fun `check if max million works`()

    abstract fun `check if minimum billion works`()

    abstract fun `check if random billion works`()

    abstract fun `check if maximum billion works`()

    abstract fun `check if minimum trillion works`()

    abstract fun `check if random trillion works`()

    abstract fun `check if maximum trillion works`()

    abstract fun `check if minimum quadrillion works`()

    abstract fun `check if random quadrillion works`()

    abstract fun `check if maximum quadrillion works`()

    abstract fun `check if minimum quintillion works`()

    abstract fun `check if random quintillion works`()

    abstract fun `check if max UINT64 works`()

    protected fun assertFormattedNumber(
        rawNumber: String,
        expectedFormattedNumber: String,
        expectedSuffix: String?
    ): Boolean {
        val number = BigDecimal(rawNumber)
        val formattedCompactDecimal = formatter.format(number)
        println(formattedCompactDecimal.toString())
        return with(formattedCompactDecimal) {
            this.number == number && formattedNumber == expectedFormattedNumber && suffix == expectedSuffix
        }
    }
}
