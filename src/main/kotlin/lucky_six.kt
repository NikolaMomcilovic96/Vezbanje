fun main() {
    val svi = arrayListOf<Int>()
    val izabrani = arrayListOf<Int>()

    for (i in 1..48) {
        svi.add(i)
    }

    for (i in 1..30){
        val broj = svi.random()
        izabrani.add(broj)
        svi.remove(broj)
    }

    izabrani.sortDescending()
    println("IZABRANI BROJEVI SU: $izabrani")
    svi.sortDescending()
    println("PREOSTALI BROJEVI SU: $svi")
}

