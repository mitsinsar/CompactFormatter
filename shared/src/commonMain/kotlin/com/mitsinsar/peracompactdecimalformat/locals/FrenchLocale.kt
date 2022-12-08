package com.mitsinsar.peracompactdecimalformat.locals

import com.mitsinsar.peracompactdecimalformat.locals.NumberFormatLocale.FRENCH
import com.mitsinsar.peracompactdecimalformat.locals.base.BaseLocale
import com.mitsinsar.peracompactdecimalformat.locals.base.LocalizedSuffix
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.BILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.MILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.QUADRILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.QUINTILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.THOUSAND
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.TRILLION

object FrenchLocale : BaseLocale() {

    override val localeConstant: String
        get() = FRENCH.localeConstant

    override fun addSuffixes() {
        addSuffix(THOUSAND, LocalizedSuffix("K", "Millier"))
        addSuffix(MILLION, LocalizedSuffix("M", "Million"))
        addSuffix(BILLION, LocalizedSuffix("Md", "Milliard"))
        addSuffix(TRILLION, LocalizedSuffix("B", "Billion"))
        addSuffix(QUADRILLION, LocalizedSuffix("Bd", "Billiard"))
        addSuffix(QUINTILLION, LocalizedSuffix("T", "Trillion"))
    }
}
