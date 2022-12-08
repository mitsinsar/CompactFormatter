package com.mitsinsar.peracompactdecimalformat.locals

import com.mitsinsar.peracompactdecimalformat.locals.NumberFormatLocale.JAPANESE
import com.mitsinsar.peracompactdecimalformat.locals.base.BaseLocale
import com.mitsinsar.peracompactdecimalformat.locals.base.LocalizedSuffix
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.BILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.MILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.QUADRILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.QUINTILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.THOUSAND
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.TRILLION

object JapaneseLocale : BaseLocale() {

    override val localeConstant: String
        get() = JAPANESE.localeConstant

    override fun addSuffixes() {
        addSuffix(THOUSAND, LocalizedSuffix("千", "千"))
        addSuffix(MILLION, LocalizedSuffix("百万", "百万"))
        addSuffix(BILLION, LocalizedSuffix("十億", "十億"))
        addSuffix(TRILLION, LocalizedSuffix("兆", "兆"))
        addSuffix(QUADRILLION, LocalizedSuffix("千兆", "千兆"))
        addSuffix(QUINTILLION, LocalizedSuffix("京", "京"))
    }
}
