# PeraCompactDecimalFormat

The PeraCompactDecimalFormat produces abbreviated numbers, suitable for display in environments will limited real estate. For example, **Algo: 342.24B** instead of **Algo: 342,249,670,000**. The format will be appropriate for the given language, such as **342,24Mrd.** for German.

Library supports numbers between **0** - **184,467,440,737,095,551,615** (UInt64)

## Usage

```kotlin

val formatter = PeraCompactDecimalFormatBuilder.getInstance().build()

val rawNumber = BigDecimal(1000000.00000)
val formattedNumber = formatter.format(rawNumber.toPeraDecimal())

println(formattedNumber)
// 1.00M

```

## Localization

Currently PeraCompactDecimalFormat supports the languages below. Default language option is `English`

* English
* Chinese
* French
* German
* Italian
* Japanese
* Korean
* Portuguese
* Spanish
* Turkish




### To use predefined local; 

```kotlin
val formatter = PeraCompactDecimalFormatBuilder
                 .getInstance(TurkishLocale)
                 .build()
// Or

val formatter = PeraCompactDecimalFormatBuilder.getInstance()
                 .setLocale(TurkishLocale)
                 .build()
```

### To use custom local; 
Extend `BaseLocale` class and override `localeConstants` which will be used to get suffix and formatting number.

```kotlin

object NewLocale: BaseLocale {
    override val localeConstant: String
        get() = "EN"

    override fun addSuffixes() {
        addSuffix(THOUSAND, LocalizedSuffix("K", "Thousand"))
        addSuffix(MILLION, LocalizedSuffix("M", "Million"))
        addSuffix(BILLION, LocalizedSuffix("B", "Billion"))
        addSuffix(TRILLION, LocalizedSuffix("t", "Trillion"))
        addSuffix(QUADRILLION, LocalizedSuffix("q", "Quadrillion"))
        addSuffix(QUINTILLION, LocalizedSuffix("Q", "Quintillion"))
    }
}

val formatter = PeraCompactDecimalFormatBuilder
                 .getInstance(NewLocale)
                 .build()
```

## Compact Style
Enum class to define style of the sellout. Default style is `CompactStyle.SHORT` 

```kotlin
enum class CompactStyle {
    // Longer version, like "1.2 trillion"
    LONG,

    // Short version, like "1.2T"
    SHORT
}

```

```kotlin
val formatter = PeraCompactDecimalFormatBuilder.getInstance()
            .setStyle(CompactStyle.LONG)
            .build()
```

## Number Formatter
There are 2 different predefined NumberFormatters in PeraCompactDecimalFormat. One for [iOS]() and one for [Android](). 
They are being used to format the given number as; **123415215.215** to **123,415,215.215**. 

`PeraNumberFormatter` can be customized by using `NumberFormatterBuilder` as shown below;

```kotlin

val peraNumberFormatter = NumberFormatterBuilder.getInstance(EnglishLocale.localeConstant)
            .setRoundingMode()
            .setMinimumFractionalDigit()
            .setMaximumFractionalDigit()
            .useGrouping()
            .setGroupingSize()
            .build()

val formatter = PeraCompactDecimalFormatBuilder
                 .setNumberFormatter(peraNumberFormatter)
                 .build()
```
```kotlin
/**
   Defines rounding mode. Check PeraRoundingMode for more details.
**/
fun setRoundingMode(roundingMode: PeraRoundingMode): NumberFormatterBuilder

/**
    Defines minimum fraction digit of the formatted number
      Example: Number = 100.9
      digitCount : 2 -> 100.90
**/
fun setMinimumFractionalDigit(digitCount: Int): NumberFormatterBuilder 

/**
    Defines maximum fraction digit of the formatted number
      Example: Number = 100.9876
      digitCount : 2 -> 100.98
**/
fun setMaximumFractionalDigit(digitCount: Int): NumberFormatterBuilder 

/**
    Set whether or not grouping will be used in this format.
      Example: Number = 10000.00
      useGrouping: true -> 10,000.00
      useGrouping: false -> 10000.00
**/
fun useGrouping(useGrouping: Boolean): NumberFormatterBuilder 

/**
    Defines grouping size of the number
      Example: Number = 10000.00
      groupingSize: 2 -> 1,00,00.00
      groupingSize: 3 -> 10,000.00
**/
fun setGroupingSize(groupingSize: Int): NumberFormatterBuilder 
```

These formatters can be overridden by creating new class which implements `NumberFormatter` interface. 


```kotlin
class CustomNumberFormatter constructor(
    override val localeConstant: String,
    override val peraRoundingMode: PeraRoundingMode,
    override val minimumFractionalDigit: Int,
    override val maximumFractionalDigit: Int,
    override val useGrouping: Boolean,
    override val groupingSize: Int
) : NumberFormatter {

    actual override fun format(number: PeraDecimal): String {
        return // TODO 
    }
}

val formatter = PeraCompactDecimalFormatBuilder.getInstance()
                 .setNumberFormatter(CustomNumberFormatter())
                 .build()
```

## Excluding number
Currently we don't shorten `thousand` in **Pera Wallet**. Specific constants can be excluded as shown below;
```kotlin
// Example
val number = 1200.489

// Without excluding 
val formatter = PeraCompactDecimalFormatBuilder.getInstance(TurkishLocale)
            .build()

formatter.format(number) // 1.20K

// With excluding 
val formatter = PeraCompactDecimalFormatBuilder.getInstance()
            .excludeShorteningNumber(NumberConstants.THOUSAND)
            .build()

formatter.format(number) // 1200.489
```

## License
[Apache 2.0](https://choosealicense.com/licenses/apache-2.0/)
