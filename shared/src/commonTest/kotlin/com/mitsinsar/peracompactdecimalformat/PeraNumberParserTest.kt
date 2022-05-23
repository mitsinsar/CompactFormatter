package com.mitsinsar.peracompactdecimalformat

import com.mitsinsar.peracompactdecimalformat.numberformatter.PeraNumberParser.parseNumber
import com.mitsinsar.peracompactdecimalformat.utils.PeraDecimal
import kotlin.test.Test
import kotlin.test.assertTrue

class PeraNumberParserTest {

    @Test
    fun checkIfMinimumWorks() {
        // Given
        val minimumNumber = PeraDecimal("0")

        // When
        val parsedNumber = parseNumber(minimumNumber)

        // Then
        assertTrue {
            with(parsedNumber) {
                this.parsedNumber == PeraDecimal("0") &&
                    rawNumber == minimumNumber &&
                    shiftCount == 0
            }
        }
    }

    @Test
    fun checkIfHundredWorks() {
        // Given
        val minimumNumber = PeraDecimal("512.25213125")

        // When
        val parsedNumber = parseNumber(minimumNumber)

        // Then
        assertTrue {
            with(parsedNumber) {
                this.parsedNumber == PeraDecimal("512.25213125") &&
                    rawNumber == minimumNumber &&
                    shiftCount == 0
            }
        }
    }

    @Test
    fun checkIfThousandWorks() {
        // Given
        val minimumNumber = PeraDecimal("124125.25213125")

        // When
        val parsedNumber = parseNumber(minimumNumber)

        // Then
        assertTrue {
            with(parsedNumber) {
                this.parsedNumber == PeraDecimal("124.12525213125") &&
                    rawNumber == minimumNumber &&
                    shiftCount == 1
            }
        }
    }

    @Test
    fun checkIfMillionWorks() {
        // Given
        val minimumNumber = PeraDecimal("5124125.25213125")

        // When
        val parsedNumber = parseNumber(minimumNumber)

        // Then

        assertTrue {
            with(parsedNumber) {
                this.parsedNumber == PeraDecimal("5.12412525213125") &&
                    rawNumber == minimumNumber &&
                    shiftCount == 2
            }
        }
    }

    @Test
    fun checkIfBillionWorks() {
        // Given
        val minimumNumber = PeraDecimal("124125252241.24123")

        // When
        val parsedNumber = parseNumber(minimumNumber)

        // Then
        assertTrue {
            with(parsedNumber) {
                this.parsedNumber == PeraDecimal("124.12525224124123") &&
                    rawNumber == minimumNumber &&
                    shiftCount == 3
            }
        }
    }

    @Test
    fun checkIfTrillionWorks() {
        // Given
        val minimumNumber = PeraDecimal("1234567891234.56789")

        // When
        val parsedNumber = parseNumber(minimumNumber)

        // Then
        assertTrue {
            with(parsedNumber) {
                this.parsedNumber == PeraDecimal("1.23456789123456789") &&
                    rawNumber == minimumNumber &&
                    shiftCount == 4
            }
        }
    }

    @Test
    fun checkIfQuadrillionWorks() {
        // Given
        val minimumNumber = PeraDecimal("1234567891234567.89")

        // When
        val parsedNumber = parseNumber(minimumNumber)

        // Then
        assertTrue {
            with(parsedNumber) {
                this.parsedNumber == PeraDecimal("1.23456789123456789") &&
                    rawNumber == minimumNumber &&
                    shiftCount == 5
            }
        }
    }
}
