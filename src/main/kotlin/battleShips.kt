fun main() {
    dodajBrodove()
    mojaTabla()
}

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

/*var tablaKomp = arrayListOf(
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
)*/

fun dodajBrodove() {
    dodajPrvoPolje(5)
    dodajPrvoPolje(4)
    dodajPrvoPolje(3)
}

fun mojaTabla() {
    for (i in tabla.indices) {
        println("${tabla[i]}")
    }
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
            if (isEmpty(prviRed, cetvrtoPolje)) {
                println("$prviRed $cetvrtoPolje")
            } else {
                dodajPrvoPolje(velicina)
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
            tabla[trecePolje][prvoPolje] = 0
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