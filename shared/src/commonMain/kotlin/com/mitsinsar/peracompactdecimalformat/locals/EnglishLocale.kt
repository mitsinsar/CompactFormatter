package com.mitsinsar.peracompactdecimalformat.locals

import com.mitsinsar.peracompactdecimalformat.locals.NumberFormatLocale.ENGLISH
import com.mitsinsar.peracompactdecimalformat.locals.base.BaseLocale
import com.mitsinsar.peracompactdecimalformat.locals.base.LocalizedSuffix
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.BILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.MILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.QUADRILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.QUINTILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.THOUSAND
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.TRILLION

class EnglishLocale : BaseLocale() {

    override val localeConstant: String
        get() = ENGLISH.localeConstant

    override fun addSuffixes() {
        addSuffix(THOUSAND, LocalizedSuffix("K", "Thousand"))
        addSuffix(MILLION, LocalizedSuffix("M", "Million"))
        addSuffix(BILLION, LocalizedSuffix("B", "Billion"))
        addSuffix(TRILLION, LocalizedSuffix("t", "Trillion"))
        addSuffix(QUADRILLION, LocalizedSuffix("q", "Quadrillion"))
        addSuffix(QUINTILLION, LocalizedSuffix("Q", "Quintillion"))
    }
}
