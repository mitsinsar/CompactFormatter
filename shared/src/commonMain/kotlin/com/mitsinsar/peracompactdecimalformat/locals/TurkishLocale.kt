package com.mitsinsar.peracompactdecimalformat.locals

import com.mitsinsar.peracompactdecimalformat.locals.NumberFormatLocale.TURKISH
import com.mitsinsar.peracompactdecimalformat.locals.base.BaseLocale
import com.mitsinsar.peracompactdecimalformat.locals.base.LocalizedSuffix
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.BILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.MILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.QUADRILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.QUINTILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.THOUSAND
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.TRILLION

class TurkishLocale : BaseLocale() {

    override val localeConstant: String
        get() = TURKISH.localeConstant

    override fun addSuffixes() {
        addSuffix(THOUSAND, LocalizedSuffix("B", "Bin"))
        addSuffix(MILLION, LocalizedSuffix("M", "Milyon"))
        addSuffix(BILLION, LocalizedSuffix("Mr", "Milyar"))
        addSuffix(TRILLION, LocalizedSuffix("T", "Trilyon"))
        addSuffix(QUADRILLION, LocalizedSuffix("Kt", "Katrilyon"))
        addSuffix(QUINTILLION, LocalizedSuffix("Kn", "Kentilyon"))
    }
}
