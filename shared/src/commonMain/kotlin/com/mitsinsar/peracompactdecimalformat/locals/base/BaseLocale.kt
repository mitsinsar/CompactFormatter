package com.mitsinsar.peracompactdecimalformat.locals.base

import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants
import com.mitsinsar.peracompactdecimalformat.utils.PeraLogger

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
        return suffixList[numberConstants].also { localizedSuffix ->
            if (localizedSuffix == null) logNotImplementedLocalizedSuffix(numberConstants)
        }
    }

    private fun logNotImplementedLocalizedSuffix(numberConstants: NumberConstants) {
        PeraLogger.log(logTag, "Localized suffix is not implemented for $numberConstants")
    }

    companion object {
        private val logTag = BaseLocale::class.simpleName.orEmpty()
    }
}
