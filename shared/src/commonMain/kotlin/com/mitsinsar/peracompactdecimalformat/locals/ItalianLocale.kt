package com.mitsinsar.peracompactdecimalformat.locals

import com.mitsinsar.peracompactdecimalformat.locals.NumberFormatLocale.ITALIAN
import com.mitsinsar.peracompactdecimalformat.locals.base.BaseLocale
import com.mitsinsar.peracompactdecimalformat.locals.base.LocalizedSuffix
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.BILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.MILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.QUADRILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.QUINTILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.THOUSAND
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.TRILLION

object ItalianLocale : BaseLocale() {

    override val localeConstant: String
        get() = ITALIAN.localeConstant

    override fun addSuffixes() {
        addSuffix(THOUSAND, LocalizedSuffix("K", ""))
        addSuffix(MILLION, LocalizedSuffix("M", ""))
        addSuffix(BILLION, LocalizedSuffix("B", ""))
        addSuffix(TRILLION, LocalizedSuffix("T", ""))
        addSuffix(QUADRILLION, LocalizedSuffix("Qa", ""))
        addSuffix(QUINTILLION, LocalizedSuffix("Qi", ""))
    }
}
