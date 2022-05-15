package com.mitsinsar.peracompactdecimalformat.locals.base

data class LocaleSuffix(
    val shortSuffix: String,
    val longSuffix: String
) {
    companion object {
        val EMPTY_LOCALE_SUFFIX = LocaleSuffix("", "")
    }
}
