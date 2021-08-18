import java.util.Random

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
    val firstGuess = (1..3).random()

    chooseTheDoor(firstGuess)
}

var door1 = false
var door2 = false
var door3 = false
val prva = "PRVIH"
val druga = "DRUGIH"
val treca = "TRECIH"
val uspeh = " vrata se nalazi auto. Čestitamo!"
val neuspeh = " vrata nema nista. Izgubili ste!"

fun chooseTheDoor(guess: Int) {
    if (guess == 1) {
        println("Izabrali ste PRVA vrata.")
        openTheDoor(guess, door1, door2, door3)

    } else if (guess == 2) {
        println("Izabrali ste druga vrata.")
        openTheDoor(guess, door1, door2, door3)

    } else if (guess == 3) {
        println("Izabrali ste treća vrata.")
        openTheDoor(guess, door1, door2, door3)

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
        val newNumber = (1..3).random()
        isOpened(newNumber, openedDoor)
    }
}

fun openTheDoor(guess: Int, door1: Boolean, door2: Boolean, door3: Boolean) {
    if (guess == 1) {
        if (door1) {
            val randomDoor = (2..3).random()

            if (randomDoor == 2) {
                println("Otvorila su se DRUGA vrata")
                println("Da li želite da ostanete na PRVIM vratima ili da promenite na TREĆA?")
                val newRandomDoor = (1..3).random()
                isOpened(newRandomDoor, 2)
            } else {
                println("Otvorila su se TREĆA vrata")
                println("Da li želite da ostanete na PRVIM vratima ili da promenite na DRUGA?")
                val newRandomDoor = (1..3).random()
                isOpened(newRandomDoor, 3)
            }
        } else if (!door1) {
            if (door2) {
                println("Otvorila su se TREĆA vrata")
                println("Da li želite da ostanete na PRVIM vratima ili da promenite na DRUGA?")
                val newRandomDoor = (1..3).random()
                isOpened(newRandomDoor, 3)
            } else {
                println("Otvorila su se DRUGA vrata")
                println("Da li želite da ostanete na PRVIM vratima ili da promenite na TREĆA?")
                val newRandomDoor = (1..3).random()
                isOpened(newRandomDoor, 2)
            }
        }
    } else if (guess == 2) {
        if (door2) {
            val randomDoor = (1..2).random()
            if (randomDoor == 1) {
                println("Otvorila su se PRVA vrata")
                println("Da li želite da ostanete na DRUGIM vratima ili da promenite na TREĆA?")
                val newRandomDoor = (1..3).random()
                isOpened(newRandomDoor, 1)
            } else {
                println("Otvorila su se TREĆA vrata")
                println("Da li želite da ostanete na DRUGIM vratima ili da promenite na PRVA?")
                val newRandomDoor = (1..3).random()
                isOpened(newRandomDoor, 3)
            }
        } else if (!door2) {
            if (door1) {
                println("Otvorila su se TREĆA vrata")
                println("Da li želite da ostanete na DRUGIM vratima ili da promenite na PRVA?")
                val newRandomDoor = (1..3).random()
                isOpened(newRandomDoor, 3)
            } else {
                println("Otvorila su se PRVA vrata")
                println("Da li želite da ostanete na DRUGIM vratima ili da promenite na TREĆA?")
                val newRandomDoor = (1..3).random()
                isOpened(newRandomDoor, 1)
            }
        }
    } else {
        if (door3) {
            val randomDoor = (1..2).random()
            if (randomDoor == 1) {
                println("Otvorila su se PRVA vrata")
                println("Da li želite da ostanete na TREĆIM vratima ili da promenite na DRUGA?")
                val newRandomDoor = (1..3).random()
                isOpened(newRandomDoor, 1)
            } else {
                println("Otvorila su se DRUGA vrata")
                println("Da li želite da ostanete na TREĆIM vratima ili da promenite na PRVA?")
                val newRandomDoor = (1..3).random()
                isOpened(newRandomDoor, 2)
            }
        } else if (!door3) {
            if (door1) {
                println("Otvorila su se DRUGA vrata")
                println("Da li želite da ostanete na TREĆIM vratima ili da promenite na PRVA?")
                val newRandomDoor = (1..3).random()
                isOpened(newRandomDoor, 2)
            } else {
                println("Otvorila su se PRVA vrata")
                println("Da li želite da ostanete na TREĆIM vratima ili da promenite na DRUGA?")
                val newRandomDoor = (1..3).random()
                isOpened(newRandomDoor, 1)
            }
        }
    }
}