import kotlin.math.sqrt

fun main() {
    /*fun sort(test: Array<Int>): Array<Int> {
        val listLength = test.count()
        var swap = true
        while (swap) {
            swap = false
            for (i in 0 until listLength - 1) {
                if (test[i] > test[i + 1]) {
                    val temp = test[i]
                    test[i] = test[i + 1]
                    test[i + 1] = temp

                    swap = true
                }
            }
        }
        return test
    }

    val test1 = arrayOf(5, 7, 3, 6, 8)
    val test2 = arrayOf(5, 5, 5)
    val test3 = arrayOf<Int>()
    val test4 = arrayOf(5, 3, 0, -5)

    sort(test1)
    sort(test2)
    sort(test3)
    sort(test4)

    if (test1.isEmpty()) {
        print("Array is empty")
    } else {
        for (i in test1) {
            print("$i ")
        }
    }
    println("")

    if (test2.isEmpty()) {
        print("Array is empty")
    } else {
        for (i in test2) {
            print("$i ")
        }
    }
    println("")

    if (test3.isEmpty()) {
        print("Array is empty")
    } else {
        for (i in test3) {
            print("$i ")
        }
    }
    println("")

    if (test4.isEmpty()) {
        print("Array is empty")
    } else {
        for (i in test4) {
            print("$i ")
        }
    }
    println("")

    val recenica = "Ja sam Nikola"
    val duzina = recenica.count()
    val novaRecenica = ""
    val pocetna = 0
    fun reverse(duzina: Int, novaRecenica: String, pocetna: Int){
        var trenutna = pocetna
        val slovo = recenica[duzina-trenutna-1]
        var najnovijaRecenica = novaRecenica
        najnovijaRecenica += slovo
        if (trenutna < duzina-1){
            trenutna += 1
            reverse(duzina, najnovijaRecenica, trenutna)
        }else{
            print(najnovijaRecenica)
        }
    }
    reverse(duzina, novaRecenica, pocetna)
    println()
    println()
    println()


    fun tablicaMnozenja(duzina: Int){
        for (i in 0..duzina){
            for (j in 1..duzina){
                print("    " + i * j)
            }
            println()
        }
    }
    tablicaMnozenja(12)


    val secretNumber = 14
    val counter = 1
    fun guessTheNumber(number: Int, counter: Int){
        var newCounter = counter

        if (number < secretNumber){
            println("Greska. Broj $number je manji od trazenog broja.")
            newCounter += 1
            guessTheNumber(17, newCounter)
        }
        else if (number > secretNumber){
            println("Greska. Broj $number je veci od trazenog broja.")
            newCounter += 1
            guessTheNumber(14, newCounter)
        }
        else if ( number == secretNumber){
            println("Pogodili ste broj $secretNumber iz $counter pokusaja.")
        }
    }
    guessTheNumber(12, counter)


    //VEZBANJE WHEN

    fun areEqual(a: Int, b: Int){
        when (a) {
            b -> println("First number $a is equal to second $b.")
            else -> println("Number $a is not equal to $b")
        }
    }
    areEqual(5,3)


    fun numberEvenOrOdd(number: Int){
        when {
            number % 2 == 0 -> println("Number $number is even.")
            number % 2 == 1 -> println("Number $number is odd.")
            else -> println("Number is negative.")
        }
    }
    numberEvenOrOdd(43)


    fun leapYear(year: Int){
        when{
            year % 3 == 0 && year % 100 != 0 || year % 400 == 0 -> println("Year $year is leap year.")
            else -> println("Year $year is not leap year.")
        }
    }
    leapYear(2021)


    fun quadricEquation(a: Double, b: Double, c: Double){
        val d = (b * b) - 4 * a * c
        val x1 = (-b + sqrt(d)) / (2 * a)
        val x2 = (-b + sqrt(d)) / (2 * a)
        when {
            d < 0 -> println("Roots are imaginary, no solution.")
            d == 0.0 -> println("There is one root")
            d > 0 -> println("X1: $x1, X2: $x2")
        }
    }
    quadricEquation(3.0,6.0,2.0)


    fun temperatureCelsius(temperature: Int){
        when {
            temperature < 0 -> println("Freezing weather.")
            temperature in 0..9 -> println("Very cold weather.")
            temperature in 10..19 -> println("Cold weather.")
            temperature in 20..29 -> println("Normal temperature.")
            temperature in 30..39 -> println("It's hot.")
            temperature > 40 -> println("It's very hot.")
        }
    }
    temperatureCelsius(28)


    fun digitMonthToString(numberOfMonth: Int){
        when (numberOfMonth) {
            1 -> println("January")
            2 -> println("February")
            3 -> println("March")
            4 -> println("April")
            5 -> println("May")
            6 -> println("June")
            7 -> println("July")
            8 -> println("August")
            9 -> println("September")
            10 -> println("October")
            11 -> println("November")
            12 -> println("December")
            else -> println("Non existant month")
        }
    }
    digitMonthToString(8)*/

    //Vezbanje 27. avgust
    poredjajBrodoveIgrac()
}

var red1 = arrayListOf(0,0,0,0,0,0,0,0,0,0)
var red2 = arrayListOf(0,0,0,0,0,0,0,0,0,0)
var red3 = arrayListOf(0,0,0,0,0,0,0,0,0,0)
var red4 = arrayListOf(0,0,0,0,0,0,0,0,0,0)
var red5 = arrayListOf(0,0,0,0,0,0,0,0,0,0)
var red6 = arrayListOf(0,0,0,0,0,0,0,0,0,0)
var red7 = arrayListOf(0,0,0,0,0,0,0,0,0,0)
var red8 = arrayListOf(0,0,0,0,0,0,0,0,0,0)
var red9 = arrayListOf(0,0,0,0,0,0,0,0,0,0)
var red10 = arrayListOf(0,0,0,0,0,0,0,0,0,0)

fun mojaTabla(){
    println(red1)
    println(red2)
    println(red3)
    println(red4)
    println(red5)
    println(red6)
    println(red7)
    println(red8)
    println(red9)
    println(red10)
}

fun poredjajBrodoveIgrac(){
    //val prviRed = (1..10).random()
    val prviRed = 1
    var drugiRed: Int
    var treciRed: Int
    var cetvrtiRed: Int
    var petiRed: Int
    var drugoPolje: Int
    var trecePolje: Int
    var cetvrtoPolje: Int
    var petoPolje: Int
    val prvoPolje = (0 until 10).random()
    drugoPolje = arrayOf(prvoPolje - 1, prvoPolje + 1).random()
    if (prviRed == 1){
        red1[prvoPolje] = 1

        val horVer = arrayOf("hor","ver").random()
        if (horVer == "hor") {                          //horizontalno
            if (prvoPolje != 0 && prvoPolje != 10) {
                red1[drugoPolje] = 1
            }else if (prvoPolje == 0){
                drugoPolje = prvoPolje+1
                red1[drugoPolje] = 1
            }else if (prvoPolje == 9){
                drugoPolje = prvoPolje-1
                red1[drugoPolje] = drugoPolje
            }
            if (drugoPolje!=0 && drugoPolje!=10){
                if (red1[prvoPolje] > red1[drugoPolje]){
                    trecePolje = drugoPolje-1
                    red1[trecePolje] = 1
                }else{
                    trecePolje = drugoPolje+1
                    red1[trecePolje] = 1
                }

            }
        }else{                                          //vertikalno redjanje
            red2[prvoPolje] = 1
        }
    }                                                   //kraj prvog reda
    mojaTabla()
}