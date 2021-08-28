fun main() {
    maliBrod()
    srednjiBrod()
    velikiBrod()
    mojaTabla()
}


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
    (arrayListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)),
)


fun mojaTabla() {
    for (i in tabla.indices) {
        println(tabla[i])
    }
}

var prviRed = 0
var drugiRed: Int = 0
var treciRed: Int = 0
var cetvrtiRed: Int = 0
var petiRed: Int = 0
var prvoPolje: Int = 0
var drugoPolje: Int = 0
var trecePolje: Int = 0
var cetvrtoPolje: Int = 0
var petoPolje: Int = 0


fun maliBrod() {
    prviRed = (0..9).random()
    prvoPolje = (0..9).random()
    val orientation = arrayOf("hor", "ver").random()
    println("1. Red $prviRed polje $prvoPolje")
    tabla[prviRed][prvoPolje] = 1
    if (orientation == "ver") {
        if (prviRed == 0) {
            drugiRed = prviRed + 1
        } else if (prviRed == 9) {
            drugiRed = prviRed - 1
        } else {
            drugiRed = arrayOf(prviRed - 1, prviRed + 1).random()
        }
        println("2. Red $drugiRed polje $prvoPolje")
        tabla[drugiRed][prvoPolje] = 1

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
                treciRed = prviRed - 1
            }
        } else {
            if (prviRed > drugiRed) {
                treciRed = arrayOf(prviRed + 1, drugiRed - 1).random()
            } else {
                treciRed = arrayOf(prviRed - 1, drugiRed + 1).random()
            }
        }
        println("3. Red $treciRed polje $prvoPolje")
        tabla[treciRed][prvoPolje] = 1
    } else {
        if (prvoPolje == 0) {
            drugoPolje = prvoPolje + 1
        } else if (prvoPolje == 9) {
            drugoPolje = prvoPolje - 1
        } else {
            drugoPolje = arrayOf(prvoPolje - 1, prvoPolje + 1).random()
        }
        println("2. Red $prviRed polje $drugoPolje")
        tabla[prviRed][drugoPolje] = 1

        if (prvoPolje == 0 || drugoPolje == 0) {
            if (prvoPolje == 0) {
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
                trecePolje = arrayOf(prvoPolje + 1, drugoPolje - 1).random()
            } else {
                trecePolje = arrayOf(prvoPolje - 1, drugoPolje + 1).random()
            }
        }
        println("3. Red $prviRed polje $trecePolje")
        tabla[prviRed][trecePolje] = 1
    }
}

fun srednjiBrod() {
    prviRed = (0..9).random()
    prvoPolje = (0..9).random()
    if (tabla[prviRed][prvoPolje] == 1) {
        println("Polje je vec zauzeto.")
        srednjiBrod()
    } else {
        val orientation = arrayOf("hor", "ver").random()
        println("1. Red $prviRed polje $prvoPolje")
        tabla[prviRed][prvoPolje] = 1
        if (orientation == "ver") {
            if (prviRed == 0) {
                drugiRed = prviRed + 1
            } else if (prviRed == 9) {
                drugiRed = prviRed - 1
            } else {
                drugiRed = arrayOf(prviRed - 1, prviRed + 1).random()
            }
            println("2. Red $drugiRed polje $prvoPolje")
            tabla[drugiRed][prvoPolje] = 1

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
                    treciRed = prviRed - 1
                }
            } else {
                if (prviRed > drugiRed) {
                    treciRed = arrayOf(prviRed + 1, drugiRed - 1).random()
                } else {
                    treciRed = arrayOf(prviRed - 1, drugiRed + 1).random()
                }
            }
            println("3. Red $treciRed polje $prvoPolje")
            tabla[treciRed][prvoPolje] = 1

            if (prviRed == 0 || drugiRed == 0 || treciRed == 0) {
                if (prviRed == 0) {
                    cetvrtiRed = treciRed + 1
                } else if (drugiRed == 0) {
                    if (prviRed == 1) {
                        cetvrtiRed = treciRed + 1
                    } else {
                        cetvrtiRed = prviRed + 1
                    }
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
                    if (drugiRed == 8) {
                        cetvrtiRed = prviRed - 1
                    } else {
                        cetvrtiRed = drugiRed - 1
                    }
                }
            } else {
                if (prviRed > drugiRed && prviRed > treciRed) {
                    cetvrtiRed = prviRed + 1
                } else if (drugiRed > prviRed && drugiRed > treciRed) {
                    cetvrtiRed = drugiRed + 1
                } else {
                    cetvrtiRed = treciRed + 1
                }
            }
            println("4. Red $cetvrtiRed polje $prvoPolje")
            tabla[cetvrtiRed][prvoPolje] = 1
        } else {                                                        //horizontalno
            if (prvoPolje == 0) {
                drugoPolje = prvoPolje + 1
            } else if (prvoPolje == 9) {
                drugoPolje = prvoPolje - 1
            } else {
                drugoPolje = arrayOf(prvoPolje - 1, prvoPolje + 1).random()
            }
            println("2. Red $prviRed polje $drugoPolje")
            tabla[prviRed][drugoPolje] = 1

            if (prvoPolje == 0 || drugoPolje == 0) {
                if (prvoPolje == 0) {
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
                    trecePolje = arrayOf(prvoPolje + 1, drugoPolje - 1).random()
                } else {
                    trecePolje = arrayOf(prvoPolje - 1, drugoPolje + 1).random()
                }
            }
            println("3. Red $prviRed polje $trecePolje")
            tabla[prviRed][trecePolje] = 1

            if (prvoPolje == 0 || drugoPolje == 0 || trecePolje == 0) {
                if (prvoPolje == 0) {
                    cetvrtoPolje = trecePolje + 1
                } else if (drugoPolje == 0) {
                    cetvrtoPolje = trecePolje + 1
                } else {
                    if (drugoPolje == 1) {
                        cetvrtoPolje = prvoPolje + 1
                    } else {
                        cetvrtoPolje = drugoPolje + 1
                    }
                }
            } else if (prvoPolje == 9 || drugoPolje == 9 || trecePolje == 9) {
                if (prvoPolje == 9) {
                    if (drugoPolje == 8) {
                        cetvrtoPolje = trecePolje - 1
                    } else {
                        cetvrtoPolje = drugoPolje - 1
                    }
                } else if (drugoPolje == 9) {
                    if (prvoPolje == 8) {
                        cetvrtoPolje = trecePolje - 1
                    } else {
                        cetvrtoPolje = prvoPolje - 1
                    }
                } else {
                    if (prvoPolje == 8) {
                        cetvrtoPolje = drugoPolje - 1
                    } else {
                        cetvrtoPolje = prvoPolje - 1
                    }
                }
            } else {
                if (prvoPolje > drugoPolje && prvoPolje > trecePolje) {
                    cetvrtoPolje = prvoPolje + 1
                } else if (trecePolje > prvoPolje && trecePolje > drugoPolje) {
                    cetvrtoPolje = trecePolje + 1
                } else if (drugoPolje > prvoPolje && drugoPolje > trecePolje) {
                    cetvrtoPolje = drugoPolje + 1
                }
            }
            println("4. Red $prviRed polje $cetvrtoPolje")
            tabla[prviRed][cetvrtoPolje] = 1
        }
    }

}

fun velikiBrod() {
    prviRed = (0..9).random()
    prvoPolje = (0..9).random()
    val orientation = arrayOf("hor", "ver").random()
    println("1. Red $prviRed polje $prvoPolje")
    tabla[prviRed][prvoPolje] = 1
    if (orientation == "ver") {                                     //vertikalno
        if (prviRed == 0) {
            drugiRed = prviRed + 1
        } else if (prviRed == 9) {
            drugiRed = prviRed - 1
        } else {
            drugiRed = arrayOf(prviRed - 1, prviRed + 1).random()
        }
        println("2. Red $drugiRed polje $prvoPolje")
        tabla[drugiRed][prvoPolje] = 1

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
                treciRed = prviRed - 1
            }
        } else {
            if (prviRed > drugiRed) {
                treciRed = arrayOf(prviRed + 1, drugiRed - 1).random()
            } else {
                treciRed = arrayOf(prviRed - 1, drugiRed + 1).random()
            }
        }
        println("3. Red $treciRed polje $prvoPolje")
        tabla[treciRed][prvoPolje] = 1

        if (prviRed == 0 || drugiRed == 0 || treciRed == 0) {
            if (prviRed == 0) {
                cetvrtiRed = treciRed + 1
            } else if (drugiRed == 0) {
                if (prviRed == 1) {
                    cetvrtiRed = treciRed + 1
                } else {
                    cetvrtiRed = prviRed + 1
                }
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
                if (drugiRed == 8) {
                    cetvrtiRed = prviRed - 1
                } else {
                    cetvrtiRed = drugiRed - 1
                }
            }
        } else {
            if (prviRed > drugiRed && prviRed > treciRed) {
                cetvrtiRed = prviRed + 1
            } else if (drugiRed > prviRed && drugiRed > treciRed) {
                cetvrtiRed = drugiRed + 1
            } else {
                cetvrtiRed = treciRed + 1
            }
        }
        println("4. Red $cetvrtiRed polje $prvoPolje")
        tabla[cetvrtiRed][prvoPolje] = 1

        if (prviRed == 0 || drugiRed == 0 || treciRed == 0 || cetvrtiRed == 0) {
            if (prviRed == 0 || drugiRed == 0 || treciRed == 0) {
                petiRed = cetvrtiRed + 1
            } else if (cetvrtiRed == 0) {
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
                        petiRed = drugiRed + 1
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
                petiRed = treciRed - 1
            } else if (treciRed == 9) {
                if (drugiRed == 8) {
                    petiRed = cetvrtiRed - 1
                } else {
                    petiRed = cetvrtiRed - 1
                }
            } else {
                if (treciRed == 8) {
                    if (drugiRed == 7) {
                        petiRed = prviRed - 1
                    } else {
                        petiRed = drugiRed - 1
                    }
                } else if (drugiRed == 8) {
                    if (prviRed == 7) {
                        petiRed = treciRed - 1
                    } else {
                        petiRed = prviRed - 1
                    }
                } else {
                    if (drugiRed == 7) {
                        petiRed = treciRed - 1
                    } else {
                        petiRed = drugiRed - 1
                    }
                }
            }
        } else {
            if (prviRed<drugiRed&&prviRed<treciRed&&prviRed<cetvrtiRed){
                petiRed=prviRed-1
            }else if (drugiRed<prviRed&&drugiRed<treciRed&&drugiRed<cetvrtiRed){
                petiRed=drugiRed-1
            }else if (treciRed<prviRed&&treciRed<drugiRed&&treciRed<cetvrtiRed){
                petiRed=treciRed-1
            }else{
                petiRed=cetvrtiRed-1
            }
        }
        println("5. Red $petiRed polje $prvoPolje")
        tabla[petiRed][prvoPolje] = 1
    } else {                                                            //horizontalno
        if (prvoPolje == 0) {
            drugoPolje = prvoPolje + 1
        } else if (prvoPolje == 9) {
            drugoPolje = prvoPolje - 1
        } else {
            drugoPolje = arrayOf(prvoPolje - 1, prvoPolje + 1).random()
        }
        println("2. Red $prviRed polje $drugoPolje")
        tabla[prviRed][drugoPolje] = 1

        if (prvoPolje == 0 || drugoPolje == 0) {
            if (prvoPolje == 0) {
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
                trecePolje = arrayOf(prvoPolje + 1, drugoPolje - 1).random()
            } else {
                trecePolje = arrayOf(prvoPolje - 1, drugoPolje + 1).random()
            }
        }
        println("3. Red $prviRed polje $trecePolje")
        tabla[prviRed][trecePolje] = 1

        if (prvoPolje == 0 || drugoPolje == 0 || trecePolje == 0) {
            if (prvoPolje == 0) {
                cetvrtoPolje = trecePolje + 1
            } else if (drugoPolje == 0) {
                cetvrtoPolje = trecePolje + 1
            } else {
                if (drugoPolje == 1) {
                    cetvrtoPolje = prvoPolje + 1
                } else {
                    cetvrtoPolje = drugoPolje + 1
                }
            }
        } else if (prvoPolje == 9 || drugoPolje == 9 || trecePolje == 9) {
            if (prvoPolje == 9) {
                if (drugoPolje == 8) {
                    cetvrtoPolje = trecePolje - 1
                } else {
                    cetvrtoPolje = drugoPolje - 1
                }
            } else if (drugoPolje == 9) {
                if (prvoPolje == 8) {
                    cetvrtoPolje = trecePolje - 1
                } else {
                    cetvrtoPolje = prvoPolje - 1
                }
            } else {
                if (prvoPolje == 8) {
                    cetvrtoPolje = drugoPolje - 1
                } else {
                    cetvrtoPolje = prvoPolje - 1
                }
            }
        } else {
            if (prvoPolje > drugoPolje && prvoPolje > trecePolje) {
                cetvrtoPolje = prvoPolje + 1
            } else if (trecePolje > prvoPolje && trecePolje > drugoPolje) {
                cetvrtoPolje = trecePolje + 1
            } else if (drugoPolje > prvoPolje && drugoPolje > trecePolje) {
                cetvrtoPolje = drugoPolje + 1
            }
        }
        println("4. Red $prviRed polje $cetvrtoPolje")
        tabla[prviRed][cetvrtoPolje] = 1

        if (prvoPolje == 0 || drugoPolje == 0 || trecePolje == 0 || cetvrtoPolje == 0) {
            if (prvoPolje == 0 || drugoPolje == 0 || trecePolje == 0) {
                petoPolje = cetvrtoPolje + 1
            } else if (cetvrtoPolje == 0) {
                if (prvoPolje == 1) {
                    if (drugoPolje == 2) {
                        petoPolje = trecePolje + 1
                    } else {
                        petoPolje = drugoPolje + 1
                    }
                } else if (drugoPolje == 1) {
                    if (prvoPolje == 2) {
                        petoPolje = trecePolje + 1
                    } else {
                        petoPolje = prvoPolje + 1
                    }
                } else {
                    if (prvoPolje == 2) {
                        petoPolje = drugoPolje + 1
                    } else {
                        petoPolje = prvoPolje + 1
                    }
                }
            }
        } else if (prvoPolje == 9 || drugoPolje == 9 || trecePolje == 9 || cetvrtoPolje == 9) {
            if (prvoPolje == 9 || drugoPolje == 9 || trecePolje == 9) {
                petoPolje = cetvrtoPolje - 1
            } else if (cetvrtoPolje == 9) {
                if (prvoPolje == 8) {
                    petoPolje = trecePolje - 1
                } else if (prvoPolje == 7) {
                    if (drugoPolje == 6) {
                        petoPolje = drugoPolje - 1
                    } else {
                        petoPolje = trecePolje - 1
                    }
                } else if (prvoPolje == 6) {
                    petoPolje = prvoPolje - 1
                }
            }
        } else {
            if (prvoPolje > drugoPolje && prvoPolje > trecePolje && prvoPolje > cetvrtoPolje) {
                petoPolje = prvoPolje + 1
            } else if (trecePolje > prvoPolje && trecePolje > drugoPolje && trecePolje > cetvrtoPolje) {
                petoPolje = trecePolje + 1
            } else if (drugoPolje > prvoPolje && drugoPolje > trecePolje && drugoPolje > cetvrtoPolje) {
                petoPolje = drugoPolje + 1
            } else {
                petoPolje = cetvrtoPolje + 1
            }
        }
        println("5. Red $prviRed polje $petoPolje")
        tabla[prviRed][petoPolje] = 1
    }
}

fun isEmpty(red: Int, kolona: Int): Boolean {
    return tabla[red][kolona] != 1
}


/*fun postaviPrviBrod() {
    if (maliBrodovi != 0 && sredjniBrodovi != 0 && velikiBrod != 0) {      //za sve brodove

        val velicinaBroda = (3..4).random()
        println("Velicina broda $velicinaBroda")
        val prvoPolje = (0 until tabla[0].count()).random()
        println("1. Red $red polje $prvoPolje")

        if (velicinaBroda == 3) {                               //velicina 3
            tabla[red][prvoPolje] = 1

            val horVer = arrayOf("hor", "ver").random()
            println(horVer)
            if (horVer == "hor") {                              //horizontalno
                if (prvoPolje != 0 && prvoPolje != 9) {
                    drugoPolje = arrayOf(prvoPolje - 1, prvoPolje + 1).random()
                    tabla[red][drugoPolje] = 1
                } else if (prvoPolje == 0) {
                    drugoPolje = prvoPolje + 1
                    tabla[red][drugoPolje] = 1
                } else if (prvoPolje == 9) {
                    drugoPolje = prvoPolje - 1
                    tabla[red][drugoPolje] = 1
                }
                println("2. Red $red polje $drugoPolje")
                if (drugoPolje != 0 && drugoPolje != 9) {
                    trecePolje = arrayOf(prvoPolje - 1, prvoPolje + 1).random()
                    tabla[red + 1][trecePolje] = 1
                } else if (drugoPolje == 0) {
                    trecePolje = prvoPolje + 1
                    tabla[red][trecePolje] = 1
                } else if (drugoPolje == 9) {
                    trecePolje = prvoPolje - 1
                    tabla[red][trecePolje] = 1
                }
                println("3. Red $red polje $trecePolje")
            } else {                                            //vertikalno redjanje
                if (prvoPolje != 0 && prvoPolje != 9) {             //drugo polje
                    drugiRed = arrayOf(red - 1, red + 1).random()
                    tabla[drugiRed][prvoPolje] = 1
                } else if (prvoPolje == 0) {
                    tabla[red + 1][prvoPolje] = 1
                } else if (prvoPolje == 9) {
                    tabla[red - 1][prvoPolje] = 1
                }
                println("2. Red $red polje $drugoPolje")
                if (drugoPolje != 0 && drugoPolje != 9 && prviRed != 0 && prviRed != 9) {           //trece polje
                    treciRed = arrayOf(red - 2, red + 2).random()
                    tabla[treciRed][prvoPolje] = 1
                } else if (prvoPolje == 0 || drugoPolje == 0) {
                    tabla[red + 2][prvoPolje] = 1
                } else if (prvoPolje == 9 || drugoPolje == 9) {
                    tabla[red - 2][prvoPolje] = 1
                }
                println("3.  Red $red polje $prvoPolje")
            }
            maliBrodovi -= 1
        } else if (velicinaBroda == 4) {                        //Velicina broja 4
            tabla[red][prvoPolje] = 1

            val horVer = arrayOf("hor", "ver").random()
            if (horVer == "hor") {                          //horizontalno
                if (prvoPolje != 0 && prvoPolje != 9) {
                    drugoPolje = arrayOf(prvoPolje - 1, prvoPolje + 1).random()
                    tabla[red][drugoPolje] = 1
                } else if (prvoPolje == 0) {
                    drugoPolje = prvoPolje + 1
                    tabla[red][drugoPolje] = 1
                } else if (prvoPolje == 9) {
                    drugoPolje = prvoPolje - 1
                    tabla[red][drugoPolje] = 1
                }

                if (drugoPolje != 0 && drugoPolje != 9 && prvoPolje != 0 && prvoPolje != 9) {
                    trecePolje = arrayOf(prvoPolje - 1, prvoPolje + 1, drugoPolje - 1, drugoPolje + 1).random()
                    tabla[red][trecePolje] = 1
                } else if (drugoPolje == 0) {
                    trecePolje = prvoPolje + 1
                    tabla[red][trecePolje] = 1
                } else if (drugoPolje == 9) {
                    trecePolje = prvoPolje - 1
                    tabla[red][trecePolje] = 1
                } else if (prvoPolje == 0) {
                    trecePolje = drugoPolje + 1
                    tabla[red][trecePolje] = 1
                } else if (prvoPolje == 9) {
                    trecePolje = drugoPolje - 1
                    tabla[red][trecePolje] = 1
                }

                if (trecePolje != 0 && trecePolje != 9 && prvoPolje != 0 && prvoPolje != 9) {
                    cetvrtoPolje = arrayOf(prvoPolje - 1, prvoPolje + 1, trecePolje + 1, trecePolje - 1).random()
                    tabla[red][cetvrtoPolje] = 1
                } else if (trecePolje == 0) {
                    cetvrtoPolje = prvoPolje + 1
                    tabla[red][cetvrtoPolje] = 1
                } else if (trecePolje == 9) {
                    cetvrtoPolje = prvoPolje - 1
                    tabla[red][cetvrtoPolje] = 1
                } else if (prvoPolje == 0) {
                    cetvrtoPolje = trecePolje + 1
                    tabla[red][cetvrtoPolje] = 1
                } else if (prvoPolje == 9) {
                    cetvrtoPolje = trecePolje - 1
                    tabla[red][cetvrtoPolje] = 1
                }
            } else {                                          //vertikalno redjanje
                tabla[red + 1][prvoPolje] = 1
                tabla[red + 2][prvoPolje] = 1
                tabla[red + 3][prvoPolje] = 1
            }
            sredjniBrodovi -= 1
        } else if (velicinaBroda == 5) {                        //velicina 5
            tabla[red][prvoPolje] = 1

            val horVer = arrayOf("hor", "ver").random()
            if (horVer == "hor") {                          //horizontalno
                if (prvoPolje != 0 && prvoPolje != 9) {
                    drugoPolje = arrayOf(prvoPolje - 1, prvoPolje + 1).random()
                    tabla[red][drugoPolje] = 1
                } else if (prvoPolje == 0) {
                    drugoPolje = prvoPolje + 1
                    tabla[red][drugoPolje] = 1
                } else if (prvoPolje == 9) {
                    drugoPolje = prvoPolje - 1
                    tabla[red][drugoPolje] = drugoPolje
                }

                if (drugoPolje != 0 && drugoPolje != 9) {
                    trecePolje = arrayOf(prvoPolje - 1, prvoPolje + 1, drugoPolje - 1, drugoPolje + 1).random()
                    tabla[red][trecePolje] = 1
                } else if (drugoPolje == 0) {
                    trecePolje = prvoPolje + 1
                    tabla[red][trecePolje] = 1
                } else if (drugoPolje == 9) {
                    trecePolje = prvoPolje - 1
                    tabla[red][trecePolje] = 1
                }

                if (trecePolje != 0 && trecePolje != 9) {
                    cetvrtoPolje = arrayOf(prvoPolje - 1, prvoPolje + 1, trecePolje + 1, trecePolje - 1).random()
                    tabla[red][cetvrtoPolje] = 1
                } else if (trecePolje == 0) {
                    cetvrtoPolje = prvoPolje + 1
                    tabla[red][cetvrtoPolje] = 1
                } else if (trecePolje == 9) {
                    cetvrtoPolje = prvoPolje - 1
                    tabla[red][cetvrtoPolje] = 1
                }

                if (cetvrtoPolje != 0 && cetvrtoPolje != 9) {
                    petoPolje = arrayOf(prvoPolje - 1, prvoPolje + 1, cetvrtoPolje + 1, cetvrtoPolje - 1).random()
                    tabla[red][petoPolje] = 1
                } else if (cetvrtoPolje == 0) {
                    petoPolje = prvoPolje + 1
                    tabla[red][petoPolje] = 1
                } else if (cetvrtoPolje == 9) {
                    petoPolje = prvoPolje - 1
                    tabla[red][petoPolje] = 1
                }
            } else {                                          //vertikalno redjanje
                tabla[red + 1][prvoPolje] = 1
                tabla[red + 2][prvoPolje] = 1
                tabla[red + 3][prvoPolje] = 1
                tabla[red + 5][prvoPolje] = 1
            }
            velikiBrod -= 1
        }
    }
    mojaTabla()
    preostaloBrodova()
}*/

