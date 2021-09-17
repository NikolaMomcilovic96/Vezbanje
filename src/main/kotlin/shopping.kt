open class Item(
    open val velicina: Velicina,
    open val boja: Boja,
    open val price: Double,
    open val natpis: Boolean
)

data class Majica(
    override val velicina: Velicina,
    override val boja: Boja,
    override val price: Double,
    override val natpis: Boolean = true
) : Item(velicina, boja, price, natpis)

data class Sorts(
    override val velicina: Velicina,
    override val boja: Boja,
    override val price: Double,
    override val natpis: Boolean = false
) : Item(velicina, boja, price, natpis)

data class Duks(
    override val velicina: Velicina,
    override val boja: Boja,
    override val price: Double,
    override val natpis: Boolean = true
) : Item(velicina, boja, price, natpis)

data class Trenerka(
    override val velicina: Velicina,
    override val boja: Boja,
    override val price: Double,
    override val natpis: Boolean = false
) : Item(velicina, boja, price, natpis)

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
    val lista: MutableList<Item> = mutableListOf()
) {
    fun dodajUListu(item: Item, kolicina: Int) {
        for (i in 0 until kolicina) {
            lista.add(item)
        }
    }

    fun izbrojIteme(zeljena: Item, naziv: String) {
        var ukupno = 0

        for (i in lista) {
            if (i == zeljena) {
                ukupno += 1
            }
        }
        println("Na stanju ima: $ukupno $naziv u ${zeljena.boja}-oj boji i ${zeljena.velicina} velicini.")
    }

    fun ukloniIteme(item: Item, kolicina: Int) {
        for (i in 0 until kolicina) {
            lista.remove(item)
        }
    }

    fun kolicina(zeljena: Item): Int {
        var ukupno = 0
        for (i in lista) {
            if (i == zeljena) {
                ukupno += 1
            }
        }
        return ukupno
    }

    fun vratiListu(): MutableList<Item> {
        return lista
    }
}

class OrderManager(lista: MutableList<Item>) : Inventar(lista) {
    fun naruciProizvode(item: Item, zeljenaKolicina: Int, naziv: String) {
        val kolicina = kolicina(item)

        if (zeljenaKolicina <= kolicina) {
            ukloniIteme(item, zeljenaKolicina)
            println("Uspesno ste narucili $zeljenaKolicina $naziv ${item.velicina} velicine u ${item.boja}-oj boji!")
        } else {
            println("Na stanju imamo $kolicina $naziv u zeljenoj boji i velicini.")
        }
    }
}

fun dodajProizvode() {
    inventar.dodajUListu(crnaLMajica, 17)
    inventar.dodajUListu(crnaSMajica, 12)
    inventar.dodajUListu(crvenaMMajica, 25)
    inventar.dodajUListu(plavaLMajica, 30)
    inventar.dodajUListu(crniLSorts, 13)
    inventar.dodajUListu(plaviMSorts, 25)
    inventar.dodajUListu(crnaMTrenerka, 18)
    inventar.dodajUListu(crvenaMTrenerka, 23)
    inventar.dodajUListu(plaviSDuks, 30)
    inventar.dodajUListu(crniMDuks, 23)
    inventar.dodajUListu(crniLDuks, 26)
}

fun prikaziInventar() {
    inventar.izbrojIteme(crnaLMajica, majice)
    inventar.izbrojIteme(crnaSMajica, majice)
    inventar.izbrojIteme(crvenaMMajica, majice)
    inventar.izbrojIteme(plavaLMajica, majice)
    inventar.izbrojIteme(crniLSorts, sortsevi)
    inventar.izbrojIteme(plaviMSorts, sortsevi)
    inventar.izbrojIteme(crnaMTrenerka, trenerke)
    inventar.izbrojIteme(crvenaMTrenerka, trenerke)
    inventar.izbrojIteme(plaviSDuks, duksevi)
    inventar.izbrojIteme(crniMDuks, duksevi)
    inventar.izbrojIteme(crniLDuks, duksevi)
}

fun naruciProizvode() {
    menadzer.naruciProizvode(crnaLMajica, 13, majice)
    menadzer.naruciProizvode(plaviMSorts, 12, sortsevi)
    menadzer.naruciProizvode(crvenaMMajica, 40, majice)
}
val majice = "majica"
val sortsevi = "sortseva"
val duksevi = "dukseva"
val trenerke = "trenerki"

val crnaLMajica = Majica(Velicina.Large, Boja.Crna, 1200.0)
val crnaSMajica = Majica(Velicina.Small, Boja.Crna, 900.0)
val crvenaMMajica = Majica(Velicina.Medium, Boja.Crvena, 1200.0)
val plavaLMajica = Majica(Velicina.Large, Boja.Plava, 1200.0)

val crniLSorts = Sorts(Velicina.Large, Boja.Crna, 1700.0)
val plaviMSorts = Sorts(Velicina.Medium, Boja.Plava, 1600.0)

val crnaMTrenerka = Trenerka(Velicina.Medium, Boja.Crna, 2000.0)
val crvenaMTrenerka = Trenerka(Velicina.Medium, Boja.Crvena, 2000.0)

val plaviSDuks = Duks(Velicina.Small, Boja.Plava, 2500.0, true)
val crniMDuks = Duks(Velicina.Medium, Boja.Crna, 2500.0, true)
val crniLDuks = Duks(Velicina.Large, Boja.Crna, 2500.0, true)

val inventar = Inventar()
val kupac = Kupac("Nikola", "nikolamomca96@gmail.com")
val menadzer = OrderManager(inventar.vratiListu())

fun main() {
    dodajProizvode()
    prikaziInventar()
    println("=============================================================")
    naruciProizvode()
    println("=============================================================")
    prikaziInventar()
}