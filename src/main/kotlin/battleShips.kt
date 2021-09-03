fun main() {
    val igrac = Player()
    val komp = Player()

    igrac.dodajBrodove()
    komp.dodajBrodove()
    for (i in igrac.tabla.indices) {
        println("${igrac.tabla[i]}            ${komp.tabla[i]}")
    }

    igracGadja(igrac, komp)

    for (i in igrac.tabla.indices) {
        println("${igrac.tabla[i]}            ${komp.tabla[i]}")
    }
    println("Poeni igrac: ${igrac.poeni}                           Poeni komp: ${komp.poeni}")
    println("Pokusaji igrac: ${igrac.pokusaji}                        Pokusaji komp: ${komp.pokusaji}")
}

fun igracGadja(prvi: Player, drugi: Player) {
    val red = (0..9).random()
    val polje = (0..9).random()
    if (isChecked(red, polje, prvi)) {
        println("Gadja polje $red-$polje")
        shipOrSea(red, polje, prvi)
        if (isOver(prvi.poeni)) {
            println("Gotova igra.")
        } else {
            igracGadja(drugi, prvi)
        }
    } else {
        igracGadja(prvi, drugi)
    }
}

fun isChecked(red: Int, polje: Int, igrac: Player): Boolean {
    if (igrac.tabla[red][polje] == 0 || igrac.tabla[red][polje] == 1) {
        return true
    }
    return false
}

fun shipOrSea(red: Int, polje: Int, igrac: Player) {
    if (igrac.tabla[red][polje] == 0) {
        println("Promasaj.")
        igrac.tabla[red][polje] = 3
        igrac.pokusaji += 1
    } else {
        println("Brod je pogodjen!")
        igrac.tabla[red][polje] = 2
        igrac.poeni += 1
        igrac.pokusaji += 1
    }
}

fun isOver(poeni: Int): Boolean {
    if (poeni == 19) {
        return true
    }
    return false
}

fun uporedjuj(prvi: Int, drugi: Int, najveci: Int): Int {
    val result: Int
    if (prvi > drugi) {
        if (najveci == 9) {
            result = drugi - 1
        } else if (drugi == 0) {
            result = najveci + 1
        } else {
            result = arrayOf(najveci + 1, drugi - 1).random()
        }
    } else {
        if (najveci == 9) {
            result = prvi - 1
        } else if (prvi == 0) {
            result = najveci + 1
        } else {
            result = arrayOf(najveci + 1, prvi - 1).random()
        }
    }
    return result
}

class Player(
    var prvoPolje: Int = 0,
    var drugoPolje: Int = 0,
    var trecePolje: Int = 0,
    var cetvrtoPolje: Int = 0,
    var petoPolje: Int = 0,
    var prviRed: Int = 0,
    var drugiRed: Int = 0,
    var treciRed: Int = 0,
    var cetvrtiRed: Int = 0,
    var petiRed: Int = 0,
    var tabla: ArrayList<ArrayList<Int>> = arrayListOf(
        (arrayListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)),
        (arrayListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)),
        (arrayListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)),
        (arrayListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)),
        (arrayListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)),
        (arrayListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)),
        (arrayListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)),
        (arrayListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)),
        (arrayListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)),
        (arrayListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0))
    ),
    var poeni: Int = 0,
    var pokusaji: Int = 0
) {
    fun dodajBrodove() {
        dodajPrvoPolje(5)
        dodajPrvoPolje(4)
        dodajPrvoPolje(4)
        dodajPrvoPolje(3)
        dodajPrvoPolje(3)
    }

    fun isEmpty(red: Int, kolona: Int): Boolean {
        if (tabla[red][kolona] == 0) {
            return true
        }
        return false
    }

    fun dodajPrvoPolje(velicina: Int) {
        prviRed = (0..9).random()
        prvoPolje = (0..9).random()
        if (isEmpty(prviRed, prvoPolje)) {
            tabla[prviRed][prvoPolje] = 1
            dodajDrugoPolje(velicina)
        } else {
            dodajPrvoPolje(velicina)
        }
    }

    fun dodajDrugoPolje(velicina: Int) {
        val horVer = arrayOf("hor", "ver").random()
        if (horVer == "hor") {                                          //HORIZONTALNO
            when (prvoPolje) {
                0 -> drugoPolje = prvoPolje + 1
                9 -> drugoPolje = prvoPolje - 1
                else -> drugoPolje = arrayOf(prvoPolje - 1, prvoPolje + 1).random()
            }
            if (isEmpty(prviRed, drugoPolje)) {
                tabla[prviRed][drugoPolje] = 1
                dodajTrecePolje(velicina, horVer)
            } else {
                tabla[prviRed][prvoPolje] = 0
                dodajPrvoPolje(velicina)
            }
        } else {                                                        //VERTIKALNO
            when (prviRed) {
                0 -> drugiRed = prviRed + 1
                9 -> drugiRed = prviRed - 1
                else -> drugiRed = arrayOf(prviRed - 1, prviRed + 1).random()
            }
            if (isEmpty(drugiRed, prvoPolje)) {
                tabla[drugiRed][prvoPolje] = 1
                dodajTrecePolje(velicina, horVer)
            } else {
                tabla[prviRed][prvoPolje] = 0
                dodajPrvoPolje(velicina)
            }
        }
    }

    fun dodajTrecePolje(velicina: Int, horVer: String) {
        if (horVer == "hor") {                              //HORIZONTALNO
            when {
                prvoPolje > drugoPolje -> {
                    if (prvoPolje == 9) {
                        trecePolje = drugoPolje - 1
                    } else if (drugoPolje == 0) {
                        trecePolje = prvoPolje + 1
                    } else {
                        trecePolje = arrayOf(drugoPolje - 1, prvoPolje + 1).random()
                    }
                }
                drugoPolje > prvoPolje -> {
                    if (prvoPolje == 0) {
                        trecePolje = drugoPolje + 1
                    } else if (drugoPolje == 9) {
                        trecePolje = prvoPolje - 1
                    } else {
                        trecePolje = arrayOf(prvoPolje - 1, drugoPolje + 1).random()
                    }
                }
            }
            if (isEmpty(prviRed, trecePolje)) {
                tabla[prviRed][trecePolje] = 1
                if (velicina > 3) {
                    dodajCetvrtoPolje(velicina, horVer)
                }
            } else {
                tabla[prviRed][prvoPolje] = 0
                tabla[prviRed][drugoPolje] = 0
                dodajPrvoPolje(velicina)
            }
        } else {                                             //VERTIKALNO
            when {
                prviRed > drugiRed -> {
                    if (prviRed == 9) {
                        treciRed = drugiRed - 1
                    } else if (drugiRed == 0) {
                        treciRed = prviRed + 1
                    } else {
                        treciRed = arrayOf(prviRed + 1, drugiRed - 1).random()
                    }
                }
                drugiRed > prviRed -> {
                    if (prviRed == 0) {
                        treciRed = drugiRed + 1
                    } else if (drugiRed == 9) {
                        treciRed = prviRed - 1
                    } else {
                        treciRed = arrayOf(prviRed - 1, drugiRed + 1).random()
                    }
                }
            }
            if (isEmpty(treciRed, prvoPolje)) {
                tabla[treciRed][prvoPolje] = 1
                if (velicina > 3) {
                    dodajCetvrtoPolje(velicina, horVer)
                }
            } else {
                tabla[prviRed][prvoPolje] = 0
                tabla[drugiRed][prvoPolje] = 0
                dodajPrvoPolje(velicina)
            }
        }
    }

    fun dodajCetvrtoPolje(velicina: Int, horVer: String) {
        if (horVer == "hor") {                                                     //HORIZONTALNO
            when {
                prvoPolje > drugoPolje && prvoPolje > trecePolje -> {
                    cetvrtoPolje = uporedjuj(drugoPolje, trecePolje, prvoPolje)
                }
                drugoPolje > prvoPolje && drugoPolje > trecePolje -> {
                    cetvrtoPolje = uporedjuj(prvoPolje, trecePolje, drugoPolje)
                }
                trecePolje > prvoPolje && trecePolje > drugoPolje -> {
                    cetvrtoPolje = uporedjuj(prvoPolje, drugoPolje, trecePolje)
                }
            }
            if (isEmpty(prviRed, cetvrtoPolje)) {
                tabla[prviRed][cetvrtoPolje] = 1
                if (velicina > 4) {
                    dodajPetoPolje(horVer)
                }
            } else {
                tabla[prviRed][prvoPolje] = 0
                tabla[prviRed][drugoPolje] = 0
                tabla[prviRed][trecePolje] = 0
                dodajPrvoPolje(velicina)
            }
        } else {                                                                  //VERTIKALNO
            when {
                prviRed > drugiRed && prviRed > treciRed -> {
                    cetvrtiRed = uporedjuj(drugiRed, treciRed, prviRed)
                }
                drugiRed > prviRed && drugiRed > treciRed -> {
                    cetvrtiRed = uporedjuj(prviRed, treciRed, drugiRed)
                }
                treciRed > prviRed && treciRed > drugiRed -> {
                    cetvrtiRed = uporedjuj(prviRed, drugiRed, treciRed)
                }
            }
            if (isEmpty(cetvrtiRed, prvoPolje)) {
                tabla[cetvrtiRed][prvoPolje] = 1
                if (velicina > 4) {
                    dodajPetoPolje(horVer)
                }
            } else {
                tabla[prviRed][prvoPolje] = 0
                tabla[drugiRed][prvoPolje] = 0
                tabla[treciRed][prvoPolje] = 0
                dodajPrvoPolje(velicina)
            }
        }
    }

    fun dodajPetoPolje(horVer: String) {
        if (horVer == "hor") {                                                     //HORIZONTALNO
            when {
                prvoPolje > drugoPolje && prvoPolje > trecePolje && prvoPolje > cetvrtoPolje -> {
                    najmanjePolje(drugoPolje, trecePolje, cetvrtoPolje, prvoPolje)
                }
                drugoPolje > prvoPolje && drugoPolje > trecePolje && drugoPolje > cetvrtoPolje -> {
                    najmanjePolje(prvoPolje, trecePolje, cetvrtoPolje, drugoPolje)
                }
                trecePolje > prvoPolje && trecePolje > drugoPolje && trecePolje > cetvrtoPolje -> {
                    najmanjePolje(prvoPolje, drugoPolje, cetvrtoPolje, trecePolje)
                }
                cetvrtoPolje > prvoPolje && cetvrtoPolje > drugoPolje && cetvrtoPolje > trecePolje -> {
                    najmanjePolje(prvoPolje, drugoPolje, trecePolje, cetvrtoPolje)
                }
            }
            if (isEmpty(prviRed, petoPolje)) {
                tabla[prviRed][petoPolje] = 1
            } else {
                tabla[prviRed][prvoPolje] = 0
                tabla[prviRed][drugoPolje] = 0
                tabla[prviRed][trecePolje] = 0
                tabla[prviRed][cetvrtoPolje] = 0
                dodajPrvoPolje(5)
            }
        } else {                                                                             //VERTIKALNO
            when {
                prviRed > drugiRed && prviRed > treciRed && prviRed > cetvrtiRed -> {
                    najmanjiRed(drugiRed, treciRed, cetvrtiRed, prviRed)
                }
                drugiRed > prviRed && drugiRed > treciRed && drugiRed > cetvrtiRed -> {
                    najmanjiRed(prviRed, treciRed, cetvrtiRed, drugiRed)
                }
                treciRed > prviRed && treciRed > drugiRed && treciRed > cetvrtiRed -> {
                    najmanjiRed(prviRed, drugiRed, cetvrtiRed, treciRed)
                }
                cetvrtiRed > prviRed && cetvrtiRed > drugiRed && cetvrtiRed > treciRed -> {
                    najmanjiRed(prviRed, drugiRed, treciRed, cetvrtiRed)
                }
            }
            if (isEmpty(petiRed, prvoPolje)) {
                tabla[petiRed][prvoPolje] = 1
            } else {
                tabla[prviRed][prvoPolje] = 0
                tabla[drugiRed][prvoPolje] = 0
                tabla[treciRed][prvoPolje] = 0
                tabla[cetvrtiRed][prvoPolje] = 0
                dodajPrvoPolje(5)
            }
        }
    }

    fun najmanjePolje(prvo: Int, drugo: Int, trece: Int, cetvrto: Int) {
        if (prvo > drugo && prvo > trece) {
            petoPolje = uporedjuj(drugoPolje, trecePolje, cetvrtoPolje)
        } else if (drugo > prvo && drugo > trece) {
            petoPolje = uporedjuj(prvoPolje, trecePolje, cetvrtoPolje)
        } else {
            petoPolje = uporedjuj(prvoPolje, drugoPolje, cetvrtoPolje)
        }
    }

    fun najmanjiRed(prvo: Int, drugo: Int, trece: Int, cetvrto: Int) {
        if (prvo > drugo && prvo > trece) {
            petiRed = uporedjuj(drugiRed, treciRed, cetvrtiRed)
        } else if (drugo > prvo && drugo > trece) {
            petiRed = uporedjuj(prviRed, treciRed, cetvrtiRed)
        } else {
            petiRed = uporedjuj(prviRed, drugiRed, cetvrtiRed)
        }
    }
}