data class Majica(
    val velicina: Velicina,
    val boja: Boja,
    val price: Double,
    val image: Boolean = false
)

class Kupac(
    val name: String,
    val email: String
)

data class Adresa(
    val name: String,
    val street: String,
    val city: String,
    val zip: Int
)

class ShoppingCart(
    val lista: MutableList<Majica> = mutableListOf(),
    val adresa: Adresa
) {
    fun ukupnaCena(lista: MutableList<Majica>): Double {
        var ukupno = 0.0
        for (item in lista) {
            ukupno += item.price
        }
        return ukupno
    }
}

enum class Velicina {
    Small,
    Medium,
    Large
}

enum class Boja {
    Crna,
    Crvena,
    Plava
}

open class Inventar(
    val lista: MutableList<Majica> = mutableListOf()
) {
    fun dodajUListu(majica: Majica, kolicina: Int) {
        for (i in 0 until kolicina) {
            lista.add(majica)
        }
    }

    fun izbrojMajice(zeljena: Majica) {
        var ukupno = 0

        for (i in lista) {
            if (i == zeljena) {
                ukupno += 1
            }
        }
        println("Na stanju ima: $ukupno majice/i u ${zeljena.boja}-oj boji i ${zeljena.velicina} velicini.")
    }

    fun ukloniMajice(majica: Majica, kolicina: Int) {
        for (i in 0 until kolicina) {
            lista.remove(majica)
        }
    }

    fun kolicina(zeljena: Majica): Int {
        var ukupno = 0
        for (i in lista) {
            if (i == zeljena) {
                ukupno += 1
            }
        }
        return ukupno
    }

    fun vratiListu(): MutableList<Majica> {
        return lista
    }
}

class OrderManager(/*korisnik: Kupac, */majica: Majica, lista: MutableList<Majica>) : Inventar(lista) {
    fun naruciMajice(majica: Majica, zeljenaKolicina: Int) {
        val kolicina = kolicina(majica)

        if (zeljenaKolicina <= kolicina) {
            ukloniMajice(majica, zeljenaKolicina)
            println("Uspesno ste narucili $zeljenaKolicina majici ${majica.velicina} velicine u ${majica.boja}-oj boji!")
        } else {
            println("Na stanju imamo $kolicina majici u zeljenoj boji i velicini.")
        }
    }
}

fun dodajMajice() {
    inventar.dodajUListu(crnaL, 17)
    inventar.dodajUListu(crnaS, 12)
    inventar.dodajUListu(crvenaM, 25)
    inventar.dodajUListu(plavaL, 30)
}

fun prikaziInventar() {
    inventar.izbrojMajice(crnaL)
    inventar.izbrojMajice(crnaS)
    inventar.izbrojMajice(crvenaM)
    inventar.izbrojMajice(plavaL)
}

fun naruciMajice() {
    menadzer.naruciMajice(crnaL, 13)
}

val crnaL = Majica(Velicina.Large, Boja.Crna, 1200.0)
val crnaS = Majica(Velicina.Small, Boja.Crna, 900.0)
val crvenaM = Majica(Velicina.Medium, Boja.Crvena, 1200.0)
val plavaL = Majica(Velicina.Large, Boja.Plava, 1200.0)
val inventar = Inventar()
val kupac = Kupac("Nikola", "nikolamomca96@gmail.com")
val menadzer = OrderManager(/*kupac, */crnaL, inventar.vratiListu())

fun main() {
    dodajMajice()
    prikaziInventar()
    println("=============================================================")
    naruciMajice()
    println("=============================================================")
    prikaziInventar()
}