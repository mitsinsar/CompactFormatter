package com.mitsinsar.peracompactdecimalformat

import com.mitsinsar.peracompactdecimalformat.locals.EnglishLocale
import com.mitsinsar.peracompactdecimalformat.locals.base.BaseLocale
import com.mitsinsar.peracompactdecimalformat.numberformatter.NumberFormatter
import com.mitsinsar.peracompactdecimalformat.numberformatter.NumberFormatterBuilder
import com.mitsinsar.peracompactdecimalformat.utils.fractionaldigit.AssetFractionalDigit
import com.mitsinsar.peracompactdecimalformat.utils.fractionaldigit.FractionalDigit

class PeraCompactDecimalFormatBuilder(initialLocale: BaseLocale) {

    private var locale: BaseLocale = initialLocale
    private var style: CompactStyle = CompactStyle.SHORT
    private lateinit var numberFormatter: NumberFormatter
    private var fractionalDigitCreator: FractionalDigit.FractionalDigitCreator = AssetFractionalDigit

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

    fun setFractionalDigitCreator(
        newFractionalDigitCreator: FractionalDigit.FractionalDigitCreator
    ): PeraCompactDecimalFormatBuilder {
        fractionalDigitCreator = newFractionalDigitCreator
        return this
    }

    fun build(): PeraCompactDecimalFormat {
        setDefaultNumberFormatterIfNull()
        return PeraCompactDecimalFormat(
            locale = locale,
            style = style,
            numberFormatter = numberFormatter,
            fractionalDigitCreator = fractionalDigitCreator
        )
    }

    private fun setDefaultNumberFormatterIfNull() {
        if (!::numberFormatter.isInitialized) {
            numberFormatter = NumberFormatterBuilder.getInstance(locale.localeConstant).build()
        }
    }

    companion object {
        private val DEFAULT_LOCALE: BaseLocale by lazy { EnglishLocale }

        fun getInstance(locale: BaseLocale = DEFAULT_LOCALE) = PeraCompactDecimalFormatBuilder(locale)
    }
}
