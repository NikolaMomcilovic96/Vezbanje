import kotlin.math.sqrt

fun main(){

    val (name,age) = Pair("Nikola", 24)
    when(age) {
        in 0..2 -> println("$name is an Infant")
        in 3..12 -> println("$name is an Child")
        in 13..19 -> println("$name is an Teenager")
        in 20..39 -> println("$name is an Adult")
        in 40..60 -> println("$name is an Middle aged")
        in 61..Int.MAX_VALUE -> println("$name is an Elderly")
        else -> println("Invalid age")
    }


    var aLotOfAs = ""
    while (aLotOfAs.length<10){
        aLotOfAs+="a"
    }
    println(aLotOfAs.count())

    var i = 10
    for (i in i downTo 0){
        println(i)
    }

    for (counter in 0..10){
        println(counter.toDouble() * 0.1)
    }
}