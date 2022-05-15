package com.mitsinsar.peracompactdecimalformat.locals.base

import com.mitsinsar.peracompactdecimalformat.exceptions.NumberOutOfRangeException
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.MAX_UINT64
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.THOUSAND
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.ZERO
import com.mitsinsar.peracompactdecimalformat.utils.isBiggerThan
import com.mitsinsar.peracompactdecimalformat.utils.isEqualTo
import com.mitsinsar.peracompactdecimalformat.utils.isLessThan
import java.math.BigDecimal

internal class PeraLocaleIndexProvider : NumberLocaleIndexProvider {

    override fun getSuffixIndex(number: BigDecimal): Int {
        if (number == BigDecimal.ZERO) return ZERO.ordinal
        checkIfNumberInSupportedRange(number)
        val numberConstantIndex = NumberConstants.values().indexOfLast {
            it.value isLessThan number || it.value isEqualTo number
        }
        return numberConstantIndex.takeIf { it > THOUSAND.ordinal } ?: ZERO.ordinal
    }

    private fun checkIfNumberInSupportedRange(number: BigDecimal) {
        val numberConstantList = NumberConstants.values()
        if (number isLessThan numberConstantList.first().value || number isBiggerThan MAX_UINT64.value) {
            throw NumberOutOfRangeException(number)
        }
    }

    companion object {
        fun getInstance(): NumberLocaleIndexProvider = PeraLocaleIndexProvider()
    }
}
