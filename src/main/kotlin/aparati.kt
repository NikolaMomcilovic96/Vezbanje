fun main() {
    var ukupno = 500

    val nizovi = arrayListOf(
        (arrayListOf(0, 0, 0, 0, 0)),
        (arrayListOf(0, 0, 0, 0, 0)),
        (arrayListOf(0, 0, 0, 0, 0))
    )

    /*val cipovi = arrayListOf(4, 6, 8)
    val cip = 4*/

    val brojevi = arrayListOf(1, 2, 3)

    //upisali brojeve
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
            if (nizovi[i][j] == nizovi[i][j + 1] &&
                nizovi[i][j] == nizovi[i][j + 2] &&
                nizovi[i][j] == nizovi[i][j + 3] &&
                nizovi[i][j] == nizovi[i][j + 4]
            ) {
                dobitak += 3
                println("Horizontalno 5")
            } else if (nizovi[i][j] == nizovi[i][j + 1] &&
                nizovi[i][j] == nizovi[i][j + 2] &&
                nizovi[i][j] == nizovi[i][j + 3]
            ) {
                dobitak += 2
                println("Horizontalno 4")
            } else if (nizovi[i][j + 1] == nizovi[i][j + 2] &&
                nizovi[i][j + 1] == nizovi[i][j + 3] &&
                nizovi[i][j + 1] == nizovi[i][j + 4]
            ) {
                dobitak += 2
                println("Horizontalno 4")
            } else if (nizovi[i][j] == nizovi[i][j + 1] &&
                nizovi[i][j] == nizovi[i][j + 2]
            ) {
                dobitak += 1
                println("Horizontalno 3")
            } else if (nizovi[i][j + 1] == nizovi[i][j + 2] &&
                nizovi[i][j + 1] == nizovi[i][j + 3]
            ) {
                dobitak += 1
                println("Horizontalno 3")
            } else if (nizovi[i][j + 2] == nizovi[i][j + 3] &&
                nizovi[i][j + 2] == nizovi[i][j + 4]
            ) {
                dobitak += 1
                println("Horizontalno 3")
            }
        }
        return dobitak
    }

    fun proveri4() {
        val ulog = 20
        ukupno -= ulog
        val dobitak = proveriVertikalu() + proveriHorizontalu()
        ukupno += dobitak * ulog
        if (ulog * dobitak - ulog <= 0) {
            println("Izgubili ste $ulog dinara")
        } else {
            println("Zaradili ste ${ulog * dobitak - ulog} dinara")
        }
        println("Ukupno: $ukupno dinara")
        println(dobitak)
    }

    //ispisujemo nizove
    fun ispisiNizove() {
        for (i in 0..2) {
            println(nizovi[i])
        }
    }

    for (i in 0..5) {
        promeniBrojeve()
        proveri4()
        ispisiNizove()
    }


}