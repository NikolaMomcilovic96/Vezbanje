import kotlin.math.PI
import kotlin.math.sqrt

fun main(){
    val exercises = 9
    var exercisesSolved = 0
    exercisesSolved += 1

    //exercise 2
    var age = 16
    print(age)
    age = 30
    println(age)
    exercisesSolved += 1

    //exercise 3
    val a = 46
    val b = 10
    val answer1: Int = (a * 100) + b
    val answer2: Int = (a * 100) + (b * 100)
    val answer3: Int = (a * 100) + (b / 10)
    println(answer1)
    println(answer2)
    println(answer3)
    exercisesSolved += 1

    //exercise 4
    val result = (5 * 3) - ((4 / 2) * 2)
    println(result)
    exercisesSolved += 1

    //exercise 5
    val average: Double
    val a1 = 47.0
    val b1 = 87.0
    average = (a1 + b1) / 2
    println(average)
    exercisesSolved += 1

    //exercise 6
    val fahrenheit = 69.0
    val celsius: Double = (fahrenheit - 32) / 1.8
    println(celsius)
    exercisesSolved += 1

    //exercise 7
    val position = 33
    val row = position / 8
    val col = position % 8
    println("Row: $row, column: $col")
    exercisesSolved += 1

    //exercise 8
    val degrees = 360.0
    val radians = (degrees / 180) * PI
    println(radians)
    exercisesSolved += 1

    //exercise 9
    val x1 = 11.0
    val y1 = 25.0
    val x2 = 31.0
    val y2 = 5.0
    val dx = x2 - x1
    val dy = y2 - y1
    val distance = sqrt(dx * dx + dy * dy)
    println(distance)
    exercisesSolved += 1

    print(exercisesSolved)
}