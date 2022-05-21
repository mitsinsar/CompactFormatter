package com.mitsinsar.peracompactdecimalformat.locals.base

import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants

abstract class BaseLocale {

    private val suffixList: MutableMap<NumberConstants, LocalizedSuffix> = mutableMapOf()

    abstract val localeConstant: String

    abstract fun addSuffixes()

    init {
        addSuffixes()
    }

    fun getShortSuffix(numberConstants: NumberConstants): String? {
        return getLocalSuffix(numberConstants)?.shortSuffix
    }

    fun getLongSuffix(numberConstants: NumberConstants): String? {
        return getLocalSuffix(numberConstants)?.longSuffix
    }

    protected fun addSuffix(numberConstants: NumberConstants, localizedSuffix: LocalizedSuffix) {
        suffixList[numberConstants] = localizedSuffix
    }

    private fun getLocalSuffix(numberConstants: NumberConstants): LocalizedSuffix? {
        return suffixList[numberConstants]
    }
}
