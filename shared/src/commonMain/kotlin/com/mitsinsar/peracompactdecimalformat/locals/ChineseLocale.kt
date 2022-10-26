package com.mitsinsar.peracompactdecimalformat.locals

import com.mitsinsar.peracompactdecimalformat.locals.NumberFormatLocale.CHINESE
import com.mitsinsar.peracompactdecimalformat.locals.base.BaseLocale
import com.mitsinsar.peracompactdecimalformat.locals.base.LocalizedSuffix
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.BILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.THOUSAND
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.MILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.QUADRILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.QUINTILLION
import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants.TRILLION

object ChineseLocale : BaseLocale() {

    override val localeConstant: String
        get() = CHINESE.localeConstant

    override fun addSuffixes() {
        addSuffix(THOUSAND, LocalizedSuffix("千", "千"))
        addSuffix(MILLION, LocalizedSuffix("百万", "百万"))
        addSuffix(BILLION, LocalizedSuffix("十亿", "十亿"))
        addSuffix(TRILLION, LocalizedSuffix("万亿", "万亿"))
        addSuffix(QUADRILLION, LocalizedSuffix("千万亿", "千万亿"))
        addSuffix(QUINTILLION, LocalizedSuffix("千亿", "千亿"))
    }
}
