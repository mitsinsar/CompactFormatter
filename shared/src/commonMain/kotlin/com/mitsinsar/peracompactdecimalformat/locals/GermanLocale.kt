package com.mitsinsar.peracompactdecimalformat.locals

import com.mitsinsar.peracompactdecimalformat.locals.NumberFormatLocale.GERMAN
import com.mitsinsar.peracompactdecimalformat.locals.base.BaseLocale
import com.mitsinsar.peracompactdecimalformat.locals.base.LocalizedSuffix
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.BILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.MILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.QUADRILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.QUINTILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.THOUSAND
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.TRILLION

object GermanLocale : BaseLocale() {

    override val localeConstant: String
        get() = GERMAN.localeConstant

    override fun addSuffixes() {
        addSuffix(THOUSAND, LocalizedSuffix("K", "Tausend"))
        addSuffix(MILLION, LocalizedSuffix("M", "Millionen"))
        addSuffix(BILLION, LocalizedSuffix("B", "Milliarden"))
        addSuffix(TRILLION, LocalizedSuffix("T", "Billionen"))
        addSuffix(QUADRILLION, LocalizedSuffix("Qa", "Billiarden"))
        addSuffix(QUINTILLION, LocalizedSuffix("Qi", "Trillionen"))
    }
}
