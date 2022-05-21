package com.mitsinsar.peracompactdecimalformat.utils

import platform.Foundation.NSNumberFormatterRoundCeiling
import platform.Foundation.NSNumberFormatterRoundDown
import platform.Foundation.NSNumberFormatterRoundFloor
import platform.Foundation.NSNumberFormatterRoundHalfDown
import platform.Foundation.NSNumberFormatterRoundHalfEven
import platform.Foundation.NSNumberFormatterRoundHalfUp
import platform.Foundation.NSNumberFormatterRoundUp
import platform.Foundation.NSNumberFormatterRoundingMode

actual enum class PeraRoundingMode(val roundingMode: NSNumberFormatterRoundingMode) {
    /**
     * Rounding mode to round away from zero.  Always increments the
     * digit prior to a non-zero discarded fraction.  Note that this
     * rounding mode never decreases the magnitude of the calculated
     * value.
     */
    UP(NSNumberFormatterRoundUp),

    /**
     * Rounding mode to round towards zero.  Never increments the digit
     * prior to a discarded fraction (i.e., truncates).  Note that this
     * rounding mode never increases the magnitude of the calculated value.
     */
    DOWN(NSNumberFormatterRoundDown),

    /**
     * Rounding mode to round towards positive infinity.  If the
     * result is positive, behaves as for `RoundingMode.UP`;
     * if negative, behaves as for `RoundingMode.DOWN`.  Note
     * that this rounding mode never decreases the calculated value.
     */
    CEILING(NSNumberFormatterRoundCeiling),

    /**
     * Rounding mode to round towards negative infinity.  If the
     * result is positive, behave as for `RoundingMode.DOWN`;
     * if negative, behave as for `RoundingMode.UP`.  Note that
     * this rounding mode never increases the calculated value.
     */
    FLOOR(NSNumberFormatterRoundFloor),

    /**
     * Rounding mode to round towards &quot;nearest neighbor&quot;
     * unless both neighbors are equidistant, in which case round up.
     * Behaves as for `RoundingMode.UP` if the discarded
     * fraction is  0.5; otherwise, behaves as for
     * `RoundingMode.DOWN`.  Note that this is the rounding
     * mode commonly taught at school.
     */
    HALF_UP(NSNumberFormatterRoundHalfUp),

    /**
     * Rounding mode to round towards &quot;nearest neighbor&quot;
     * unless both neighbors are equidistant, in which case round
     * down.  Behaves as for `RoundingMode.UP` if the discarded
     * fraction is &gt; 0.5; otherwise, behaves as for
     * `RoundingMode.DOWN`.
     */
    HALF_DOWN(NSNumberFormatterRoundHalfDown),

    /**
     * Rounding mode to round towards the &quot;nearest neighbor&quot;
     * unless both neighbors are equidistant, in which case, round
     * towards the even neighbor.  Behaves as for
     * `RoundingMode.HALF_UP` if the digit to the left of the
     * discarded fraction is odd; behaves as for
     * `RoundingMode.HALF_DOWN` if it's even.  Note that this
     * is the rounding mode that statistically minimizes cumulative
     * error when applied repeatedly over a sequence of calculations.
     * It is sometimes known as &quot;Banker&#39;s rounding,&quot; and is
     * chiefly used in the USA.  This rounding mode is analogous to
     * the rounding policy used for `float` and `double`
     * arithmetic in Java.
     */
    HALF_EVEN(NSNumberFormatterRoundHalfEven)
}
