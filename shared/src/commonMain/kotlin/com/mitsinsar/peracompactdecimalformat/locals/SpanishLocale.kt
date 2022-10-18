package com.mitsinsar.peracompactdecimalformat.locals

import com.mitsinsar.peracompactdecimalformat.locals.NumberFormatLocale.SPANISH
import com.mitsinsar.peracompactdecimalformat.locals.base.BaseLocale
import com.mitsinsar.peracompactdecimalformat.locals.base.LocalizedSuffix
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.BILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.MILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.QUADRILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.QUINTILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.TRILLION

object SpanishLocale : BaseLocale() {

    override val localeConstant: String
        get() = SPANISH.localeConstant

    override fun addSuffixes() {
        addSuffix(MILLION, LocalizedSuffix("M", ""))
        addSuffix(BILLION, LocalizedSuffix("MM", ""))
        addSuffix(TRILLION, LocalizedSuffix("B", ""))
        addSuffix(QUADRILLION, LocalizedSuffix("C", ""))
        addSuffix(QUINTILLION, LocalizedSuffix("T", ""))
    }
}
