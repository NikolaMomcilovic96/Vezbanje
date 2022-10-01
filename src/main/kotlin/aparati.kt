fun main() {
    println("Unesite vas ulog")
    val unesenUlog = readLine()!!.toInt()
    ukupno = unesenUlog
    while (ukupno > 19) {
        println("Izaberite cip 4, 6 ili 8")
        val cip = readLine()!!.toInt()
        if (cip == 4) {
            promeniBrojeve()
            proveriCip4()
            ispisiNizove()
        } else if (cip == 6) {
            promeniBrojeve()
            proveriCip6()
            ispisiNizove()
        } else if (cip == 8) {
            promeniBrojeve()
            proveriCip8()
            ispisiNizove()
        } else {
            println("Pogresan unos.")
        }
    }
    println("Izgubili ste. Ostalo vam je $ukupno dinara")
}

var ukupno = 0

val nizovi = arrayListOf(
    (arrayListOf(0, 0, 0, 0, 0)),
    (arrayListOf(0, 0, 0, 0, 0)),
    (arrayListOf(0, 0, 0, 0, 0))
)

val brojevi = arrayListOf(1, 2, 3, 4, 5)

fun promeniBrojeve() {
    for (i in 0..2) {
        for (j in 0..4) {
            nizovi[i][j] = brojevi.random()
        }
    }
}

fun proveriVertikalu(): Int {
    var dobitak = 0
    val i = 0
    for (j in 0..4) {
        if (nizovi[i][j] == nizovi[i + 1][j] && nizovi[i][j] == nizovi[i + 2][j]) {
            dobitak += 1
            println("Vertikalno 3")
        }
    }
    return dobitak
}

fun proveriHorizontalu(): Int {
    var dobitak = 0
    val j = 0
    for (i in 0..2) {
        when {
            nizovi[i][j] == nizovi[i][j + 1] &&
                    nizovi[i][j] == nizovi[i][j + 2] &&
                    nizovi[i][j] == nizovi[i][j + 3] &&
                    nizovi[i][j] == nizovi[i][j + 4] -> {
                dobitak += 3
                println("Horizontalno 5")
            }

            nizovi[i][j] == nizovi[i][j + 1] &&
                    nizovi[i][j] == nizovi[i][j + 2] &&
                    nizovi[i][j] == nizovi[i][j + 3] -> {
                dobitak += 2
                println("Horizontalno 4")
            }

            nizovi[i][j + 1] == nizovi[i][j + 2] &&
                    nizovi[i][j + 1] == nizovi[i][j + 3] &&
                    nizovi[i][j + 1] == nizovi[i][j + 4] -> {
                dobitak += 2
                println("Horizontalno 4")
            }

            nizovi[i][j] == nizovi[i][j + 1] &&
                    nizovi[i][j] == nizovi[i][j + 2] -> {

                dobitak += 1
                println("Horizontalno 3")
            }

            nizovi[i][j + 1] == nizovi[i][j + 2] &&
                    nizovi[i][j + 1] == nizovi[i][j + 3] -> {
                dobitak += 1
                println("Horizontalno 3")
            }

            nizovi[i][j + 2] == nizovi[i][j + 3] &&
                    nizovi[i][j + 2] == nizovi[i][j + 4] -> {
                dobitak += 1
                println("Horizontalno 3")
            }
        }
    }
    return dobitak
}


fun proveriDijagonalu(): Int {
    var dobitak = 0
    when {
        nizovi[0][0] == nizovi[1][1] && nizovi[0][0] == nizovi[2][2] -> {
            dobitak += 1
            println("Dijagonala [0][0]")
        }

        nizovi[0][1] == nizovi[1][2] && nizovi[0][1] == nizovi[2][3] -> {
            dobitak += 1
            println("Dijagonala [0][1]")
        }

        nizovi[0][2] == nizovi[1][3] && nizovi[0][2] == nizovi[2][4] -> {
            dobitak += 1
            println("Dijagonala [0][2]")
        }

        nizovi[2][0] == nizovi[1][1] && nizovi[2][0] == nizovi[0][2] -> {
            dobitak += 1
            println("Dijagonala [2][0]")
        }

        nizovi[2][1] == nizovi[1][2] && nizovi[2][1] == nizovi[0][3] -> {
            dobitak += 1
            println("Dijagonala [2][0]")
        }
    }
    return dobitak
}

fun proveriKrivudavo(): Int {
    var dobitak = 0

    when {
        nizovi[0][0] == nizovi[1][1] && nizovi[0][0] == nizovi[1][2] && nizovi[0][0] == nizovi[2][3] -> {
            dobitak += 1
            println("Unakrsno [0][0]")
        }

        nizovi[0][1] == nizovi[1][2] && nizovi[0][1] == nizovi[1][3] && nizovi[0][1] == nizovi[2][4] -> {
            dobitak += 1
            println("Unakrsno [0][1]")
        }

        nizovi[2][0] == nizovi[1][1] && nizovi[2][0] == nizovi[1][2] && nizovi[2][0] == nizovi[0][3] -> {
            dobitak += 1
            println("Unakrsno [2][0]")
        }

        nizovi[2][1] == nizovi[1][2] && nizovi[2][1] == nizovi[1][3] && nizovi[2][1] == nizovi[0][4] -> {
            dobitak += 1
            println("Unakrsno [2][1]")
        }
    }

    return dobitak
}

fun proveriCip4() {
    val ulog = 20
    ukupno -= ulog
    val dobitak = proveriVertikalu() + proveriHorizontalu()
    ukupno += dobitak * ulog
    if (ulog * dobitak - ulog < 0) {
        println("Izgubili ste $ulog dinara")
    } else if (ulog * dobitak - ulog == 0) {
        println("Ostaje isto")
    } else {
        println("Zaradili ste ${ulog * dobitak - ulog} dinara")
    }
    println("Ukupno: $ukupno dinara")
    println(dobitak)
}

fun proveriCip6() {
    val ulog = 35
    ukupno -= ulog
    val dobitak = proveriVertikalu() + proveriHorizontalu() + proveriDijagonalu()
    ukupno += dobitak * ulog
    if (ulog * dobitak - ulog < 0) {
        println("Izgubili ste $ulog dinara")
    } else if (ulog * dobitak - ulog == 0) {
        println("Ostaje isto")
    } else {
        println("Zaradili ste ${ulog * dobitak - ulog} dinara")
    }
    println("Ukupno: $ukupno dinara")
    println(dobitak)
}

fun proveriCip8() {
    val ulog = 50
    ukupno -= ulog
    val dobitak = proveriVertikalu() + proveriHorizontalu() + proveriDijagonalu() + proveriKrivudavo()
    ukupno += dobitak * ulog
    if (ulog * dobitak - ulog < 0) {
        println("Izgubili ste $ulog dinara")
    } else if (ulog * dobitak - ulog == 0) {
        println("Ostaje isto")
    } else {
        println("Zaradili ste ${ulog * dobitak - ulog} dinara")
    }
    println("Ukupno: $ukupno dinara")
    println(dobitak)
}

fun ispisiNizove() {
    for (i in 0..2) {
        println(nizovi[i])
    }
}