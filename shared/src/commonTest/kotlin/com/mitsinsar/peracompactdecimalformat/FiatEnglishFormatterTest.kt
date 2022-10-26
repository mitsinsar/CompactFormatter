package com.mitsinsar.peracompactdecimalformat

import com.mitsinsar.peracompactdecimalformat.utils.fractionaldigit.FiatFractionalDigit
import kotlin.test.Test
import kotlin.test.assertTrue

class FiatEnglishFormatterTest : BaseLocalizedFormatterTest() {

    init {
        formatter = PeraCompactDecimalFormatBuilder.getInstance()
            .setFractionalDigitCreator(FiatFractionalDigit)
            .build()
    }

    @Test
    fun checkIfLessThanOneWithDecimalsWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "0.48364521521",
                expectedFormattedNumber = "0.483645",
                expectedSuffix = null
            )
        }
    }

    @Test
    fun checkIfLessThanOneWithoutDecimalsWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "0.0000000",
                expectedFormattedNumber = "0.00",
                expectedSuffix = null
            )
        }
    }

    @Test
    fun checkIfLessThanTenWithSingleDecimalWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "3.4",
                expectedFormattedNumber = "3.40",
                expectedSuffix = null
            )
        }
    }

    @Test
    fun checkIfLessThanTenWithDecimalsWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "5.2833",
                expectedFormattedNumber = "5.28",
                expectedSuffix = null
            )
        }
    }

    @Test
    fun checkIfLessThanTenWithoutDecimalsWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "5.0000000",
                expectedFormattedNumber = "5.00",
                expectedSuffix = null
            )
        }
    }

    @Test
    fun checkIfLessThanTenThousandWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "2242.02512",
                expectedFormattedNumber = "2,242.02",
                expectedSuffix = null
            )
        }
    }

    @Test
    fun checkIfMoreThanTenThousandWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "10439.0000",
                expectedFormattedNumber = "10,439.00",
                expectedSuffix = null
            )
        }
    }

    @Test
    fun checkIfLessThanMillionWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "559012.12512321",
                expectedFormattedNumber = "559,012.12",
                expectedSuffix = null
            )
        }
    }

    @Test
    override fun checkIfMinimumSmallNumberWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "0",
                expectedFormattedNumber = "0.00",
                expectedSuffix = null
            )
        }
    }

    @Test
    override fun checkIfRandomSmallNumberWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "214.42521321324123",
                expectedFormattedNumber = "214.42",
                expectedSuffix = null
            )
        }
    }

    @Test
    override fun checkIfMaximumSmallNumberWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "999.999999999",
                expectedFormattedNumber = "999.99",
                expectedSuffix = null
            )
        }
    }

    @Test
    override fun checkIfMinimumThousandWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "1000.0000000000",
                expectedFormattedNumber = "1,000.00",
                expectedSuffix = null
            )
        }
    }

    @Test
    override fun checkIfRandomThousandWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "541122.0124123",
                expectedFormattedNumber = "541,122.01",
                expectedSuffix = null
            )
        }
    }

    @Test
    override fun checkIfMaximumThousandWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "999999.999999999",
                expectedFormattedNumber = "999,999.99",
                expectedSuffix = null
            )
        }
    }

    @Test
    override fun checkIfMinimumMillionWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "1000000",
                expectedFormattedNumber = "1",
                expectedSuffix = "M"
            )
        }
    }

    @Test
    override fun checkIfRandomMillionWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "249520000",
                expectedFormattedNumber = "249.52",
                expectedSuffix = "M"
            )
        }
    }

    @Test
    override fun checkIfMaximumMillionWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "999999999.999",
                expectedFormattedNumber = "999.99",
                expectedSuffix = "M"
            )
        }
    }

    @Test
    override fun checkIfMinimumBillionWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "1000000000.999",
                expectedFormattedNumber = "1",
                expectedSuffix = "B"
            )
        }
    }

    @Test
    override fun checkIfRandomBillionWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "12489000000.999",
                expectedFormattedNumber = "12.48",
                expectedSuffix = "B"
            )
        }
    }

    @Test
    override fun checkIfMaximumBillionWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "999999999999.9999999",
                expectedFormattedNumber = "999.99",
                expectedSuffix = "B"
            )
        }
    }

    @Test
    override fun checkIfMinimumTrillionWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "1000000000000",
                expectedFormattedNumber = "1",
                expectedSuffix = "T"
            )
        }
    }

    @Test
    override fun checkIfRandomTrillionWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "211782475000000.516316214",
                expectedFormattedNumber = "211.78",
                expectedSuffix = "T"
            )
        }
    }

    @Test
    override fun checkIfMaximumTrillionWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "999999999999999.99999999",
                expectedFormattedNumber = "999.99",
                expectedSuffix = "T"
            )
        }
    }

    @Test
    override fun checkIfMinimumQuadrillionWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "1000000000000000",
                expectedFormattedNumber = "1",
                expectedSuffix = "Qa"
            )
        }
    }

    @Test
    override fun checkIfRandomQuadrillionWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "261897000000000000.42187821",
                expectedFormattedNumber = "261.89",
                expectedSuffix = "Qa"
            )
        }
    }

    @Test
    override fun checkIfMaximumQuadrillionWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "999999999999999999.9999999999",
                expectedFormattedNumber = "999.99",
                expectedSuffix = "Qa"
            )
        }
    }

    @Test
    override fun checkIfMinimumQuintillionWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "1000000000000000000",
                expectedFormattedNumber = "1",
                expectedSuffix = "Qi"
            )
        }
    }

    @Test
    override fun checkIfRandomQuintillionWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "5878674635918825120.4215213",
                expectedFormattedNumber = "5.87",
                expectedSuffix = "Qi"
            )
        }
    }

    @Test
    override fun checkIfMaxUINT64Works() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "18446744073709551615",
                expectedFormattedNumber = "18.44",
                expectedSuffix = "Qi"
            )
        }
    }
}
