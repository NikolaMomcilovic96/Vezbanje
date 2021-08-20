fun main() {
    val pickDoor = (1..3).random()
    if (pickDoor == 1) {
        door1 = true
    }
    if (pickDoor == 2) {
        door2 = true
    }
    if (pickDoor == 3) {
        door3 = true
    }
    println("Vrata 1 $door1")
    println("Vrata 2 $door2")
    println("Vrata 3 $door3")

    println("!!!Dobrodošli u Monty Hall kviz!!!")
    println("------------------------------------")

    findOtherFalse()
}

var door1 = false
var door2 = false
var door3 = false
const val odabraliPrva = "Izabrali ste prva vrata."
const val odabraliDruga = "Izabrali ste druga vrata."
const val odabraliTreca = "Izabrali ste treca vrata."
const val otvorilaPrva = "Otvorila su se prva vrata."
const val otvorilaDruga = "Otvorila su se druga vrata."
const val otvorilaTreca = "Otvorila su se treca vrata."
const val odaberiPreostala = "Odaberite jedna od dvoje preostalih vrata."
const val prva = "PRVIH"
const val druga = "DRUGIH"
const val treca = "TRECIH"
const val uspeh = " vrata se nalazi auto. Čestitamo!"
const val neuspeh = " vrata nema nista. Izgubili ste!"


fun findOtherFalse(){
    val guess = randomOneTwoThree()

    if (door1 && guess == 2){
        println(odabraliDruga)
        println(otvorilaTreca)
        println(odaberiPreostala)
        openFinalDoor(randomOneTwo())
    }
    else if (door1 && guess == 3){
        println(odabraliTreca)
        println(otvorilaDruga)
        println(odaberiPreostala)
        openFinalDoor(randomOneThree())
    }
    else if (door2 && guess == 1){
        println(odabraliPrva)
        println(otvorilaTreca)
        println(odaberiPreostala)
        openFinalDoor(randomOneTwo())
    }
    else if (door2 && guess == 3){
        println(odabraliTreca)
        println(otvorilaPrva)
        println(odaberiPreostala)
        openFinalDoor(randomTwoThree())
    }
    else if (door3 && guess == 1){
        println(odabraliPrva)
        println(otvorilaDruga)
        println(odaberiPreostala)
        openFinalDoor(randomOneThree())
    }
    else if (door3 && guess == 2){
        println(odabraliDruga)
        println(otvorilaPrva)
        println(odaberiPreostala)
        openFinalDoor(randomTwoThree())
    }
    else{
        findOtherFalse()
    }
}

fun openFinalDoor(newPick: Int){
    if (newPick == 1){
        if (door1){
            println("Iza $prva$uspeh")
        }else{
            println("Iza $prva$neuspeh")
        }
    }else if (newPick == 2){
        if (door2){
            println("Iza $druga$uspeh")
        }else{
            println("Iza $druga$neuspeh")
        }
    }else if (newPick == 3){
        if (door3){
            println("Iza $treca$uspeh")
        }else{
            println("Iza $treca$neuspeh")
        }
    }
}

fun randomOneTwo(): Int {
    return (1..2).random()
}

fun randomOneThree(): Int {
    return arrayOf(1, 3).random()
}

fun randomTwoThree(): Int {
    return (2..3).random()
}

fun randomOneTwoThree(): Int {
    return (1..3).random()
}