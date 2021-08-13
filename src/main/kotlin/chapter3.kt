fun main(){
    val age1 = 42.0
    val age2 = 21.0

    val avg1 = (age1 + age2) / 2

    println(avg1)

    val firstName = "Nikola"
    val lastName = "Momcilovic"
    val fullName = "$firstName $lastName"
    val myDetails = "Hello, my name is $fullName."
    println(myDetails)

    val date = Triple(12, 5, 1996)
    var (month, day, year) = date

    month = 9
    val updateDate = Triple(month, day, year)
    println(updateDate)



    val coordinates = Pair(2,3)
    var (row, column) = coordinates

    val number = 10
    val multiplier = 5
    val summary = "$number multiplied by $multiplier equals ${number * multiplier}"
    println(summary)

    val a = 4
    val b: Short = 100
    val c: Byte = 12
    val sum: Int = a + b + c
    println(sum)

}