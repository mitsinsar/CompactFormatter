package com.mitsinsar.peracompactdecimalformat.locals.base

import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants
import java.math.BigDecimal
import java.util.Locale

abstract class BaseLocale {

    protected abstract val suffixList: List<Pair<NumberConstants, LocaleSuffix>>

    abstract val javaLocaleClass: Locale

    fun getShortSuffix(number: BigDecimal, indexProvider: NumberLocaleIndexProvider): String {
        return getLocalSuffix(number, indexProvider).shortSuffix
    }

    fun getLongSuffix(number: BigDecimal, indexProvider: NumberLocaleIndexProvider): String {
        return getLocalSuffix(number, indexProvider).longSuffix
    }

    protected open fun getLocalSuffix(number: BigDecimal, indexProvider: NumberLocaleIndexProvider): LocaleSuffix {
        val localSuffixIndex = indexProvider.getSuffixIndex(number)
        return suffixList.getOrNull(localSuffixIndex)?.second ?: suffixList.last().second
    }
}
