package com.mitsinsar.peracompactdecimalformat

import com.mitsinsar.peracompactdecimalformat.numberformatter.PeraNumberParser.parseNumber
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.math.BigDecimal
import kotlin.test.assertTrue

@RunWith(JUnit4::class)
class PeraNumberParserTest {

    @Test
    fun `check if minimum works`() {
        // Given
        val minimumNumber = BigDecimal.ZERO

        // When
        val parsedNumber = parseNumber(minimumNumber)

        // Then
        assertTrue {
            with(parsedNumber) {
                this.parsedNumber == BigDecimal("0") &&
                    rawNumber == minimumNumber &&
                    shiftCount == 0
            }
        }
    }

    @Test
    fun `check if hundred works`() {
        // Given
        val minimumNumber = BigDecimal("512.25213125")

        // When
        val parsedNumber = parseNumber(minimumNumber)

        // Then
        assertTrue {
            with(parsedNumber) {
                this.parsedNumber == BigDecimal("512.25213125") &&
                    rawNumber == minimumNumber &&
                    shiftCount == 0
            }
        }
    }

    @Test
    fun `check if thousand works`() {
        // Given
        val minimumNumber = BigDecimal("124125.25213125")

        // When
        val parsedNumber = parseNumber(minimumNumber)

        // Then
        assertTrue {
            with(parsedNumber) {
                this.parsedNumber == BigDecimal("124.12525213125") &&
                    rawNumber == minimumNumber &&
                    shiftCount == 1
            }
        }
    }

    @Test
    fun `check if million works`() {
        // Given
        val minimumNumber = BigDecimal("5124125.25213125")

        // When
        val parsedNumber = parseNumber(minimumNumber)

        // Then

        assertTrue {
            with(parsedNumber) {
                this.parsedNumber == BigDecimal("5.12412525213125") &&
                    rawNumber == minimumNumber &&
                    shiftCount == 2
            }
        }
    }

    @Test
    fun `check if billion works`() {
        // Given
        val minimumNumber = BigDecimal("124125252241.24123")

        // When
        val parsedNumber = parseNumber(minimumNumber)

        // Then
        assertTrue {
            with(parsedNumber) {
                this.parsedNumber == BigDecimal("124.12525224124123") &&
                    rawNumber == minimumNumber &&
                    shiftCount == 3
            }
        }
    }

    @Test
    fun `check if trillion works`() {
        // Given
        val minimumNumber = BigDecimal("1234567891234.567890")

        // When
        val parsedNumber = parseNumber(minimumNumber)

        // Then
        assertTrue {
            with(parsedNumber) {
                this.parsedNumber == BigDecimal("1.234567891234567890") &&
                    rawNumber == minimumNumber &&
                    shiftCount == 4
            }
        }
    }

    @Test
    fun `check if quadrillion works`() {
        // Given
        val minimumNumber = BigDecimal("1234567891234567.890")

        // When
        val parsedNumber = parseNumber(minimumNumber)

        // Then
        assertTrue {
            with(parsedNumber) {
                this.parsedNumber == BigDecimal("1.234567891234567890") &&
                    rawNumber == minimumNumber &&
                    shiftCount == 5
            }
        }
    }

    @Test
    fun `check if quintillion works`() {
        // Given
        val minimumNumber = BigDecimal("1234567891234567890")

        // When
        val parsedNumber = parseNumber(minimumNumber)

        // Then
        assertTrue {
            with(parsedNumber) {
                this.parsedNumber == BigDecimal("1.234567891234567890") &&
                    rawNumber == minimumNumber &&
                    shiftCount == 6
            }
        }
    }
}
