package com.mitsinsar.peracompactdecimalformat.locals

import com.mitsinsar.peracompactdecimalformat.locals.base.BaseLocale
import com.mitsinsar.peracompactdecimalformat.locals.base.LocaleSuffix
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants
import java.util.Locale

class EnglishLocale : BaseLocale() {
    override val javaLocaleClass: Locale
        get() = Locale.ENGLISH

    override val suffixList: List<Pair<NumberConstants, LocaleSuffix>>
        get() = listOf(
            NumberConstants.ZERO to LocaleSuffix.EMPTY_LOCALE_SUFFIX,
            NumberConstants.THOUSAND to LocaleSuffix("K", "Thousand"),
            NumberConstants.MILLION to LocaleSuffix("M", "Million"),
            NumberConstants.BILLION to LocaleSuffix("B", "Billion"),
            NumberConstants.TRILLION to LocaleSuffix("t", "Trillion"),
            NumberConstants.QUADRILLION to LocaleSuffix("q", "Quadrillion"),
            NumberConstants.QUINTILLION to LocaleSuffix("Q", "Quintillion")
        )
}
