package com.mitsinsar.peracompactdecimalformat

import com.mitsinsar.peracompactdecimalformat.utils.fractionaldigit.CollectibleFractionalDigit
import kotlin.test.Test
import kotlin.test.assertTrue

class CollectibleEnglishFormatterTest : BaseLocalizedFormatterTest() {

    init {
        formatter = PeraCompactDecimalFormatBuilder.getInstance()
            .setFractionalDigitCreator(CollectibleFractionalDigit)
            .build()
    }

    @Test
    fun checkIfLessThanOneWithDecimalsWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "0.3242123",
                expectedFormattedNumber = "0.3",
                expectedSuffix = null
            )
        }
    }

    @Test
    fun checkIfLessThanOneWithoutDecimalsWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "0",
                expectedFormattedNumber = "0",
                expectedSuffix = null
            )
        }
    }

    @Test
    fun checkIfLessThanTenWithDecimalsWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "5.28334323",
                expectedFormattedNumber = "5.2",
                expectedSuffix = null
            )
        }
    }

    @Test
    fun checkIfLessThanTenWithThreeDecimalsWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "5.283",
                expectedFormattedNumber = "5.2",
                expectedSuffix = null
            )
        }
    }

    @Test
    fun checkIfLessThanTenWithOneDecimalWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "5.2",
                expectedFormattedNumber = "5.2",
                expectedSuffix = null
            )
        }
    }

    @Test
    fun checkIfLessThanTenWithoutDecimalsWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "5",
                expectedFormattedNumber = "5",
                expectedSuffix = null
            )
        }
    }

    @Test
    fun checkIfLessThanTenThousandWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "1999",
                expectedFormattedNumber = "1.9",
                expectedSuffix = "K"
            )
        }
    }

    @Test
    fun checkIfMoreThanTenThousandWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "10439.0000",
                expectedFormattedNumber = "10.4",
                expectedSuffix = "K"
            )
        }
    }

    @Test
    fun checkIfLessThanMillionWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "559012.12512321",
                expectedFormattedNumber = "559",
                expectedSuffix = "K"
            )
        }
    }

    @Test
    override fun checkIfMinimumSmallNumberWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "33",
                expectedFormattedNumber = "33",
                expectedSuffix = null
            )
        }
    }

    @Test
    override fun checkIfRandomSmallNumberWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "214.42521321324123",
                expectedFormattedNumber = "214.4",
                expectedSuffix = null
            )
        }
    }

    @Test
    override fun checkIfMaximumSmallNumberWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "999.999999999",
                expectedFormattedNumber = "999.9",
                expectedSuffix = null
            )
        }
    }

    @Test
    override fun checkIfMinimumThousandWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "1000.0000000000",
                expectedFormattedNumber = "1",
                expectedSuffix = "K"
            )
        }
    }

    @Test
    override fun checkIfRandomThousandWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "541122.0124123",
                expectedFormattedNumber = "541.1",
                expectedSuffix = "K"
            )
        }
    }

    @Test
    override fun checkIfMaximumThousandWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "999999.999999999",
                expectedFormattedNumber = "999.9",
                expectedSuffix = "K"
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
                expectedFormattedNumber = "249.5",
                expectedSuffix = "M"
            )
        }
    }

    @Test
    override fun checkIfMaximumMillionWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "999999999.999",
                expectedFormattedNumber = "999.9",
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
                expectedFormattedNumber = "12.4",
                expectedSuffix = "B"
            )
        }
    }

    @Test
    override fun checkIfMaximumBillionWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "999999999999.9999999",
                expectedFormattedNumber = "999.9",
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
                expectedFormattedNumber = "211.7",
                expectedSuffix = "T"
            )
        }
    }

    @Test
    override fun checkIfMaximumTrillionWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "999999999999999.99999999",
                expectedFormattedNumber = "999.9",
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
                expectedFormattedNumber = "261.8",
                expectedSuffix = "Qa"
            )
        }
    }

    @Test
    override fun checkIfMaximumQuadrillionWorks() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "999999999999999999.9999999999",
                expectedFormattedNumber = "999.9",
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
                expectedFormattedNumber = "5.8",
                expectedSuffix = "Qi"
            )
        }
    }

    @Test
    override fun checkIfMaxUINT64Works() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "18446744073709551615",
                expectedFormattedNumber = "18.4",
                expectedSuffix = "Qi"
            )
        }
    }
}
