package com.mitsinsar.peracompactdecimalformat.exceptions

import com.mitsinsar.peracompactdecimalformat.utils.NumberConstants
import java.math.BigDecimal

class NumberOutOfRangeException(
    number: BigDecimal
) : IllegalArgumentException(
    "Provided number is not supported by the library. " +
        "Make sure number is between zero and ${NumberConstants.values().last().value} " +
        "Provided number: $number"
)
