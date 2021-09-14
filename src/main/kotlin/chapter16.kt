enum class DayOfTheWeek{
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday,
    Sunday
}

fun main(){
    for (day in DayOfTheWeek.values()){
        println("Day ${day.ordinal}: ${day.name}")
    }

    val day = 2
    println("Day with index $day is ${DayOfTheWeek.values()[day]}")

    val wednesday = DayOfTheWeek.valueOf("Wednesday")
    println("$wednesday is day ${wednesday.ordinal}")

//    val notADay = DayOfTheWeek.valueOf("Utorak")
//    println("Not a day: $notADay")
}