package com.mitsinsar.peracompactdecimalformat.locals

import com.mitsinsar.peracompactdecimalformat.locals.NumberFormatLocale.SPANISH
import com.mitsinsar.peracompactdecimalformat.locals.base.BaseLocale
import com.mitsinsar.peracompactdecimalformat.locals.base.LocalizedSuffix
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.BILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.MILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.QUADRILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.QUINTILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.THOUSAND
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.TRILLION

object SpanishLocale : BaseLocale() {

    override val localeConstant: String
        get() = SPANISH.localeConstant

    override fun addSuffixes() {
        addSuffix(THOUSAND, LocalizedSuffix("K", "Mil"))
        addSuffix(MILLION, LocalizedSuffix("M", "Millón"))
        addSuffix(BILLION, LocalizedSuffix("MM", "Mil millones"))
        addSuffix(TRILLION, LocalizedSuffix("B", "Billón"))
        addSuffix(QUADRILLION, LocalizedSuffix("MB", "Mil billones"))
        addSuffix(QUINTILLION, LocalizedSuffix("T", "Trillón"))
    }
}
