import kotlin.math.PI

fun main() {
    val car = OptionalDirection()
    car.turn()
    car.turn(Direction.RIGHT)

    val falcon = LightFreigher()
    falcon.accelerate()
    falcon.stop()

    val enterprise = Starship()
    enterprise.accelerate()
    enterprise.stop()

    val square = Square(4.0)
    val triangle = Triangle(3.0, 5.0)
    val circle = CircleInterfaces(2.0)
    val shapes = arrayOf(square, triangle, circle)
    println(shapes.map { it.area })
}

interface Vehicle {
    fun accelerate()
    fun stop()
}

class Unicycle : Vehicle {
    var paddling = false

    override fun accelerate() {
        paddling = true
    }

    override fun stop() {
        paddling = false
    }
}

enum class Direction {
    LEFT,
    RIGHT
}

interface DirectionalVehicle {
    fun accelerate()
    fun stop()
    fun turn(direction: Direction)
    fun description(): String
}

interface OptionalDirectionalVehicle {
    fun turn(direction: Direction = Direction.LEFT)
}

class OptionalDirection : OptionalDirectionalVehicle {
    override fun turn(direction: Direction) {
        println(direction)
    }
}

interface SpaceVehicle {
    fun accelerate()

    fun stop() {
        println("Whoa, slow down!")
    }
}

class LightFreigher : SpaceVehicle {
    override fun accelerate() {
        println("Proceed to hyperspace!")
    }
}

class Starship : SpaceVehicle {
    override fun accelerate() {
        println("Warp factor 9 please!")
    }

    override fun stop() {
        super.stop()
        println("That kind of hurt!")
    }
}

interface VehicleProperties {
    val weight: Int
    val name: String
        get() = "Vehicle"
}

class CarIntefraces : VehicleProperties {
    override val weight: Int
        get() = 1000
}

class TankInterfaces : VehicleProperties {
    override val weight: Int
        get() = 10000

    override val name: String
        get() = "Tank"
}

interface WheeledVehicle : Vehicle {
    val numberOfWheeles: Int
    val wheelSize: Double
}

class Bike : WheeledVehicle {
    var peddling = false
    var brakesApplied = false

    override val numberOfWheeles = 2
    override val wheelSize = 622.0

    override fun accelerate() {
        peddling = true
        brakesApplied = false
    }

    override fun stop() {
        peddling = false
        brakesApplied = true
    }
}

interface Area {
    val area: Double
}

class Square(val side: Double) : Area {
    override val area: Double
        get() = side * side
}

class Triangle(val base: Double, val height: Double) : Area {
    override val area: Double
        get() = 0.5 * base * height
}

class CircleInterfaces(val radius: Double) : Area {
    override val area: Double
        get() = PI * radius * radius
}