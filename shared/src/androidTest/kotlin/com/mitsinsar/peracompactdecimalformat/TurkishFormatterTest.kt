package com.mitsinsar.peracompactdecimalformat

import com.mitsinsar.peracompactdecimalformat.locals.TurkishLocale
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.math.BigDecimal
import kotlin.test.assertTrue

@RunWith(JUnit4::class)
class TurkishFormatterTest : BaseLocalizedFormatterTest {

    private lateinit var formatter: PeraCompactDecimalFormat

    @Before
    fun setup() {
        formatter = PeraCompactDecimalFormatBuilder.getInstance()
            .setLocale(TurkishLocale())
            .build()
    }

    @Test
    override fun `check if minimum small number works`() {
        // Given
        val number = BigDecimal("0")

        // When
        val formattedCompactDecimal = formatter.format(number)

        println(formattedCompactDecimal.toString())
        // Then
        assertTrue {
            with(formattedCompactDecimal) {
                this.number == number && formattedNumber == "0,00" && suffix == ""
            }
        }
    }

    @Test
    override fun `check if random small number works`() {
        // Given
        val number = BigDecimal("214.42521321324123")

        // When
        val formattedCompactDecimal = formatter.format(number)

        println(formattedCompactDecimal.toString())
        // Then
        assertTrue {
            with(formattedCompactDecimal) {
                this.number == number && formattedNumber == "214,42" && suffix == ""
            }
        }
    }

    @Test
    override fun `check if maximum small number works`() {
        // Given
        val number = BigDecimal("999.999999999")

        // When
        val formattedCompactDecimal = formatter.format(number)

        // Then
        assertTrue {
            with(formattedCompactDecimal) {
                this.number == number && formattedNumber == "999,99" && suffix == ""
            }
        }
    }

    @Test
    override fun `check if minimum thousand works`() {
        // Given
        val number = BigDecimal("1000.0000000000")

        // When
        val formattedCompactDecimal = formatter.format(number)

        println(formattedCompactDecimal.toString())
        // Then
        assertTrue {
            with(formattedCompactDecimal) {
                this.number == number && formattedNumber == "1.000,00" && suffix == ""
            }
        }
    }

    @Test
    override fun `check if random thousand works`() {
        // Given
        val number = BigDecimal("541122.0124123")

        // When
        val formattedCompactDecimal = formatter.format(number)

        println(formattedCompactDecimal.toString())
        // Then
        assertTrue {
            with(formattedCompactDecimal) {
                this.number == number && formattedNumber == "541.122,01" && suffix == ""
            }
        }
    }

    @Test
    override fun `check if maximum thousand works`() {
        // Given
        val number = BigDecimal("999999.999999999")

        // When
        val formattedCompactDecimal = formatter.format(number)

        println(formattedCompactDecimal.toString())
        // Then
        assertTrue {
            with(formattedCompactDecimal) {
                this.number == number && formattedNumber == "999.999,99" && suffix == ""
            }
        }
    }

    @Test
    override fun `check if minimum million works`() {
        // Given
        val number = BigDecimal("1000000")

        // When
        val formattedCompactDecimal = formatter.format(number)

        println(formattedCompactDecimal.toString())
        // Then
        assertTrue {
            with(formattedCompactDecimal) {
                this.number == number && formattedNumber == "1,00" && suffix == "M"
            }
        }
    }

    @Test
    override fun `check if mid million works`() {
        // Given
        val number = BigDecimal("249520000")

        // When
        val formattedCompactDecimal = formatter.format(number)

        println(formattedCompactDecimal.toString())
        // Then
        assertTrue {
            with(formattedCompactDecimal) {
                this.number == number && formattedNumber == "249,52" && suffix == "M"
            }
        }
    }

    @Test
    override fun `check if max million works`() {
        // Given
        val number = BigDecimal("999999999.999")

        // When
        val formattedCompactDecimal = formatter.format(number)

        println(formattedCompactDecimal.toString())
        // Then
        assertTrue {
            with(formattedCompactDecimal) {
                this.number == number && formattedNumber == "999,99" && suffix == "M"
            }
        }
    }

    @Test
    override fun `check if minimum billion works`() {
        // Given
        val number = BigDecimal("1000000000.999")

        // When
        val formattedCompactDecimal = formatter.format(number)

        println(formattedCompactDecimal.toString())
        // Then
        assertTrue {
            with(formattedCompactDecimal) {
                this.number == number && formattedNumber == "1,00" && suffix == "Mr"
            }
        }
    }

    @Test
    override fun `check if random billion works`() {
        // Given
        val number = BigDecimal("12489000000.999")

        // When
        val formattedCompactDecimal = formatter.format(number)

        println(formattedCompactDecimal.toString())
        // Then
        assertTrue {
            with(formattedCompactDecimal) {
                this.number == number && formattedNumber == "12,48" && suffix == "Mr"
            }
        }
    }

    @Test
    override fun `check if maximum billion works`() {
        // Given
        val number = BigDecimal("999999999999.9999999")

        // When
        val formattedCompactDecimal = formatter.format(number)

        println(formattedCompactDecimal.toString())
        // Then
        assertTrue {
            with(formattedCompactDecimal) {
                this.number == number && formattedNumber == "999,99" && suffix == "Mr"
            }
        }
    }

    @Test
    override fun `check if minimum trillion works`() {
        // Given
        val number = BigDecimal("1000000000000")

        // When
        val formattedCompactDecimal = formatter.format(number)

        println(formattedCompactDecimal.toString())
        // Then
        assertTrue {
            with(formattedCompactDecimal) {
                this.number == number && formattedNumber == "1,00" && suffix == "T"
            }
        }
    }

    @Test
    override fun `check if random trillion works`() {
        // Given
        val number = BigDecimal("211782475000000.516316214")

        // When
        val formattedCompactDecimal = formatter.format(number)

        println(formattedCompactDecimal.toString())
        // Then
        assertTrue {
            with(formattedCompactDecimal) {
                this.number == number && formattedNumber == "211,78" && suffix == "T"
            }
        }
    }

    @Test
    override fun `check if maximum trillion works`() {
        // Given
        val number = BigDecimal("999999999999999.99999999")

        // When
        val formattedCompactDecimal = formatter.format(number)

        println(formattedCompactDecimal.toString())
        // Then
        assertTrue {
            with(formattedCompactDecimal) {
                this.number == number && formattedNumber == "999,99" && suffix == "T"
            }
        }
    }

    @Test
    override fun `check if minimum quadrillion works`() {
        // Given
        val number = BigDecimal("1000000000000000")

        // When
        val formattedCompactDecimal = formatter.format(number)

        println(formattedCompactDecimal.toString())
        // Then
        assertTrue {
            with(formattedCompactDecimal) {
                this.number == number && formattedNumber == "1,00" && suffix == "Kt"
            }
        }
    }

    @Test
    override fun `check if random quadrillion works`() {
        // Given
        val number = BigDecimal("261897000000000000.42187821")

        // When
        val formattedCompactDecimal = formatter.format(number)

        println(formattedCompactDecimal.toString())
        // Then
        assertTrue {
            with(formattedCompactDecimal) {
                this.number == number && formattedNumber == "261,89" && suffix == "Kt"
            }
        }
    }

    @Test
    override fun `check if maximum quadrillion works`() {
        // Given
        val number = BigDecimal("999999999999999999.9999999999")

        // When
        val formattedCompactDecimal = formatter.format(number)

        println(formattedCompactDecimal.toString())
        // Then
        assertTrue {
            with(formattedCompactDecimal) {
                this.number == number && formattedNumber == "999,99" && suffix == "Kt"
            }
        }
    }

    @Test
    override fun `check if minimum quintillion works`() {
        // Given
        val number = BigDecimal("1000000000000000000")

        // When
        val formattedCompactDecimal = formatter.format(number)

        println(formattedCompactDecimal.toString())
        // Then
        assertTrue {
            with(formattedCompactDecimal) {
                this.number == number && formattedNumber == "1,00" && suffix == "Kn"
            }
        }
    }

    @Test
    override fun `check if random quintillion works`() {
        // Given
        val number = BigDecimal("5878674635918825120.4215213")

        // When
        val formattedCompactDecimal = formatter.format(number)

        println(formattedCompactDecimal.toString())
        // Then
        assertTrue {
            with(formattedCompactDecimal) {
                this.number == number && formattedNumber == "5,87" && suffix == "Kn"
            }
        }
    }

    @Test
    override fun `check if max UINT64 works`() {
        // Given
        val number = BigDecimal("18446744073709551615")

        // When
        val formattedCompactDecimal = formatter.format(number)

        println(formattedCompactDecimal.toString())
        // Then
        assertTrue {
            with(formattedCompactDecimal) {
                this.number == number && formattedNumber == "18,44" && suffix == "Kn"
            }
        }
    }
}
