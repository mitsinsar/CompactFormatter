package com.mitsinsar.peracompactdecimalformat.numberformatter

import com.mitsinsar.peracompactdecimalformat.utils.PeraRoundingMode

class NumberFormatterBuilder(private val localeConstant: String) {

    private var roundingMode: PeraRoundingMode = DEFAULT_ROUNDING_MODE
    private var useGrouping: Boolean = DEFAULT_GROUPING_PREFERENCE
    private var groupingSize: Int = DEFAULT_GROUPING_SIZE

    fun setRoundingMode(roundingMode: PeraRoundingMode): NumberFormatterBuilder {
        this.roundingMode = roundingMode
        return this
    }


    fun useGrouping(useGrouping: Boolean): NumberFormatterBuilder {
        this.useGrouping = useGrouping
        return this
    }

    fun setGroupingSize(groupingSize: Int): NumberFormatterBuilder {
        this.groupingSize = groupingSize
        return this
    }

    fun build(): NumberFormatter {
        return PeraNumberFormatter(
            localeConstant,
            roundingMode,
            useGrouping,
            groupingSize
        )
    }

    companion object {
        private val DEFAULT_ROUNDING_MODE = PeraRoundingMode.DOWN
        private const val DEFAULT_GROUPING_PREFERENCE = true
        private const val DEFAULT_GROUPING_SIZE = 3

        fun getInstance(localeConstant: String) = NumberFormatterBuilder(localeConstant)
    }
}
