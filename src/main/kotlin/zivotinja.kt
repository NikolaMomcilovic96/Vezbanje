fun main() {
    fun sort(test: Array<Int>): Array<Int> {
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
}



















