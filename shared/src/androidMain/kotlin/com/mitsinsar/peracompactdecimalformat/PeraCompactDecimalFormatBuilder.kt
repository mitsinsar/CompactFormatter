package com.mitsinsar.peracompactdecimalformat

import com.mitsinsar.peracompactdecimalformat.locals.base.BaseLocale
import com.mitsinsar.peracompactdecimalformat.locals.EnglishLocale
import com.mitsinsar.peracompactdecimalformat.locals.base.NumberLocaleIndexProvider
import com.mitsinsar.peracompactdecimalformat.locals.base.PeraLocaleIndexProvider
import com.mitsinsar.peracompactdecimalformat.numberformatter.NumberFormatter
import com.mitsinsar.peracompactdecimalformat.numberformatter.PeraNumberFormatter

class PeraCompactDecimalFormatBuilder {

    private lateinit var numberLocaleIndexProvider: NumberLocaleIndexProvider
    private lateinit var locale: BaseLocale
    private lateinit var numberFormatter: NumberFormatter
    private var style: CompactStyle = CompactStyle.SHORT

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

    fun setNumberLocaleIndexProvider(newIndexProvider: NumberLocaleIndexProvider): PeraCompactDecimalFormatBuilder {
        this.numberLocaleIndexProvider = newIndexProvider
        return this
    }

    fun build(): PeraCompactDecimalFormat {
        setGlobalsIfNotInitialized()
        return PeraCompactDecimalFormat(
            locale = locale,
            style = style,
            indexProvider = numberLocaleIndexProvider,
            numberFormatter = numberFormatter
        )
    }

    private fun setGlobalsIfNotInitialized() {
        setDefaultNumberLocaleIndexProviderIfNull()
        setDefaultLocaleIfNull()
        setDefaultNumberFormatterIfNull()
    }

    private fun setDefaultNumberFormatterIfNull() {
        if (!::numberFormatter.isInitialized) {
            numberFormatter = PeraNumberFormatter.getInstance(locale.javaLocaleClass)
        }
    }

    private fun setDefaultNumberLocaleIndexProviderIfNull() {
        if (!::numberLocaleIndexProvider.isInitialized) {
            numberLocaleIndexProvider = PeraLocaleIndexProvider.getInstance()
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
