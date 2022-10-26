package com.mitsinsar.peracompactdecimalformat.locals

import com.mitsinsar.peracompactdecimalformat.locals.NumberFormatLocale.GERMAN
import com.mitsinsar.peracompactdecimalformat.locals.base.BaseLocale
import com.mitsinsar.peracompactdecimalformat.locals.base.LocalizedSuffix
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.BILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.MILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.QUADRILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.QUINTILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.TRILLION

object GermanLocale : BaseLocale() {

    override val localeConstant: String
        get() = GERMAN.localeConstant

    override fun addSuffixes() {
        addSuffix(MILLION, LocalizedSuffix("M", ""))
        addSuffix(BILLION, LocalizedSuffix("B", ""))
        addSuffix(TRILLION, LocalizedSuffix("T", ""))
        addSuffix(QUADRILLION, LocalizedSuffix("Qa", ""))
        addSuffix(QUINTILLION, LocalizedSuffix("Qi", ""))
    }
}
