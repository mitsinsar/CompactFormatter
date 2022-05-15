package com.mitsinsar.peracompactdecimalformat.locals

import com.mitsinsar.peracompactdecimalformat.locals.base.BaseLocale
import com.mitsinsar.peracompactdecimalformat.locals.base.LocaleSuffix
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants
import java.util.Locale

class TurkishLocale : BaseLocale() {

    override val javaLocaleClass: Locale
        get() = Locale.forLanguageTag("tr-TR")

    override val suffixList: List<Pair<NumberConstants, LocaleSuffix>>
        get() = listOf(
            NumberConstants.ZERO to LocaleSuffix.EMPTY_LOCALE_SUFFIX,
            NumberConstants.THOUSAND to LocaleSuffix("B", "Bin"),
            NumberConstants.MILLION to LocaleSuffix("M", "Milyon"),
            NumberConstants.BILLION to LocaleSuffix("Mr", "Milyar"),
            NumberConstants.TRILLION to LocaleSuffix("T", "Trilyon"),
            NumberConstants.QUADRILLION to LocaleSuffix("Kt", "Katrilyon"),
            NumberConstants.QUINTILLION to LocaleSuffix("Kn", "Kentilyon")
        )
}
