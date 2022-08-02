package com.mitsinsar.peracompactdecimalformat

import com.mitsinsar.peracompactdecimalformat.locals.TurkishLocale
import kotlin.test.Test
import kotlin.test.assertTrue

class TurkishFormatterTest : BaseLocalizedFormatterTest() {

    init {
        formatter = PeraCompactDecimalFormatBuilder.getInstance(TurkishLocale)
            .build()
    }

    @Test
    override fun checkIfMinimumSmallNumberWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "0",
                expectedFormattedNumber = "0,00",
                expectedSuffix = null
            )
        }
    }

    @Test
    override fun checkIfRandomSmallNumberWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "214.42521321324123",
                expectedFormattedNumber = "214,42",
                expectedSuffix = null
            )
        }
    }

    @Test
    override fun checkIfMaximumSmallNumberWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "999.999999999",
                expectedFormattedNumber = "999,99",
                expectedSuffix = null
            )
        }
    }

    @Test
    override fun checkIfMinimumThousandWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "1000.0000000000",
                expectedFormattedNumber = "1.000,00",
                expectedSuffix = null
            )
        }
    }

    @Test
    override fun checkIfRandomThousandWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "541122.0124123",
                expectedFormattedNumber = "541.122,01",
                expectedSuffix = null
            )
        }
    }

    @Test
    override fun checkIfMaximumThousandWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "999999.999999999",
                expectedFormattedNumber = "999.999,99",
                expectedSuffix = null
            )
        }
    }

    @Test
    override fun checkIfMinimumMillionWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "1000000",
                expectedFormattedNumber = "1,00",
                expectedSuffix = "M"
            )
        }
    }

    @Test
    override fun checkIfRandomMillionWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "249520000",
                expectedFormattedNumber = "249,52",
                expectedSuffix = "M"
            )
        }
    }

    @Test
    override fun checkIfMaximumMillionWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "999999999.999",
                expectedFormattedNumber = "999,99",
                expectedSuffix = "M"
            )
        }
    }

    @Test
    override fun checkIfMinimumBillionWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "1000000000.999",
                expectedFormattedNumber = "1,00",
                expectedSuffix = "Mr"
            )
        }
    }

    @Test
    override fun checkIfRandomBillionWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "12489000000.999",
                expectedFormattedNumber = "12,48",
                expectedSuffix = "Mr"
            )
        }
    }

    @Test
    override fun checkIfMaximumBillionWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "999999999999.9999999",
                expectedFormattedNumber = "999,99",
                expectedSuffix = "Mr"
            )
        }
    }

    @Test
    override fun checkIfMinimumTrillionWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "1000000000000",
                expectedFormattedNumber = "1,00",
                expectedSuffix = "T"
            )
        }
    }

    @Test
    override fun checkIfRandomTrillionWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "211782475000000.516316214",
                expectedFormattedNumber = "211,78",
                expectedSuffix = "T"
            )
        }
    }

    @Test
    override fun checkIfMaximumTrillionWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "999999999999999.99999999",
                expectedFormattedNumber = "999,99",
                expectedSuffix = "T"
            )
        }
    }

    @Test
    override fun checkIfMinimumQuadrillionWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "1000000000000000",
                expectedFormattedNumber = "1,00",
                expectedSuffix = "Kt"
            )
        }
    }

    @Test
    override fun checkIfRandomQuadrillionWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "261897000000000000.42187821",
                expectedFormattedNumber = "261,89",
                expectedSuffix = "Kt"
            )
        }
    }

    @Test
    override fun checkIfMaximumQuadrillionWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "999999999999999999.9999999999",
                expectedFormattedNumber = "999,99",
                expectedSuffix = "Kt"
            )
        }
    }

    @Test
    override fun checkIfMinimumQuintillionWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "1000000000000000000",
                expectedFormattedNumber = "1,00",
                expectedSuffix = "Kn"
            )
        }
    }

    @Test
    override fun checkIfRandomQuintillionWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "5878674635918825120.4215213",
                expectedFormattedNumber = "5,87",
                expectedSuffix = "Kn"
            )
        }
    }

    @Test
    override fun checkIfMaxUINT64Works() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "18446744073709551615",
                expectedFormattedNumber = "18,44",
                expectedSuffix = "Kn"
            )
        }
    }
}
