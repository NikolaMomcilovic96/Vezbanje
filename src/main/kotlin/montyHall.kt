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
    //chooseTheDoor(firstGuess)
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


/*

PRVA VERZIJA

fun chooseTheDoor(guess: Int) {
    if (guess == 1) {
        println("Izabrali ste PRVA vrata.")
        openTheDoor(guess)
    } else if (guess == 2) {
        println("Izabrali ste druga vrata.")
        openTheDoor(guess)
    } else if (guess == 3) {
        println("Izabrali ste treća vrata.")
        openTheDoor(guess)
    }
}

fun openFinalDoor(guess: Int) {
    if (guess == 1) {
        if (door1) {
            println("Iza $prva$uspeh")
        } else {
            println("Iza $prva$neuspeh")
        }
    }
    if (guess == 2) {
        if (door2) {
            println("Iza $druga$uspeh")
        } else {
            println("Iza $druga$neuspeh")
        }
    }
    if (guess == 3) {
        if (door3) {
            println("Iza $treca$uspeh")
        } else {
            println("Iza $treca$neuspeh")
        }
    }
}

fun isOpened(number: Int, openedDoor: Int) {
    if (number != openedDoor) {
        openFinalDoor(number)
    } else {
        val newNumber = randomOneTwoThree()
        isOpened(newNumber, openedDoor)
    }
}

fun openTheDoor(guess: Int) {
    if (guess == 1) {
        if (door1) {
            val randomDoor = randomTwoThree()

            if (randomDoor == 2) {
                println(otvorilaDruga)
                println("Da li želite da ostanete na PRVIM vratima ili da promenite na TREĆA?")
                val newRandomDoor = randomOneTwoThree()
                isOpened(newRandomDoor, 2)
            } else {
                println(otvorilaTreca)
                println("Da li želite da ostanete na PRVIM vratima ili da promenite na DRUGA?")
                val newRandomDoor = randomOneTwoThree()
                isOpened(newRandomDoor, 3)
            }
        } else if (!door1) {
            if (door2) {
                println(otvorilaTreca)
                println("Da li želite da ostanete na PRVIM vratima ili da promenite na DRUGA?")
                val newRandomDoor = randomOneTwo()
                isOpened(newRandomDoor, 3)
            } else {
                println(otvorilaDruga)
                println("Da li želite da ostanete na PRVIM vratima ili da promenite na TREĆA?")
                val newRandomDoor = randomOneThree()
                isOpened(newRandomDoor, 2)
            }
        }
    } else if (guess == 2) {
        if (door2) {
            val randomDoor = randomOneTwo()
            if (randomDoor == 1) {
                println(otvorilaPrva)
                println("Da li želite da ostanete na DRUGIM vratima ili da promenite na TREĆA?")
                val newRandomDoor = randomOneThree()
                isOpened(newRandomDoor, 1)
            } else {
                println(otvorilaTreca)
                println("Da li želite da ostanete na DRUGIM vratima ili da promenite na PRVA?")
                val newRandomDoor = randomOneThree()
                isOpened(newRandomDoor, 3)
            }
        } else if (!door2) {
            if (door1) {
                println(otvorilaTreca)
                println("Da li želite da ostanete na DRUGIM vratima ili da promenite na PRVA?")
                val newRandomDoor = randomOneThree()
                isOpened(newRandomDoor, 3)
            } else {
                println(otvorilaPrva)
                println("Da li želite da ostanete na DRUGIM vratima ili da promenite na TREĆA?")
                val newRandomDoor = randomOneThree()
                isOpened(newRandomDoor, 1)
            }
        }
    } else {
        if (door3) {
            val randomDoor = randomOneTwo()
            if (randomDoor == 1) {
                println(otvorilaPrva)
                println("Da li želite da ostanete na TREĆIM vratima ili da promenite na DRUGA?")
                val newRandomDoor = randomOneThree()
                isOpened(newRandomDoor, 1)
            } else {
                println(otvorilaDruga)
                println("Da li želite da ostanete na TREĆIM vratima ili da promenite na PRVA?")
                val newRandomDoor = randomOneThree()
                isOpened(newRandomDoor, 2)
            }
        } else if (!door3) {
            if (door1) {
                println(otvorilaDruga)
                println("Da li želite da ostanete na TREĆIM vratima ili da promenite na PRVA?")
                val newRandomDoor = randomOneThree()
                isOpened(newRandomDoor, 2)
            } else {
                println(otvorilaPrva)
                println("Da li želite da ostanete na TREĆIM vratima ili da promenite na DRUGA?")
                val newRandomDoor = randomOneThree()
                isOpened(newRandomDoor, 1)
            }
        }
    }
}
*/


