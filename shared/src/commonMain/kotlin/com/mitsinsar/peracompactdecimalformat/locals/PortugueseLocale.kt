package com.mitsinsar.peracompactdecimalformat.locals

import com.mitsinsar.peracompactdecimalformat.locals.NumberFormatLocale.PORTUGUESE
import com.mitsinsar.peracompactdecimalformat.locals.base.BaseLocale
import com.mitsinsar.peracompactdecimalformat.locals.base.LocalizedSuffix
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.BILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.MILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.QUADRILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.QUINTILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.THOUSAND
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.TRILLION

object PortugueseLocale : BaseLocale() {

    override val localeConstant: String
        get() = PORTUGUESE.localeConstant

    override fun addSuffixes() {
        addSuffix(THOUSAND, LocalizedSuffix("K", "Mil"))
        addSuffix(MILLION, LocalizedSuffix("M", "Milhão"))
        addSuffix(BILLION, LocalizedSuffix("B", "Bilhão"))
        addSuffix(TRILLION, LocalizedSuffix("T", "Trilhão"))
        addSuffix(QUADRILLION, LocalizedSuffix("Qa", "Quadrilhão"))
        addSuffix(QUINTILLION, LocalizedSuffix("Qi", "Quintilhão"))
    }
}
