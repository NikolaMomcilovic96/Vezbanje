import java.util.*
import kotlin.math.sqrt

fun main() {
    val myAge = 24
    val isTeenager = myAge>=13 && myAge<=19
    println(isTeenager)

    val theirAge = 30
    val bothTeenagers = (myAge>=13 && myAge<=19)/* ili isTeenager*/ && (theirAge>=13 && theirAge<=19)
    println(bothTeenagers)

    val reader = "Nikola"
    val author = "Richard Lucas"
    val authorIsReader = author == reader
    println(authorIsReader)

    val readerBeforeAuthor = reader < author
    println(readerBeforeAuthor)


    val hoursWorked = 45
    var price = 0
    if(hoursWorked>40){
        val hoursOver = hoursWorked - 40
        price += 50 * hoursOver
        price += 40 * 25
    }
    println(price)


    val mojeGodine = 24
    if(mojeGodine in 14..18){
        println("Teenager")
    }else{
        println("Not teenager")
    }
    val answer = if(mojeGodine in 14..18) "Teenager" else "Not teenager"
    println(answer)


    var counter = 0
    var roll = 0
    do{
        roll = Random().nextInt(6)
        counter += 1
        println("After $counter roll(s), roll is $roll")
    }while (roll != 0)



    val a = 1.0
    val b = -5.0
    val c = 6.0
    val d = b * b - (4 * a * c)

    if(d > 0){
        val x1 = (-b + sqrt(d)) / (2 * a)
        val x2 = (-b - sqrt(d)) / (2 * a)
        println("Results are $x1 and $x2")
    }else if(d.equals(0.0)){
        val x = -b / (2 * a)
        println("Both solutions are $x")
    }else{
        println("This equation has no solutions")
    }


    val targetedValue = 7
    var combinationFound = 0
    var valueOnFirstDice = 1
    while(valueOnFirstDice <= 6){
        var valueOnSecondDice = 1
        while (valueOnSecondDice <= 6){
            if(valueOnFirstDice + valueOnSecondDice == targetedValue){
                combinationFound += 1
            }
            valueOnSecondDice += 1
        }
        valueOnFirstDice += 1
    }
    val percentage = (combinationFound.toDouble() / 36 * 100).toInt()
    println("The odds of rolling $targetedValue are $combinationFound in 36 or $percentage%")

}