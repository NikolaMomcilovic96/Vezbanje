import java.util.*

enum class DayOfTheWeek(val isWeekend: Boolean = false) {
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday(true),
    Sunday(true);

    fun daysUntil(other: DayOfTheWeek): Int {
        return if (this.ordinal < other.ordinal) {
            other.ordinal - this.ordinal
        } else {
            other.ordinal - this.ordinal + values().count()
        }
    }

    fun daysUntilWeekend(): Int {
        return daysUntil(firstWeekendDay())
    }

    companion object {
        fun today(): DayOfTheWeek {
            val calendarDayOfTheWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)

            var adjustedDay = calendarDayOfTheWeek - 2

            val days = values()

            if (adjustedDay < 0) {
                adjustedDay += days.count()
            }

            return days.first { it.ordinal == adjustedDay }
        }

        fun forIndex(index: Int): DayOfTheWeek? {
            return values().firstOrNull { it.ordinal == index }
        }

        fun forString(string: String): DayOfTheWeek? {
            return values().firstOrNull { it.name == string }
        }

        fun firstWeekendDay(): DayOfTheWeek {
            return values().first { it.isWeekend }
        }
    }
}

sealed class AcceptedCurrency {
    abstract val valueInDollars: Float
    var amount: Float = 0.0f

    class Dollar : AcceptedCurrency() {
        override val valueInDollars = 1.0f
    }

    class Euro : AcceptedCurrency() {
        override val valueInDollars = 1.25f
    }

    class Crypto : AcceptedCurrency() {
        override val valueInDollars = 2534.92f
    }

    val name: String
        get() = when (this) {
            is Euro -> "Euro"
            is Dollar -> "Dollar"
            is Crypto -> "NerdCoin"
        }

    fun totalValueInDollars(): Float {
        return amount * valueInDollars
    }

    companion object {
        fun checkSufficientFunds(fundsAvailable: List<AcceptedCurrency>, purchasePriceInDollars: Float): Boolean {
            val totalFudnsInDollars =
                fundsAvailable.fold(0.0f) { accumulator, currency -> accumulator + currency.valueInDollars }
            return totalFudnsInDollars >= purchasePriceInDollars
        }
    }

    operator fun plus(otherFunds: AcceptedCurrency):AcceptedCurrency{
        if (this::class==otherFunds::class){
            this.amount+=otherFunds.amount
            return this
        }else{
            val dollars = Dollar()
            dollars.amount=this.valueInDollars+otherFunds.valueInDollars
            return dollars
        }
    }
}

fun main() {
    for (day in DayOfTheWeek.values()) {
        println("Day ${day.ordinal}: ${day.name}, is weekend: ${day.isWeekend}")
    }

    val day = 2
    println("Day with index $day is ${DayOfTheWeek.values()[day]}")

    val wednesday = DayOfTheWeek.valueOf("Wednesday")
    println("$wednesday is day ${wednesday.ordinal}")

//    val notADay = DayOfTheWeek.valueOf("Utorak")
//    println("Not a day: $notADay")

    val today = DayOfTheWeek.today()
    val isWeekend = "It is ${if (today.isWeekend) "" else "not"} the weekend"

    val secondDay = DayOfTheWeek.Saturday
    val daysUntil = today.daysUntil(secondDay)
    println("It is $today. $isWeekend. There are $daysUntil days until $secondDay.")

    when (today) {
        DayOfTheWeek.Monday -> println("I don't care if $today's blue")
        DayOfTheWeek.Tuesday -> println("$today's gray")
        DayOfTheWeek.Wednesday -> println("And $today, too")
        DayOfTheWeek.Thursday -> println("$today, I don't care 'bout you")
        DayOfTheWeek.Friday -> println("It's $today, I'm in love")
        DayOfTheWeek.Saturday -> println("$today, Wait...")
        DayOfTheWeek.Sunday -> println("$today always comes late")
        //else -> println("I don't feel like singing")
    }

    //CHALLENGE

    val dayAtIndex = DayOfTheWeek.forIndex(3)
    println("Day at index 3: $dayAtIndex")

    val thursdayString = "Thursday"
    val thursdayDay = DayOfTheWeek.forString(thursdayString)
    println("Day of string $thursdayString is $thursdayDay")

    val firstWeekendDay = DayOfTheWeek.firstWeekendDay()
    val daysUntilWeekendFromWednesday = DayOfTheWeek.Wednesday.daysUntilWeekend()
    println("From Wednesday there are $daysUntilWeekendFromWednesday days until the weekend, which starts on $firstWeekendDay")

    val daysUntilWeekendFromSaturday = DayOfTheWeek.Saturday.daysUntilWeekend()
    println("From Saturday there are $daysUntilWeekendFromSaturday days until the weekend, which starts on $firstWeekendDay")


    val currency = AcceptedCurrency.Crypto()
    currency.amount = .27541f
    println("${currency.amount} of ${currency.name} is ${currency.totalValueInDollars()} in US Dollars!")

    val dollars = AcceptedCurrency.Dollar()
    dollars.amount = 2000f

    val sufficentBalance = AcceptedCurrency.checkSufficientFunds(listOf(currency, dollars), 1000f)
    println("You ${if (sufficentBalance) "do" else "do not"} have enough money to buy the thing!")
}