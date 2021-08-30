fun main() {
    dodajBrodove()
    mojaTabla()
    gadjanje()
}

var poeniIgrac = 0
var poeniKomp = 0
var pokusajiIgrac = 0
var pokusajiKomp = 0

var prviRed = 0
var prvoPolje = 0
var drugiRed = 0
var drugoPolje = 0
var treciRed = 0
var trecePolje = 0
var cetvrtiRed = 0
var cetvrtoPolje = 0
var petiRed = 0
var petoPolje = 0

var prviRedK = 0
var prvoPoljeK = 0
var drugiRedK = 0
var drugoPoljeK = 0
var treciRedK = 0
var trecePoljeK = 0
var cetvrtiRedK = 0
var cetvrtoPoljeK = 0
var petiRedK = 0
var petoPoljeK = 0

var tabla = arrayListOf(
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
)

var tablaKomp = arrayListOf(
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
)

fun dodajBrodove() {
    dodajPrvoPolje(5)
    dodajPrvoPolje(4)
    dodajPrvoPolje(4)
    dodajPrvoPolje(3)
    dodajPrvoPolje(3)
    dodajPrvoPoljeK(5)
    dodajPrvoPoljeK(4)
    dodajPrvoPoljeK(4)
    dodajPrvoPoljeK(3)
    dodajPrvoPoljeK(3)
}

fun mojaTabla() {
    println("Player:                                   Komp:")
    for (i in tabla.indices) {
        println("${tabla[i]}            ${tablaKomp[i]}")
    }
    println("Poeni igrac: $poeniIgrac                           Poeni komp: $poeniKomp")
    println("Pokusaji: $pokusajiIgrac                              Pokusaji komp: $pokusajiKomp")
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
        if (prvoPolje == 0) {
            drugoPolje = prvoPolje + 1
        } else if (prvoPolje == 9) {
            drugoPolje = prvoPolje - 1
        } else {
            drugoPolje = arrayOf(prvoPolje - 1, prvoPolje + 1).random()
        }
        if (isEmpty(prviRed, drugoPolje)) {
            tabla[prviRed][drugoPolje] = 1
            dodajTrecePolje(velicina, horVer)
        } else {
            tabla[prviRed][prvoPolje] = 0
            dodajPrvoPolje(velicina)
        }
    } else {                          //VERTIKALNO
        if (prviRed == 0) {
            drugiRed = prviRed + 1
        } else if (prviRed == 9) {
            drugiRed = prviRed - 1
        } else {
            drugiRed = arrayOf(prviRed - 1, prviRed + 1).random()
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
        if (prvoPolje == 0 || drugoPolje == 0) {
            if (prvoPolje == 0) {                       //drugoPolje==1
                trecePolje = drugoPolje + 1
            } else {
                trecePolje = prvoPolje + 1
            }
        } else if (prvoPolje == 9 || drugoPolje == 9) {
            if (prvoPolje == 9) {
                trecePolje = drugoPolje - 1
            } else {
                trecePolje = prvoPolje - 1
            }
        } else {
            if (prvoPolje > drugoPolje) {
                trecePolje = arrayOf(drugoPolje - 1, prvoPolje + 1).random()
            } else {
                trecePolje = arrayOf(prvoPolje - 1, drugoPolje + 1).random()
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
        if (prviRed == 0 || drugiRed == 0) {
            if (prviRed == 0) {
                treciRed = drugiRed + 1
            } else {
                treciRed = prviRed + 1
            }
        } else if (prviRed == 9 || drugiRed == 9) {
            if (prviRed == 9) {
                treciRed = drugiRed - 1
            } else {
                treciRed = prviRed + 1
            }
        } else {
            if (prviRed > drugiRed) {
                treciRed = arrayOf(drugiRed - 1, prviRed + 1).random()
            } else {
                treciRed = arrayOf(prviRed - 1, drugiRed + 1).random()
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
        if (prvoPolje == 0 || drugoPolje == 0 || trecePolje == 0) {
            if (prvoPolje == 0) {
                cetvrtoPolje = trecePolje + 1
            } else if (drugoPolje == 0) {
                cetvrtoPolje = trecePolje + 1
            } else {
                if (prvoPolje == 1) {
                    cetvrtoPolje = drugoPolje + 1
                } else {
                    cetvrtoPolje = prvoPolje + 1
                }
            }
        } else if (prvoPolje == 9 || drugoPolje == 9 || trecePolje == 9) {
            if (prvoPolje == 9) {
                cetvrtoPolje = trecePolje - 1
            } else if (drugoPolje == 9) {
                cetvrtoPolje = trecePolje - 1
            } else {
                if (prvoPolje == 8) {
                    cetvrtoPolje = drugoPolje - 1
                } else {
                    cetvrtoPolje = prvoPolje - 1
                }
            }
        } else {
            if (prvoPolje > drugoPolje && prvoPolje > trecePolje) {
                if (drugoPolje > trecePolje) {
                    cetvrtoPolje = arrayOf(prvoPolje + 1, trecePolje - 1).random()
                } else {
                    cetvrtoPolje = arrayOf(prvoPolje + 1, drugoPolje - 1).random()
                }
            } else if (drugoPolje > prvoPolje && drugoPolje > trecePolje) {
                if (prvoPolje > trecePolje) {
                    cetvrtoPolje = arrayOf(drugoPolje + 1, trecePolje - 1).random()
                } else {
                    cetvrtoPolje = arrayOf(drugoPolje + 1, prvoPolje - 1).random()
                }
            } else {
                if (prvoPolje > drugoPolje) {
                    cetvrtoPolje = arrayOf(trecePolje + 1, drugoPolje - 1).random()
                } else {
                    cetvrtoPolje = arrayOf(trecePolje + 1, prvoPolje - 1).random()
                }
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
        if (prviRed == 0 || drugiRed == 0 || treciRed == 0) {
            if (prviRed == 0) {
                cetvrtiRed = treciRed + 1
            } else if (drugiRed == 0) {
                cetvrtiRed = treciRed + 1
            } else {
                if (prviRed == 1) {
                    cetvrtiRed = drugiRed + 1
                } else {
                    cetvrtiRed = prviRed + 1
                }
            }
        } else if (prviRed == 9 || drugiRed == 9 || treciRed == 9) {
            if (prviRed == 9) {
                cetvrtiRed = treciRed - 1
            } else if (drugiRed == 9) {
                cetvrtiRed = treciRed - 1
            } else {
                if (prviRed == 1) {
                    cetvrtiRed = drugiRed - 1
                } else {
                    cetvrtiRed = prviRed - 1
                }
            }
        } else {
            if (prviRed > drugiRed && prviRed > treciRed) {
                if (drugiRed > treciRed) {
                    cetvrtiRed = arrayOf(prviRed + 1, treciRed - 1).random()
                } else {
                    cetvrtiRed = arrayOf(prviRed + 1, drugiRed - 1).random()
                }
            } else if (drugiRed > prviRed && drugiRed > treciRed) {
                if (prviRed > treciRed) {
                    cetvrtiRed = arrayOf(drugiRed + 1, treciRed - 1).random()
                } else {
                    cetvrtiRed = arrayOf(drugiRed + 1, prviRed - 1).random()
                }
            } else {
                if (prviRed > drugiRed) {
                    cetvrtiRed = arrayOf(treciRed + 1, drugiRed - 1).random()
                } else {
                    cetvrtiRed = arrayOf(treciRed + 1, prviRed - 1).random()
                }
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
        if (prvoPolje == 0 || drugoPolje == 0 || trecePolje == 0 || cetvrtoPolje == 0) {
            if (prvoPolje == 0) {
                petoPolje = cetvrtoPolje + 1
            } else if (drugoPolje == 0) {
                petoPolje = cetvrtoPolje + 1
            } else if (trecePolje == 0) {               //3
                if (prvoPolje == 1) {                        //1
                    if (drugoPolje == 2) {                         //2
                        petoPolje = cetvrtoPolje + 1                  //4
                    } else {                                      //4
                        petoPolje = drugoPolje + 1                      //2
                    }
                } else if (drugoPolje == 1) {                   //2
                    if (prvoPolje == 2) {                          //1
                        petoPolje = cetvrtoPolje + 1                    //4
                    } else {                                      //4
                        petoPolje = prvoPolje + 1
                    }
                } else {                                      //4
                    if (prvoPolje == 2) {
                        petoPolje = drugoPolje + 1
                    } else {
                        petoPolje = prvoPolje + 1
                    }
                }
            } else {                                    //4
                if (prvoPolje == 1) {                       //1
                    if (drugoPolje == 2) {                      //2
                        petoPolje = trecePolje + 1
                    } else {                                    //3
                        petoPolje = drugoPolje + 1
                    }
                } else if (drugoPolje == 2) {                   //2
                    if (prvoPolje == 2) {
                        petoPolje = trecePolje + 1
                    } else {                                    //3
                        petoPolje = prvoPolje + 1
                    }
                } else {                                    //3
                    if (drugoPolje == 2) {                      //2
                        petoPolje = prvoPolje + 1
                    } else {
                        petoPolje = drugoPolje + 1
                    }
                }
            }
        } else if (prvoPolje == 9 || drugoPolje == 9 || trecePolje == 9 || cetvrtoPolje == 9) {
            if (prvoPolje == 9) {
                petoPolje = cetvrtoPolje - 1
            } else if (drugoPolje == 9) {
                petoPolje = cetvrtoPolje - 1
            } else if (trecePolje == 9) {
                if (prvoPolje == 8) {
                    if (drugoPolje == 7) {
                        petoPolje = trecePolje - 1
                    } else {
                        petoPolje = drugoPolje - 1
                    }
                } else if (drugoPolje == 8) {
                    if (prvoPolje == 7) {
                        petoPolje = trecePolje - 1
                    } else {
                        petoPolje = prvoPolje - 1
                    }
                } else {
                    if (prvoPolje == 7) {
                        petoPolje = drugoPolje - 1
                    } else {
                        petoPolje = prvoPolje - 1
                    }
                }
            } else {
                if (prvoPolje == 8) {
                    if (drugoPolje == 7) {
                        petoPolje = trecePolje - 1
                    } else {
                        petoPolje = drugoPolje - 1
                    }
                } else if (drugoPolje == 8) {
                    if (prvoPolje == 7) {
                        petoPolje = trecePolje - 1
                    } else {
                        petoPolje = prvoPolje - 1
                    }
                } else {
                    if (prvoPolje == 7) {
                        petoPolje = drugoPolje - 1
                    } else {
                        petoPolje = prvoPolje - 1
                    }
                }
            }
        } else {
            if (prvoPolje > drugoPolje && prvoPolje > trecePolje && prvoPolje > cetvrtoPolje) {
                if (drugoPolje > trecePolje && drugoPolje > cetvrtoPolje) {
                    if (trecePolje > cetvrtoPolje) {
                        petoPolje = arrayOf(prvoPolje + 1, cetvrtoPolje - 1).random()
                    } else {
                        petoPolje = arrayOf(prvoPolje + 1, trecePolje - 1).random()
                    }
                } else if (trecePolje > drugoPolje && trecePolje > cetvrtoPolje) {
                    if (drugoPolje > cetvrtoPolje) {
                        petoPolje = arrayOf(prvoPolje + 1, cetvrtoPolje - 1).random()
                    } else {
                        petoPolje = arrayOf(prvoPolje + 1, drugoPolje - 1).random()
                    }
                } else if (cetvrtoPolje > drugoPolje && cetvrtoPolje > trecePolje) {
                    if (drugoPolje > trecePolje) {
                        petoPolje = arrayOf(prvoPolje + 1, trecePolje - 1).random()
                    } else {
                        petoPolje = arrayOf(prvoPolje + 1, drugoPolje - 1).random()
                    }
                }
            } else if (drugoPolje > prvoPolje && drugoPolje > trecePolje && drugoPolje > cetvrtoPolje) {      //2
                if (prvoPolje > trecePolje && prvoPolje > cetvrtoPolje) {
                    if (trecePolje > cetvrtoPolje) {
                        petoPolje = arrayOf(drugoPolje + 1, cetvrtoPolje - 1).random()
                    } else {
                        petoPolje = arrayOf(drugoPolje + 1, trecePolje - 1).random()
                    }
                } else if (trecePolje > prvoPolje && trecePolje > cetvrtoPolje) {
                    if (prvoPolje > cetvrtoPolje) {
                        petoPolje = arrayOf(drugoPolje + 1, cetvrtoPolje - 1).random()
                    } else {
                        petoPolje = arrayOf(drugoPolje + 1, prvoPolje - 1).random()
                    }
                } else {
                    if (prvoPolje > trecePolje) {
                        petoPolje = arrayOf(drugoPolje + 1, trecePolje - 1).random()
                    } else {
                        petoPolje = arrayOf(drugoPolje + 1, prvoPolje - 1).random()
                    }
                }
            } else if (trecePolje > prvoPolje && trecePolje > drugoPolje && trecePolje > cetvrtoPolje) {        //3
                if (prvoPolje > drugoPolje && prvoPolje > cetvrtoPolje) {                                           //1
                    if (drugoPolje > cetvrtoPolje) {                                                                    //2
                        petoPolje = arrayOf(trecePolje + 1, cetvrtoPolje - 1).random()
                    } else {
                        petoPolje = arrayOf(trecePolje + 1, drugoPolje - 1).random()
                    }
                } else if (drugoPolje > prvoPolje && drugoPolje > cetvrtoPolje) {                                   //2
                    if (prvoPolje > cetvrtoPolje) {                                                                     //4
                        petoPolje = arrayOf(trecePolje + 1, cetvrtoPolje - 1).random()
                    } else {                                                                                            //1
                        petoPolje = arrayOf(trecePolje + 1, prvoPolje - 1).random()
                    }
                } else {                                                                                            //3
                    if (prvoPolje > drugoPolje) {
                        petoPolje = arrayOf(+1, drugoPolje - 1).random()
                    } else {
                        petoPolje = arrayOf(trecePolje + 1, prvoPolje - 1).random()
                    }
                }
            } else {                                                                            //4
                if (prvoPolje > drugoPolje && prvoPolje > trecePolje) {                            //1
                    if (drugoPolje > trecePolje) {
                        petoPolje = arrayOf(cetvrtoPolje + 1, trecePolje - 1).random()
                    } else {
                        petoPolje = arrayOf(cetvrtoPolje + 1, drugoPolje - 1).random()
                    }
                } else if (drugoPolje > prvoPolje && drugoPolje > trecePolje) {                     //2
                    if (prvoPolje > trecePolje) {
                        petoPolje = arrayOf(cetvrtoPolje + 1, trecePolje - 1).random()
                    } else {
                        petoPolje = arrayOf(cetvrtoPolje + 1, prvoPolje - 1).random()
                    }
                } else {                                                                      //3
                    if (prvoPolje > drugoPolje) {
                        petoPolje = arrayOf(cetvrtoPolje + 1, drugoPolje - 1).random()
                    } else {
                        petoPolje = arrayOf(cetvrtoPolje + 1, prvoPolje - 1).random()
                    }
                }
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
        if (prviRed == 0 || drugiRed == 0 || treciRed == 0 || cetvrtiRed == 0) {
            if (prviRed == 0) {
                petiRed = cetvrtiRed + 1
            } else if (drugiRed == 0) {
                petiRed = cetvrtiRed + 1
            } else if (treciRed == 0) {
                if (prviRed == 1) {
                    if (drugiRed == 2) {
                        petiRed = cetvrtiRed + 1
                    } else {
                        petiRed = drugiRed + 1
                    }
                } else if (drugiRed == 1) {
                    if (prviRed == 2) {
                        petiRed = cetvrtiRed + 1
                    } else {
                        petiRed = prviRed + 1
                    }
                } else {
                    if (prviRed == 2) {
                        petiRed = drugiRed + 1
                    } else {
                        petiRed = prviRed + 1
                    }
                }
            } else {
                if (prviRed == 1) {
                    if (drugiRed == 2) {
                        petiRed = treciRed + 1
                    } else {
                        petiRed = drugiRed + 1
                    }
                } else if (drugiRed == 1) {
                    if (prviRed == 2) {
                        petiRed = treciRed + 1
                    } else {
                        petiRed = prviRed + 1
                    }
                } else {
                    if (prviRed == 2) {
                        petiRed = drugiRed + 1
                    } else {
                        petiRed = prviRed + 1
                    }
                }
            }
        } else if (prviRed == 9 || drugiRed == 9 || treciRed == 9 || cetvrtiRed == 9) {
            if (prviRed == 9) {
                petiRed = cetvrtiRed - 1
            } else if (drugiRed == 9) {
                petiRed = cetvrtiRed - 1
            } else if (treciRed == 9) {
                if (prviRed == 8) {
                    if (drugiRed == 7) {
                        petiRed = cetvrtiRed - 1
                    } else {
                        petiRed = drugiRed - 1
                    }
                } else if (drugiRed == 8) {
                    if (prviRed == 7) {
                        petiRed = cetvrtiRed - 1
                    } else {
                        petiRed = prviRed - 1
                    }
                } else {
                    if (prviRed == 7) {
                        petiRed = drugiRed - 1
                    } else {
                        petiRed = prviRed - 1
                    }
                }
            }
        } else {                //4
            if (prviRed == 8) {        //1
                if (drugiRed == 7) {       //2
                    petiRed = treciRed - 1
                } else {
                    petiRed = drugiRed - 1
                }
            } else if (drugiRed == 8) { //2
                if (prviRed == 7) {
                    petiRed = treciRed - 1
                } else {
                    petiRed = prviRed - 1
                }
            } else {
                if (prviRed == 7) {
                    petiRed = drugiRed - 1
                } else {
                    petiRed = prviRed - 1
                }
            }
        }
        if (prviRed > drugiRed && prviRed > treciRed && prviRed > cetvrtiRed) {
            if (drugiRed > treciRed && drugiRed > cetvrtiRed) {
                if (treciRed > cetvrtiRed) {
                    petiRed = arrayOf(prviRed + 1, cetvrtiRed - 1).random()
                } else {
                    petiRed = arrayOf(prviRed + 1, treciRed - 1).random()
                }
            } else if (treciRed > drugiRed && treciRed > cetvrtiRed) {
                if (drugiRed > cetvrtiRed) {
                    petiRed = arrayOf(prviRed + 1, cetvrtiRed - 1).random()
                } else {
                    petiRed = arrayOf(prviRed + 1, drugiRed - 1).random()
                }
            } else {
                if (drugiRed > treciRed) {
                    petiRed = arrayOf(prviRed + 1, treciRed - 1).random()
                } else {
                    petiRed = arrayOf(prviRed + 1, drugiRed - 1).random()
                }
            }
        } else if (drugiRed > prviRed && drugiRed > treciRed && drugiRed > cetvrtiRed) {
            if (prviRed > treciRed && prviRed > cetvrtiRed) {
                if (treciRed > cetvrtiRed) {
                    petiRed = arrayOf(drugiRed + 1, cetvrtiRed - 1).random()
                } else {
                    petiRed = arrayOf(drugiRed + 1, treciRed - 1).random()
                }
            } else if (treciRed > prviRed && treciRed > cetvrtiRed) {
                if (prviRed > cetvrtiRed) {
                    petiRed = arrayOf(drugiRed + 1, cetvrtiRed - 1).random()
                } else {
                    petiRed = arrayOf(drugiRed + 1, prviRed - 1).random()
                }
            } else {
                if (prviRed > treciRed) {
                    petiRed = arrayOf(drugiRed + 1, treciRed - 1).random()
                } else {
                    petiRed = arrayOf(drugiRed + 1, prviRed - 1).random()
                }
            }
        } else if (treciRed > prviRed && treciRed > drugiRed && treciRed > cetvrtiRed) {
            if (prviRed > drugiRed && prviRed > cetvrtiRed) {
                if (drugiRed > cetvrtiRed) {
                    petiRed = arrayOf(treciRed + 1, cetvrtiRed - 1).random()
                } else {
                    petiRed = arrayOf(treciRed + 1, drugiRed - 1).random()
                }
            } else if (drugiRed > prviRed && drugiRed > cetvrtiRed) {
                if (prviRed > cetvrtiRed) {
                    petiRed = arrayOf(treciRed + 1, cetvrtiRed - 1).random()
                } else {
                    petiRed = arrayOf(treciRed + 1, prviRed - 1).random()
                }
            } else {
                if (prviRed > drugiRed) {
                    petiRed = arrayOf(treciRed + 1, drugiRed - 1).random()
                } else {
                    petiRed = arrayOf(treciRed + 1, prviRed - 1).random()
                }
            }
        } else {
            if (prviRed > drugiRed && prviRed > treciRed) {
                if (drugiRed > treciRed) {
                    petiRed = arrayOf(cetvrtiRed + 1, treciRed - 1).random()
                } else {
                    petiRed = arrayOf(cetvrtiRed + 1, drugiRed - 1).random()
                }
            } else if (drugiRed > prviRed && drugiRed > treciRed) {
                if (prviRed > treciRed) {
                    petiRed = arrayOf(cetvrtiRed + 1, treciRed - 1).random()
                } else {
                    petiRed = arrayOf(cetvrtiRed + 1, prviRed - 1).random()
                }
            } else {
                if (prviRed > drugiRed) {
                    petiRed = arrayOf(cetvrtiRed + 1, drugiRed - 1).random()
                } else {
                    petiRed = arrayOf(cetvrtiRed + 1, prviRed - 1).random()
                }
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

fun isEmptyK(red: Int, kolona: Int): Boolean {
    if (tablaKomp[red][kolona] == 0) {
        return true
    }
    return false
}

fun dodajPrvoPoljeK(velicina: Int) {
    prviRedK = (0..9).random()
    prvoPoljeK = (0..9).random()
    if (isEmptyK(prviRedK, prvoPoljeK)) {
        tablaKomp[prviRedK][prvoPoljeK] = 1
        dodajDrugoPoljeK(velicina)
    } else {
        dodajPrvoPoljeK(velicina)
    }

}

fun dodajDrugoPoljeK(velicina: Int) {
    val horVer = arrayOf("hor", "ver").random()
    if (horVer == "hor") {                                          //HORIZONTALNO
        if (prvoPoljeK == 0) {
            drugoPoljeK = prvoPoljeK + 1
        } else if (prvoPoljeK == 9) {
            drugoPoljeK = prvoPoljeK - 1
        } else {
            drugoPoljeK = arrayOf(prvoPoljeK - 1, prvoPoljeK + 1).random()
        }
        if (isEmptyK(prviRedK, drugoPoljeK)) {
            tablaKomp[prviRedK][drugoPoljeK] = 1
            dodajTrecePoljeK(velicina, horVer)
        } else {
            tablaKomp[prviRedK][prvoPoljeK] = 0
            dodajPrvoPoljeK(velicina)
        }
    } else {                          //VERTIKALNO
        if (prviRedK == 0) {
            drugiRedK = prviRedK + 1
        } else if (prviRedK == 9) {
            drugiRedK = prviRedK - 1
        } else {
            drugiRedK = arrayOf(prviRedK - 1, prviRedK + 1).random()
        }
        if (isEmptyK(drugiRedK, prvoPoljeK)) {
            tablaKomp[drugiRedK][prvoPoljeK] = 1
            dodajTrecePoljeK(velicina, horVer)
        } else {
            tablaKomp[prviRedK][prvoPoljeK] = 0
            dodajPrvoPoljeK(velicina)
        }
    }
}

fun dodajTrecePoljeK(velicina: Int, horVer: String) {
    if (horVer == "hor") {                              //HORIZONTALNO
        if (prvoPoljeK == 0 || drugoPoljeK == 0) {
            if (prvoPoljeK == 0) {                       //drugoPolje==1
                trecePoljeK = drugoPoljeK + 1
            } else {
                trecePoljeK = prvoPoljeK + 1
            }
        } else if (prvoPoljeK == 9 || drugoPoljeK == 9) {
            if (prvoPoljeK == 9) {
                trecePoljeK = drugoPoljeK - 1
            } else {
                trecePoljeK = prvoPoljeK - 1
            }
        } else {
            if (prvoPoljeK > drugoPoljeK) {
                trecePoljeK = arrayOf(drugoPoljeK - 1, prvoPoljeK + 1).random()
            } else {
                trecePoljeK = arrayOf(prvoPoljeK - 1, drugoPoljeK + 1).random()
            }
        }
        if (isEmptyK(prviRedK, trecePoljeK)) {
            tablaKomp[prviRedK][trecePoljeK] = 1
            if (velicina > 3) {
                dodajCetvrtoPoljeK(velicina, horVer)
            }
        } else {
            tablaKomp[prviRedK][prvoPoljeK] = 0
            tablaKomp[prviRedK][drugoPoljeK] = 0
            dodajPrvoPoljeK(velicina)
        }
    } else {                                             //VERTIKALNO
        if (prviRedK == 0 || drugiRedK == 0) {
            if (prviRedK == 0) {
                treciRedK = drugiRedK + 1
            } else {
                treciRedK = prviRedK + 1
            }
        } else if (prviRedK == 9 || drugiRedK == 9) {
            if (prviRedK == 9) {
                treciRedK = drugiRedK - 1
            } else {
                treciRedK = prviRedK + 1
            }
        } else {
            if (prviRedK > drugiRedK) {
                treciRedK = arrayOf(drugiRedK - 1, prviRedK + 1).random()
            } else {
                treciRedK = arrayOf(prviRedK - 1, drugiRedK + 1).random()
            }
        }
        if (isEmptyK(treciRedK, prvoPoljeK)) {
            tablaKomp[treciRedK][prvoPoljeK] = 1
            if (velicina > 3) {
                dodajCetvrtoPoljeK(velicina, horVer)
            }
        } else {
            tablaKomp[prviRedK][prvoPoljeK] = 0
            tablaKomp[drugiRedK][prvoPoljeK] = 0
            dodajPrvoPoljeK(velicina)
        }
    }
}

fun dodajCetvrtoPoljeK(velicina: Int, horVer: String) {
    if (horVer == "hor") {                                                     //HORIZONTALNO
        if (prvoPoljeK == 0 || drugoPoljeK == 0 || trecePoljeK == 0) {
            if (prvoPoljeK == 0) {
                cetvrtoPoljeK = trecePoljeK + 1
            } else if (drugoPoljeK == 0) {
                cetvrtoPoljeK = trecePoljeK + 1
            } else {
                if (prvoPoljeK == 1) {
                    cetvrtoPoljeK = drugoPoljeK + 1
                } else {
                    cetvrtoPoljeK = prvoPoljeK + 1
                }
            }
        } else if (prvoPoljeK == 9 || drugoPoljeK == 9 || trecePoljeK == 9) {
            if (prvoPoljeK == 9) {
                cetvrtoPoljeK = trecePoljeK - 1
            } else if (drugoPoljeK == 9) {
                cetvrtoPoljeK = trecePoljeK - 1
            } else {
                if (prvoPoljeK == 8) {
                    cetvrtoPoljeK = drugoPoljeK - 1
                } else {
                    cetvrtoPoljeK = prvoPoljeK - 1
                }
            }
        } else {
            if (prvoPoljeK > drugoPoljeK && prvoPoljeK > trecePoljeK) {
                if (drugoPoljeK > trecePoljeK) {
                    cetvrtoPoljeK = arrayOf(prvoPoljeK + 1, trecePoljeK - 1).random()
                } else {
                    cetvrtoPoljeK = arrayOf(prvoPoljeK + 1, drugoPoljeK - 1).random()
                }
            } else if (drugoPoljeK > prvoPoljeK && drugoPoljeK > trecePoljeK) {
                if (prvoPoljeK > trecePoljeK) {
                    cetvrtoPoljeK = arrayOf(drugoPoljeK + 1, trecePoljeK - 1).random()
                } else {
                    cetvrtoPoljeK = arrayOf(drugoPoljeK + 1, prvoPoljeK - 1).random()
                }
            } else {
                if (prvoPoljeK > drugoPoljeK) {
                    cetvrtoPoljeK = arrayOf(trecePoljeK + 1, drugoPoljeK - 1).random()
                } else {
                    cetvrtoPoljeK = arrayOf(trecePoljeK + 1, prvoPoljeK - 1).random()
                }
            }
        }
        if (isEmptyK(prviRedK, cetvrtoPoljeK)) {
            tablaKomp[prviRedK][cetvrtoPoljeK] = 1
            if (velicina > 4) {
                dodajPetoPoljeK(horVer)
            }
        } else {
            tablaKomp[prviRedK][prvoPoljeK] = 0
            tablaKomp[prviRedK][drugoPoljeK] = 0
            tablaKomp[prviRedK][trecePoljeK] = 0
            dodajPrvoPoljeK(velicina)
        }
    } else {                                                                  //VERTIKALNO
        if (prviRedK == 0 || drugiRedK == 0 || treciRedK == 0) {
            if (prviRedK == 0) {
                cetvrtiRedK = treciRedK + 1
            } else if (drugiRedK == 0) {
                cetvrtiRedK = treciRedK + 1
            } else {
                if (prviRedK == 1) {
                    cetvrtiRedK = drugiRedK + 1
                } else {
                    cetvrtiRedK = prviRedK + 1
                }
            }
        } else if (prviRedK == 9 || drugiRedK == 9 || treciRedK == 9) {
            if (prviRedK == 9) {
                cetvrtiRedK = treciRedK - 1
            } else if (drugiRedK == 9) {
                cetvrtiRedK = treciRedK - 1
            } else {
                if (prviRedK == 1) {
                    cetvrtiRedK = drugiRedK - 1
                } else {
                    cetvrtiRedK = prviRedK - 1
                }
            }
        } else {
            if (prviRedK > drugiRedK && prviRedK > treciRedK) {
                if (drugiRedK > treciRedK) {
                    cetvrtiRedK = arrayOf(prviRedK + 1, treciRedK - 1).random()
                } else {
                    cetvrtiRedK = arrayOf(prviRedK + 1, drugiRedK - 1).random()
                }
            } else if (drugiRedK > prviRedK && drugiRedK > treciRedK) {
                if (prviRedK > treciRedK) {
                    cetvrtiRedK = arrayOf(drugiRedK + 1, treciRedK - 1).random()
                } else {
                    cetvrtiRedK = arrayOf(drugiRedK + 1, prviRedK - 1).random()
                }
            } else {
                if (prviRedK > drugiRedK) {
                    cetvrtiRedK = arrayOf(treciRedK + 1, drugiRedK - 1).random()
                } else {
                    cetvrtiRedK = arrayOf(treciRedK + 1, prviRedK - 1).random()
                }
            }
        }
        if (isEmptyK(cetvrtiRedK, prvoPoljeK)) {
            tablaKomp[cetvrtiRedK][prvoPoljeK] = 1
            if (velicina > 4) {
                dodajPetoPoljeK(horVer)
            }
        } else {
            tablaKomp[prviRedK][prvoPoljeK] = 0
            tablaKomp[drugiRedK][prvoPoljeK] = 0
            tablaKomp[treciRedK][prvoPoljeK] = 0
            dodajPrvoPoljeK(velicina)
        }
    }
}

fun dodajPetoPoljeK(horVer: String) {
    if (horVer == "hor") {                                                     //HORIZONTALNO
        if (prvoPoljeK == 0 || drugoPoljeK == 0 || trecePoljeK == 0 || cetvrtoPoljeK == 0) {
            if (prvoPoljeK == 0) {
                petoPoljeK = cetvrtoPoljeK + 1
            } else if (drugoPoljeK == 0) {
                petoPoljeK = cetvrtoPoljeK + 1
            } else if (trecePoljeK == 0) {               //3
                if (prvoPoljeK == 1) {                        //1
                    if (drugoPoljeK == 2) {                         //2
                        petoPoljeK = cetvrtoPoljeK + 1                  //4
                    } else {                                      //4
                        petoPoljeK = drugoPoljeK + 1                      //2
                    }
                } else if (drugoPoljeK == 1) {                   //2
                    if (prvoPoljeK == 2) {                          //1
                        petoPoljeK = cetvrtoPoljeK + 1                    //4
                    } else {                                      //4
                        petoPoljeK = prvoPoljeK + 1
                    }
                } else {                                      //4
                    if (prvoPoljeK == 2) {
                        petoPoljeK = drugoPoljeK + 1
                    } else {
                        petoPoljeK = prvoPoljeK + 1
                    }
                }
            } else {                                    //4
                if (prvoPoljeK == 1) {                       //1
                    if (drugoPoljeK == 2) {                      //2
                        petoPoljeK = trecePoljeK + 1
                    } else {                                    //3
                        petoPoljeK = drugoPoljeK + 1
                    }
                } else if (drugoPoljeK == 2) {                   //2
                    if (prvoPoljeK == 2) {
                        petoPoljeK = trecePoljeK + 1
                    } else {                                    //3
                        petoPoljeK = prvoPoljeK + 1
                    }
                } else {                                    //3
                    if (drugoPoljeK == 2) {                      //2
                        petoPoljeK = prvoPoljeK + 1
                    } else {
                        petoPoljeK = drugoPoljeK + 1
                    }
                }
            }
        } else if (prvoPoljeK == 9 || drugoPoljeK == 9 || trecePoljeK == 9 || cetvrtoPoljeK == 9) {
            if (prvoPoljeK == 9) {
                petoPoljeK = cetvrtoPoljeK - 1
            } else if (drugoPoljeK == 9) {
                petoPoljeK = cetvrtoPoljeK - 1
            } else if (trecePoljeK == 9) {
                if (prvoPoljeK == 8) {
                    if (drugoPoljeK == 7) {
                        petoPoljeK = trecePoljeK - 1
                    } else {
                        petoPoljeK = drugoPoljeK - 1
                    }
                } else if (drugoPoljeK == 8) {
                    if (prvoPoljeK == 7) {
                        petoPoljeK = trecePoljeK - 1
                    } else {
                        petoPoljeK = prvoPoljeK - 1
                    }
                } else {
                    if (prvoPoljeK == 7) {
                        petoPoljeK = drugoPoljeK - 1
                    } else {
                        petoPoljeK = prvoPoljeK - 1
                    }
                }
            } else {
                if (prvoPoljeK == 8) {
                    if (drugoPoljeK == 7) {
                        petoPoljeK = trecePoljeK - 1
                    } else {
                        petoPoljeK = drugoPoljeK - 1
                    }
                } else if (drugoPoljeK == 8) {
                    if (prvoPoljeK == 7) {
                        petoPoljeK = trecePoljeK - 1
                    } else {
                        petoPoljeK = prvoPoljeK - 1
                    }
                } else {
                    if (prvoPoljeK == 7) {
                        petoPoljeK = drugoPoljeK - 1
                    } else {
                        petoPoljeK = prvoPoljeK - 1
                    }
                }
            }
        } else {
            if (prvoPoljeK > drugoPoljeK && prvoPoljeK > trecePoljeK && prvoPoljeK > cetvrtoPoljeK) {
                if (drugoPoljeK > trecePoljeK && drugoPoljeK > cetvrtoPoljeK) {
                    if (trecePoljeK > cetvrtoPoljeK) {
                        petoPoljeK = arrayOf(prvoPoljeK + 1, cetvrtoPoljeK - 1).random()
                    } else {
                        petoPoljeK = arrayOf(prvoPoljeK + 1, trecePoljeK - 1).random()
                    }
                } else if (trecePoljeK > drugoPoljeK && trecePoljeK > cetvrtoPoljeK) {
                    if (drugoPoljeK > cetvrtoPoljeK) {
                        petoPoljeK = arrayOf(prvoPoljeK + 1, cetvrtoPoljeK - 1).random()
                    } else {
                        petoPoljeK = arrayOf(prvoPoljeK + 1, drugoPoljeK - 1).random()
                    }
                } else if (cetvrtoPoljeK > drugoPoljeK && cetvrtoPoljeK > trecePoljeK) {
                    if (drugoPoljeK > trecePoljeK) {
                        petoPoljeK = arrayOf(prvoPoljeK + 1, trecePoljeK - 1).random()
                    } else {
                        petoPoljeK = arrayOf(prvoPoljeK + 1, drugoPoljeK - 1).random()
                    }
                }
            } else if (drugoPoljeK > prvoPoljeK && drugoPoljeK > trecePoljeK && drugoPoljeK > cetvrtoPoljeK) {      //2
                if (prvoPoljeK > trecePoljeK && prvoPoljeK > cetvrtoPoljeK) {
                    if (trecePoljeK > cetvrtoPoljeK) {
                        petoPoljeK = arrayOf(drugoPoljeK + 1, cetvrtoPoljeK - 1).random()
                    } else {
                        petoPoljeK = arrayOf(drugoPoljeK + 1, trecePoljeK - 1).random()
                    }
                } else if (trecePoljeK > prvoPoljeK && trecePoljeK > cetvrtoPoljeK) {
                    if (prvoPoljeK > cetvrtoPoljeK) {
                        petoPoljeK = arrayOf(drugoPoljeK + 1, cetvrtoPoljeK - 1).random()
                    } else {
                        petoPoljeK = arrayOf(drugoPoljeK + 1, prvoPoljeK - 1).random()
                    }
                } else {
                    if (prvoPoljeK > trecePoljeK) {
                        petoPoljeK = arrayOf(drugoPoljeK + 1, trecePoljeK - 1).random()
                    } else {
                        petoPoljeK = arrayOf(drugoPoljeK + 1, prvoPoljeK - 1).random()
                    }
                }
            } else if (trecePoljeK > prvoPoljeK && trecePoljeK > drugoPoljeK && trecePoljeK > cetvrtoPoljeK) {        //3
                if (prvoPoljeK > drugoPoljeK && prvoPoljeK > cetvrtoPoljeK) {                                           //1
                    if (drugoPoljeK > cetvrtoPoljeK) {                                                                    //2
                        petoPoljeK = arrayOf(trecePoljeK + 1, cetvrtoPoljeK - 1).random()
                    } else {
                        petoPoljeK = arrayOf(trecePoljeK + 1, drugoPoljeK - 1).random()
                    }
                } else if (drugoPoljeK > prvoPoljeK && drugoPoljeK > cetvrtoPoljeK) {                                   //2
                    if (prvoPoljeK > cetvrtoPoljeK) {                                                                     //4
                        petoPoljeK = arrayOf(trecePoljeK + 1, cetvrtoPoljeK - 1).random()
                    } else {                                                                                            //1
                        petoPoljeK = arrayOf(trecePoljeK + 1, prvoPoljeK - 1).random()
                    }
                } else {                                                                                            //3
                    if (prvoPoljeK > drugoPoljeK) {
                        petoPoljeK = arrayOf(+1, drugoPoljeK - 1).random()
                    } else {
                        petoPoljeK = arrayOf(trecePoljeK + 1, prvoPoljeK - 1).random()
                    }
                }
            } else {                                                                            //4
                if (prvoPoljeK > drugoPoljeK && prvoPoljeK > trecePoljeK) {                            //1
                    if (drugoPoljeK > trecePoljeK) {
                        petoPoljeK = arrayOf(cetvrtoPoljeK + 1, trecePoljeK - 1).random()
                    } else {
                        petoPoljeK = arrayOf(cetvrtoPoljeK + 1, drugoPoljeK - 1).random()
                    }
                } else if (drugoPoljeK > prvoPoljeK && drugoPoljeK > trecePoljeK) {                     //2
                    if (prvoPoljeK > trecePoljeK) {
                        petoPoljeK = arrayOf(cetvrtoPoljeK + 1, trecePoljeK - 1).random()
                    } else {
                        petoPoljeK = arrayOf(cetvrtoPoljeK + 1, prvoPoljeK - 1).random()
                    }
                } else {                                                                      //3
                    if (prvoPoljeK > drugoPoljeK) {
                        petoPoljeK = arrayOf(cetvrtoPoljeK + 1, drugoPoljeK - 1).random()
                    } else {
                        petoPoljeK = arrayOf(cetvrtoPoljeK + 1, prvoPoljeK - 1).random()
                    }
                }
            }
        }
        if (isEmptyK(prviRedK, petoPoljeK)) {
            tablaKomp[prviRedK][petoPoljeK] = 1
        } else {
            tablaKomp[prviRedK][prvoPoljeK] = 0
            tablaKomp[prviRedK][drugoPoljeK] = 0
            tablaKomp[prviRedK][trecePoljeK] = 0
            tablaKomp[prviRedK][cetvrtoPoljeK] = 0
            dodajPrvoPoljeK(5)
        }
    } else {                                                                             //VERTIKALNO
        if (prviRedK == 0 || drugiRedK == 0 || treciRedK == 0 || cetvrtiRedK == 0) {
            if (prviRedK == 0) {
                petiRedK = cetvrtiRedK + 1
            } else if (drugiRedK == 0) {
                petiRedK = cetvrtiRedK + 1
            } else if (treciRedK == 0) {
                if (prviRedK == 1) {
                    if (drugiRedK == 2) {
                        petiRedK = cetvrtiRedK + 1
                    } else {
                        petiRedK = drugiRedK + 1
                    }
                } else if (drugiRedK == 1) {
                    if (prviRedK == 2) {
                        petiRedK = cetvrtiRedK + 1
                    } else {
                        petiRedK = prviRedK + 1
                    }
                } else {
                    if (prviRedK == 2) {
                        petiRedK = drugiRedK + 1
                    } else {
                        petiRedK = prviRedK + 1
                    }
                }
            } else {
                if (prviRedK == 1) {
                    if (drugiRedK == 2) {
                        petiRedK = treciRedK + 1
                    } else {
                        petiRedK = drugiRedK + 1
                    }
                } else if (drugiRedK == 1) {
                    if (prviRedK == 2) {
                        petiRedK = treciRedK + 1
                    } else {
                        petiRedK = prviRedK + 1
                    }
                } else {
                    if (prviRedK == 2) {
                        petiRedK = drugiRedK + 1
                    } else {
                        petiRedK = prviRedK + 1
                    }
                }
            }
        } else if (prviRedK == 9 || drugiRedK == 9 || treciRedK == 9 || cetvrtiRedK == 9) {
            if (prviRedK == 9) {
                petiRedK = cetvrtiRedK - 1
            } else if (drugiRedK == 9) {
                petiRedK = cetvrtiRedK - 1
            } else if (treciRedK == 9) {
                if (prviRedK == 8) {
                    if (drugiRedK == 7) {
                        petiRedK = cetvrtiRedK - 1
                    } else {
                        petiRedK = drugiRedK - 1
                    }
                } else if (drugiRedK == 8) {
                    if (prviRedK == 7) {
                        petiRedK = cetvrtiRedK - 1
                    } else {
                        petiRedK = prviRedK - 1
                    }
                } else {
                    if (prviRedK == 7) {
                        petiRedK = drugiRedK - 1
                    } else {
                        petiRedK = prviRedK - 1
                    }
                }
            }
        } else {                //4
            if (prviRedK == 8) {        //1
                if (drugiRedK == 7) {       //2
                    petiRedK = treciRedK - 1
                } else {
                    petiRedK = drugiRedK - 1
                }
            } else if (drugiRedK == 8) { //2
                if (prviRedK == 7) {
                    petiRedK = treciRedK - 1
                } else {
                    petiRedK = prviRedK - 1
                }
            } else {
                if (prviRedK == 7) {
                    petiRedK = drugiRedK - 1
                } else {
                    petiRedK = prviRedK - 1
                }
            }
        }
        if (prviRedK > drugiRedK && prviRedK > treciRedK && prviRedK > cetvrtiRedK) {
            if (drugiRedK > treciRedK && drugiRedK > cetvrtiRedK) {
                if (treciRedK > cetvrtiRedK) {
                    petiRedK = arrayOf(prviRedK + 1, cetvrtiRedK - 1).random()
                } else {
                    petiRedK = arrayOf(prviRedK + 1, treciRedK - 1).random()
                }
            } else if (treciRedK > drugiRedK && treciRedK > cetvrtiRedK) {
                if (drugiRedK > cetvrtiRedK) {
                    petiRedK = arrayOf(prviRedK + 1, cetvrtiRedK - 1).random()
                } else {
                    petiRedK = arrayOf(prviRedK + 1, drugiRedK - 1).random()
                }
            } else {
                if (drugiRedK > treciRedK) {
                    petiRedK = arrayOf(prviRedK + 1, treciRedK - 1).random()
                } else {
                    petiRedK = arrayOf(prviRedK + 1, drugiRedK - 1).random()
                }
            }
        } else if (drugiRedK > prviRedK && drugiRedK > treciRedK && drugiRedK > cetvrtiRedK) {
            if (prviRedK > treciRedK && prviRedK > cetvrtiRedK) {
                if (treciRedK > cetvrtiRedK) {
                    petiRedK = arrayOf(drugiRedK + 1, cetvrtiRedK - 1).random()
                } else {
                    petiRedK = arrayOf(drugiRedK + 1, treciRedK - 1).random()
                }
            } else if (treciRedK > prviRedK && treciRedK > cetvrtiRedK) {
                if (prviRedK > cetvrtiRedK) {
                    petiRedK = arrayOf(drugiRedK + 1, cetvrtiRedK - 1).random()
                } else {
                    petiRedK = arrayOf(drugiRedK + 1, prviRedK - 1).random()
                }
            } else {
                if (prviRedK > treciRedK) {
                    petiRedK = arrayOf(drugiRedK + 1, treciRedK - 1).random()
                } else {
                    petiRedK = arrayOf(drugiRedK + 1, prviRedK - 1).random()
                }
            }
        } else if (treciRedK > prviRedK && treciRedK > drugiRedK && treciRedK > cetvrtiRedK) {
            if (prviRedK > drugiRedK && prviRedK > cetvrtiRedK) {
                if (drugiRedK > cetvrtiRedK) {
                    petiRedK = arrayOf(treciRedK + 1, cetvrtiRedK - 1).random()
                } else {
                    petiRedK = arrayOf(treciRedK + 1, drugiRedK - 1).random()
                }
            } else if (drugiRedK > prviRedK && drugiRedK > cetvrtiRedK) {
                if (prviRedK > cetvrtiRedK) {
                    petiRedK = arrayOf(treciRedK + 1, cetvrtiRedK - 1).random()
                } else {
                    petiRedK = arrayOf(treciRedK + 1, prviRedK - 1).random()
                }
            } else {
                if (prviRedK > drugiRedK) {
                    petiRedK = arrayOf(treciRedK + 1, drugiRedK - 1).random()
                } else {
                    petiRedK = arrayOf(treciRedK + 1, prviRedK - 1).random()
                }
            }
        } else {
            if (prviRedK > drugiRedK && prviRedK > treciRedK) {
                if (drugiRedK > treciRedK) {
                    petiRedK = arrayOf(cetvrtiRedK + 1, treciRedK - 1).random()
                } else {
                    petiRedK = arrayOf(cetvrtiRedK + 1, drugiRedK - 1).random()
                }
            } else if (drugiRedK > prviRedK && drugiRedK > treciRedK) {
                if (prviRedK > treciRedK) {
                    petiRedK = arrayOf(cetvrtiRedK + 1, treciRedK - 1).random()
                } else {
                    petiRedK = arrayOf(cetvrtiRedK + 1, prviRedK - 1).random()
                }
            } else {
                if (prviRedK > drugiRedK) {
                    petiRedK = arrayOf(cetvrtiRedK + 1, drugiRedK - 1).random()
                } else {
                    petiRedK = arrayOf(cetvrtiRedK + 1, prviRedK - 1).random()
                }
            }
        }
        if (isEmptyK(petiRedK, prvoPoljeK)) {
            tablaKomp[petiRedK][prvoPoljeK] = 1
        } else {
            tablaKomp[prviRedK][prvoPoljeK] = 0
            tablaKomp[drugiRedK][prvoPoljeK] = 0
            tablaKomp[treciRedK][prvoPoljeK] = 0
            tablaKomp[cetvrtiRedK][prvoPoljeK] = 0
            dodajPrvoPoljeK(5)
        }
    }
}

fun gadjanje() {
    igracGadja()
}

fun igracGadja() {
    val red = (0..9).random()
    val polje = (0..9).random()
    if (isChecked(red, polje)) {
        println("Igrac gadja polje $red-$polje")
        shipOrSea(red, polje)
        if (isOver(poeniIgrac)) {
            println("Gotova igra.")
            mojaTabla()
        } else {
            kompGadja()
        }
    } else {
        igracGadja()
    }
}

fun shipOrSea(red: Int, polje: Int) {
    if (tablaKomp[red][polje] == 0) {
        println("Igrac je promasio.")
        tablaKomp[red][polje] = 3
        pokusajiIgrac += 1
    } else {
        println("Igrac je pogodio brod!")
        tablaKomp[red][polje] = 2
        poeniIgrac += 1
        pokusajiIgrac += 1
    }
}

fun isChecked(red: Int, polje: Int): Boolean {
    if (tablaKomp[red][polje] == 0 || tablaKomp[red][polje] == 1) {
        return true
    }
    return false
}

fun isOver(poeni: Int): Boolean {
    if (poeni == 19) {
        if (poeniIgrac==19){
            println("Igrac je pobedio!")
        }else{
            println("Komp je pobedio!")
        }
        return true
    }
    return false
}

fun kompGadja() {
    val red = (0..9).random()
    val polje = (0..9).random()
    if (isCheckedK(red, polje)) {
        println("Komp gadja polje $red-$polje")
        shipOrSeaK(red, polje)
        if (isOver(poeniKomp)) {
            println("Gotova igra.")
            mojaTabla()
        } else {
            igracGadja()
        }
    } else {
        kompGadja()
    }
}

fun isCheckedK(red: Int, polje: Int): Boolean {
    if (tabla[red][polje] == 0 || tabla[red][polje] == 1) {
        return true
    }
    return false
}

fun shipOrSeaK(red: Int, polje: Int) {
    if (tabla[red][polje] == 0) {
        println("Komp je promasio.")
        tabla[red][polje] = 3
        pokusajiKomp += 1
    } else {
        println("Komp je pogodio brod!")
        tabla[red][polje] = 2
        poeniKomp += 1
        pokusajiKomp += 1
    }
}