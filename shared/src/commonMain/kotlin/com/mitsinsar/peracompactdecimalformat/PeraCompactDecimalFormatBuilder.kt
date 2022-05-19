package com.mitsinsar.peracompactdecimalformat

import com.mitsinsar.peracompactdecimalformat.locals.EnglishLocale
import com.mitsinsar.peracompactdecimalformat.locals.base.BaseLocale
import com.mitsinsar.peracompactdecimalformat.numberformatter.NumberFormatter
import com.mitsinsar.peracompactdecimalformat.numberformatter.PeraNumberFormatter
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants

class PeraCompactDecimalFormatBuilder {

    private lateinit var locale: BaseLocale
    private lateinit var numberFormatter: NumberFormatter
    private var style: CompactStyle = CompactStyle.SHORT
    private var excludeShorteningNumbersSet = mutableSetOf<NumberConstants>()

    fun setLocale(newLocale: BaseLocale): PeraCompactDecimalFormatBuilder {
        locale = newLocale
        return this
    }

    fun setStyle(newStyle: CompactStyle): PeraCompactDecimalFormatBuilder {
        style = newStyle
        return this
    }

    fun setNumberFormatter(newNumberFormatter: NumberFormatter): PeraCompactDecimalFormatBuilder {
        numberFormatter = newNumberFormatter
        return this
    }

    fun excludeShorteningNumber(vararg numberConstants: NumberConstants): PeraCompactDecimalFormatBuilder {
        excludeShorteningNumbersSet.addAll(numberConstants)
        return this
    }

    fun build(): PeraCompactDecimalFormat {
        setGlobalsIfNotInitialized()
        return PeraCompactDecimalFormat(
            locale = locale,
            style = style,
            numberFormatter = numberFormatter,
            excludedShorteningNumbersSet = excludeShorteningNumbersSet
        )
    }

    private fun setGlobalsIfNotInitialized() {
        setDefaultLocaleIfNull()
        setDefaultNumberFormatterIfNull()
    }

    private fun setDefaultNumberFormatterIfNull() {
        if (!::numberFormatter.isInitialized) {
            numberFormatter = PeraNumberFormatter.getInstance(locale.localeConstant)
        }
    }

    private fun setDefaultLocaleIfNull() {
        if (!::locale.isInitialized) {
            locale = DEFAULT_LOCALE
        }
    }

    companion object {
        private val DEFAULT_LOCALE: BaseLocale by lazy { EnglishLocale() }

        fun getInstance() = PeraCompactDecimalFormatBuilder()
    }
}
