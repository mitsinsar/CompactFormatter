package com.mitsinsar.peracompactdecimalformat

import com.mitsinsar.peracompactdecimalformat.locals.TurkishLocale
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertTrue

@RunWith(JUnit4::class)
class TurkishFormatterTest : BaseLocalizedFormatterTest() {

    @Before
    fun setup() {
        formatter = PeraCompactDecimalFormatBuilder.getInstance()
            .setLocale(TurkishLocale())
            .excludeShorteningNumber(NumberConstants.THOUSAND)
            .build()
    }

    @Test
    override fun `check if minimum small number works`() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "0",
                expectedFormattedNumber = "0,00",
                expectedSuffix = null
            )
        }
    }

    @Test
    override fun `check if random small number works`() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "214.42521321324123",
                expectedFormattedNumber = "214,42",
                expectedSuffix = null
            )
        }
    }

    @Test
    override fun `check if maximum small number works`() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "999.999999999",
                expectedFormattedNumber = "999,99",
                expectedSuffix = null
            )
        }
    }

    @Test
    override fun `check if minimum thousand works`() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "1000.0000000000",
                expectedFormattedNumber = "1.000,00",
                expectedSuffix = null
            )
        }
    }

    @Test
    override fun `check if random thousand works`() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "541122.0124123",
                expectedFormattedNumber = "541.122,01",
                expectedSuffix = null
            )
        }
    }

    @Test
    override fun `check if maximum thousand works`() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "999999.999999999",
                expectedFormattedNumber = "999.999,99",
                expectedSuffix = null
            )
        }
    }

    @Test
    override fun `check if minimum million works`() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "1000000",
                expectedFormattedNumber = "1,00",
                expectedSuffix = "M"
            )
        }
    }

    @Test
    override fun `check if mid million works`() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "249520000",
                expectedFormattedNumber = "249,52",
                expectedSuffix = "M"
            )
        }
    }

    @Test
    override fun `check if max million works`() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "999999999.999",
                expectedFormattedNumber = "999,99",
                expectedSuffix = "M"
            )
        }
    }

    @Test
    override fun `check if minimum billion works`() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "1000000000.999",
                expectedFormattedNumber = "1,00",
                expectedSuffix = "Mr"
            )
        }
    }

    @Test
    override fun `check if random billion works`() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "12489000000.999",
                expectedFormattedNumber = "12,48",
                expectedSuffix = "Mr"
            )
        }
    }

    @Test
    override fun `check if maximum billion works`() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "999999999999.9999999",
                expectedFormattedNumber = "999,99",
                expectedSuffix = "Mr"
            )
        }
    }

    @Test
    override fun `check if minimum trillion works`() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "1000000000000",
                expectedFormattedNumber = "1,00",
                expectedSuffix = "T"
            )
        }
    }

    @Test
    override fun `check if random trillion works`() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "211782475000000.516316214",
                expectedFormattedNumber = "211,78",
                expectedSuffix = "T"
            )
        }
    }

    @Test
    override fun `check if maximum trillion works`() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "999999999999999.99999999",
                expectedFormattedNumber = "999,99",
                expectedSuffix = "T"
            )
        }
    }

    @Test
    override fun `check if minimum quadrillion works`() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "1000000000000000",
                expectedFormattedNumber = "1,00",
                expectedSuffix = "Kt"
            )
        }
    }

    @Test
    override fun `check if random quadrillion works`() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "261897000000000000.42187821",
                expectedFormattedNumber = "261,89",
                expectedSuffix = "Kt"
            )
        }
    }

    @Test
    override fun `check if maximum quadrillion works`() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "999999999999999999.9999999999",
                expectedFormattedNumber = "999,99",
                expectedSuffix = "Kt"
            )
        }
    }

    @Test
    override fun `check if minimum quintillion works`() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "1000000000000000000",
                expectedFormattedNumber = "1,00",
                expectedSuffix = "Kn"
            )
        }
    }

    @Test
    override fun `check if random quintillion works`() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "5878674635918825120.4215213",
                expectedFormattedNumber = "5,87",
                expectedSuffix = "Kn"
            )
        }
    }

    @Test
    override fun `check if max UINT64 works`() {
        assertTrue {
            assertFormattedNumber(
                rawNumber = "18446744073709551615",
                expectedFormattedNumber = "18,44",
                expectedSuffix = "Kn"
            )
        }
    }
}
