package com.mitsinsar.peracompactdecimalformat

import com.mitsinsar.peracompactdecimalformat.utils.PeraDecimal

abstract class BaseLocalizedFormatterTest {

    protected lateinit var formatter: PeraCompactDecimalFormat

    abstract fun checkIfMinimumSmallNumberWorks()

    abstract fun checkIfRandomSmallNumberWorks()

    abstract fun checkIfMaximumSmallNumberWorks()

    abstract fun checkIfMinimumThousandWorks()

    abstract fun checkIfRandomThousandWorks()

    abstract fun checkIfMaximumThousandWorks()

    abstract fun checkIfMinimumMillionWorks()

    abstract fun checkIfRandomMillionWorks()

    abstract fun checkIfMaximumMillionWorks()

    abstract fun checkIfMinimumBillionWorks()

    abstract fun checkIfRandomBillionWorks()

    abstract fun checkIfMaximumBillionWorks()

    abstract fun checkIfMinimumTrillionWorks()

    abstract fun checkIfRandomTrillionWorks()

    abstract fun checkIfMaximumTrillionWorks()

    abstract fun checkIfMinimumQuadrillionWorks()

    abstract fun checkIfRandomQuadrillionWorks()

    abstract fun checkIfMaximumQuadrillionWorks()

    abstract fun checkIfMinimumQuintillionWorks()

    abstract fun checkIfRandomQuintillionWorks()

    abstract fun checkIfMaxUINT64Works()

    protected fun assertFormattedNumber(
        rawNumber: String,
        expectedFormattedNumber: String,
        expectedSuffix: String?
    ): Boolean {
        val number = PeraDecimal(rawNumber)
        val formattedCompactDecimal = formatter.format(number)
        println(formattedCompactDecimal.toString())
        return with(formattedCompactDecimal) {
            this.number == number && formattedNumber == expectedFormattedNumber && suffix == expectedSuffix
        }
    }
}
