import kotlin.math.PI
import kotlin.math.sqrt

fun main() {

    val date = SimpleDate("September")
    println("Do zime: " + date.monthsUntilWinterBreak())
    val date2 = SimpleDate("September")
    println("Do leta: " + date2.monthsUntilSummerBreak())

    println(MyMath.factorial(6))
    println(MyMath.triangle(3))

    println("CHALLENGES")

    println("1.")
    val circle = Circle2(5.0)
    println(circle.area)
    circle.grow(3.0)
    println(circle.area)

    println("2.")
    val today = SimpleDate2("September", 30)
    today.advance()
    println("${today.month} ${today.day}")

    println("3.")
    println(MyMath2.isEven(42))
    println(MyMath2.isOdd(42))

    println("4.")
    fun Int.isEven() = this % 2 == 0
    fun Int.isOdd() = this % 2 == 1
    println(42.isEven())
    println(42.isOdd())

    println("5.")
    fun Int.primeFactors(): List<Int> {
        var remainingValue = this
        var testFactor = 2
        val primes = kotlin.collections.mutableListOf<Int>()

        while (testFactor * testFactor <= remainingValue) {
            if (remainingValue % testFactor == 0) {
                primes.add(testFactor)
                remainingValue /= testFactor
            } else {
                testFactor += 1
            }
        }

        if (remainingValue>1){
            primes.add(remainingValue)
        }

        return primes
    }

    println(81.primeFactors())
}

val months = arrayOf(
    "January",
    "February",
    "March",
    "April",
    "May",
    "June",
    "July",
    "August",
    "September",
    "October",
    "November",
    "December"
)

class SimpleDate(var month: String) {
    fun monthsUntilWinterBreak(): Int {
        return months.indexOf("December") - months.indexOf(this.month)
    }
}

class MyMath {
    companion object {
        fun factorial(number: Int): Int {
            return (1..number).fold(1) { a, b -> a * b }
        }

        fun triangle(number: Int): Int {
            return (1..number).fold(0) { a, b -> a + b }
        }
    }
}

fun SimpleDate.monthsUntilSummerBreak(): Int {
    val monthIndex = months.indexOf(month)
    return if (monthIndex in 0..months.indexOf("June")) {
        months.indexOf("June") - months.indexOf(month)
    } else if (monthIndex in months.indexOf("June")..months.indexOf("August")) {
        0
    } else {
        months.indexOf("June") + (12 - months.indexOf(month))
    }
}

//CHALLENGES
//1.
class Circle2(var radius: Double = 0.0) {
    var area: Double
        get() {
            return PI * radius * radius
        }
        set(value) {
            radius = sqrt(value / PI)
        }

    fun grow(factor: Double) {
        area *= 3
    }
}

//2.
class SimpleDate2(var month: String, var day: Int = 0) {
    val totalDaysInCurrentMonth: Int
        get() {
            return when (month) {
                "January", "March", "May", "July", "August", "October", "December" -> 31
                "April", "June", "September", "November" -> 30
                "February" -> 28
                else -> 0
            }
        }

    fun advance() {
        if (day == totalDaysInCurrentMonth) {
            if (month == "December") {
                month = "January"
            } else {
                month = months[months.indexOf(month) + 1]
            }
            day = 1
        } else {
            day += 1
        }
    }
}

//3.
object MyMath2 {
    fun isEven(number: Int) = number % 2 == 0
    fun isOdd(number: Int) = number % 2 == 1
}