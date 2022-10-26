package com.mitsinsar.peracompactdecimalformat.locals

import com.mitsinsar.peracompactdecimalformat.locals.NumberFormatLocale.KOREAN
import com.mitsinsar.peracompactdecimalformat.locals.base.BaseLocale
import com.mitsinsar.peracompactdecimalformat.locals.base.LocalizedSuffix
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.BILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.MILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.QUADRILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.QUINTILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.THOUSAND
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.TRILLION

object KoreanLocale : BaseLocale() {

    override val localeConstant: String
        get() = KOREAN.localeConstant

    override fun addSuffixes() {
        addSuffix(THOUSAND, LocalizedSuffix("천", "1천"))
        addSuffix(MILLION, LocalizedSuffix("백만", "100만"))
        addSuffix(BILLION, LocalizedSuffix("십억", "10억"))
        addSuffix(TRILLION, LocalizedSuffix("조", "1조"))
        addSuffix(QUADRILLION, LocalizedSuffix("1000조", "1000조"))
        addSuffix(QUINTILLION, LocalizedSuffix("100경", "100경"))
    }
}
