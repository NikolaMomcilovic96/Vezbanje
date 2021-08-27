import kotlin.math.PI
import kotlin.math.roundToInt
import kotlin.math.sqrt
import kotlin.properties.Delegates

fun main(){
    val nikola = Contact(
        fullName = "Nikola Momcilovic",
        emailAddress = "nikolamomca96@gmail.com"
    )

    val name = nikola.fullName
    val email = nikola.emailAddress

    nikola.emailAddress = "nikola34315@its.edu.rs"
    val nikolaEmail = nikola.emailAddress

    println("$name, $nikolaEmail")

    val newContact = Contact2("Milos", "Momcilovic","milosm99@gmail.com", "Brother")

    val newName = newContact.fullName
    val newEmail = newContact.emailAddress
    val newType = newContact.type

    println("$newName, $newEmail, $newType")

    val address = Address()

    println(address.address1)

    val tv = TV(height = 53.93, width = 95.87)
    val size = tv.diagonal
    println("$size inches")

    tv.width = tv.height
    val diagonal = tv.diagonal
    println("$diagonal inches")

    val monitor = TV(height = 50.0, width = 30.0)
    val dijagonala = monitor.diagonal
    println("$dijagonala cm")

    tv.diagonal = 120
    println(tv.width.roundToInt())
    println(tv.height.roundToInt())

    val level1 = Level(id = 1, boss = "Chameleon", unlocked = true)
    val level2 = Level(id = 2, boss = "Squid", unlocked = false)
    val level3 = Level(id = 3, boss = "Chupacabra", unlocked = false)
    val level4 = Level(id = 4, boss = "Yeti", unlocked = false)

    val highestLevel = Level.highestLevel
    println(highestLevel)

    val delegatedLevel1 = DelegatedLevel(id = 1, boss = "Chameleon")
    val delegatedLevel2 = DelegatedLevel(id = 2, boss = "Squid")
    println(DelegatedLevel.highestLevel)
    delegatedLevel2.unlocked = true
    println(DelegatedLevel.highestLevel)

    val light = LightBulb()
    light.current = 50
    var current = light.current
    light.current = 40
    current = light.current
    println("$current A")

    val circle = Circle(5.0)
    val circumference = circle.circumference
    println(circumference)
    //println("PI = ${circle.pi}")
    println(circle.area)
    val unitCircle = Circle(1.0)
    println("Precnik kruga = ${unitCircle.diametar}")


    val lamp = Lamp()
    lamp.bulb = LightBulb()
    println(lamp.bulb)


    println("CHALLENGES")
    println("1.")
    val chocolateBanana = IceCream()
    chocolateBanana.name = "Chocolate Banana"
    chocolateBanana.ingredients.add("chocolate")
    chocolateBanana.ingredients.add("banana")
    println(chocolateBanana.name)
    println(chocolateBanana.ingredients)

    println("2.")
    val fiesta = Car("Ford", "metalic", FuelTank())
    fiesta.fuelTank.level = 0.09
    println(fiesta.fuelTank.lowFuel)
}

class Contact(
    var fullName: String,
    var emailAddress: String
)

class Contact2(
    val firstName: String,
    var lastName: String,
    var emailAddress: String,
    var type: String = "Friend"
){
    val fullName = "$firstName $lastName"
}

class Address {
    var address1: String
    var address2: String? = null
    var city = ""
    var state: String

    init {
        address1 = ""
        state = ""
    }
}

class TV(
    var height: Double,
    var width: Double
){
    var diagonal: Int
    get() {
        val result = sqrt(height * height + width * width)

        return result.roundToInt()
    }
    set(value) {
        val ratioWidth = 16.0
        val ratioHeight = 9.0

        val ratioDiagonal = sqrt(
            ratioWidth * ratioWidth + ratioHeight * ratioHeight
        )
        height = value.toDouble() * ratioHeight / ratioDiagonal
        width = height * ratioWidth / ratioHeight
    }
}

class Level(
    val id: Int,
    var boss: String,
    var unlocked: Boolean
){
    companion object{
        @JvmStatic var highestLevel = 1
    }
}

class DelegatedLevel(val id: Int, var boss: String){
    companion object{
        var highestLevel = 1
    }
    var unlocked: Boolean by Delegates.observable(false){
        _, old, new ->
        if (new && id > highestLevel){
            highestLevel = id
        }
        println("$old -> $new")
    }
}

class LightBulb{
    companion object{
        const val maxCurrent = 40
    }
    var current by Delegates.observable(0){
        _,_,new ->
        if (new > maxCurrent){
            println("Current too high, falling back to previous setting.")
            false
        }else{
            println("Current is okay.")
            true
        }
    }
}

/*
class Circle(var radius: Double = 0.0){
    val pi: Double by lazy {
        ((4.0 * atan(1.0 / 5.0)) - atan(1.0 / 239.0)) * 4.0
    }
    val circumference: Double
    get() = pi * radius * 2
}*/

class Circle(var radius: Double = 0.0){
    val area: Double by lazy {
        PI * radius * radius
    }
    val circumference: Double
    get() = PI * radius * 2

    val diametar: Double
    get() = 2.0 * radius
}

class Lamp {
    lateinit var bulb: LightBulb
}

//CHALLENGES

//1.
class IceCream{
    var name: String = ""
    val ingredients: ArrayList<String> by lazy {
        arrayListOf<String>()
    }
}

//2.
class Car(
    val make: String,
    val color: String,
    val fuelTank: FuelTank = FuelTank()
)

class FuelTank{
    var lowFuel = true

    var level: Double by Delegates.observable(0.0){
        _, _, new ->
        lowFuel = new < 0.1
    }
}