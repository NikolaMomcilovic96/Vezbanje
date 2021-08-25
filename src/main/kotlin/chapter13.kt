import kotlin.math.roundToInt
import kotlin.math.sqrt

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