import javax.print.attribute.standard.MediaSize
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

    val cars = listOf("Lamborghini", "Ferrari", "Rolls-Royce")
    val numbers = mapOf("Brady" to 12, "Manning" to 18, "Brees" to 9)

    for (aCar in cars) {
        println(aCar)
    }

    for (qb in numbers) {
        println("${qb.key} wears ${qb.value}")
    }

    val titanic = Boat()
    titanic.length = 883

    val qe2 = Boat()
    qe2.length = 963

    println(titanic > qe2)

    val dog = Dog()
    val cat = Cat()
    val fish = Fish()
    val bird = Bird()

    val walkingDuties: Array<Walkable> = arrayOf(dog)
    val feedingDuties: Array<Feedable> = arrayOf(dog, cat, fish, bird)
    val cleaningDuties: Array<Cleanable> = arrayOf(cat, fish, bird)
    val tankingDuties: Array<Tankable> = arrayOf(fish)
    val cagingDuties: Array<Cageable> = arrayOf(bird)

    for (walkable in walkingDuties){
        walkable.walk()
    }

    for (feedable in feedingDuties){
        feedable.feed()
    }

    for (cleanable in cleaningDuties){
        cleanable.clean()
    }

    for (tankable in tankingDuties){
        tankable.tank()
    }

    for (cageable in cagingDuties){
        cageable.cage()
    }
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

interface Wheeled {
    val numberOfWheels: Int
    val wheelSize: Double
}

class Tricycle : Wheeled, Vehicle {
    override fun accelerate() {
        TODO("Not yet implemented")
    }

    override fun stop() {
        TODO("Not yet implemented")
    }

    override val numberOfWheels: Int
        get() = TODO("Not yet implemented")

    override val wheelSize: Double
        get() = TODO("Not yet implemented")
}

public interface Comparable<in T> {
    public operator fun compareTo(other: T): Int
}

interface SizedVehicle {
    var length: Int
}

class Boat : SizedVehicle, Comparable<Boat> {
    override var length: Int = 0
    override fun compareTo(other: Boat): Int {
        return when {
            length > other.length -> 1
            length == other.length -> 0
            else -> -1
        }
    }
}

//CHALLENGES
interface Feedable{
    fun feed()
}

interface Cleanable{
    fun clean()
}

interface Cageable : Cleanable{
    fun cage()
}

interface Tankable : Cleanable{
    fun tank()
}

interface Walkable{
    fun walk()
}

class Dog: Feedable, Walkable{
    override fun feed() {
        println("Woof...thanks!")
    }

    override fun walk() {
        println("Walk the dog.")
    }
}

class Cat:Feedable, Cleanable{
    override fun feed() {
        println("Yummy meow")
    }

    override fun clean() {
        println("Litter box cleaned")
    }
}

class Fish:Feedable,Tankable{
    override fun feed() {
        println("Fish goes blub")
    }

    override fun tank() {
        println("Fish has been tanked")
    }

    override fun clean() {
        println("Fish tank has been cleaned")
    }
}

class Bird: Feedable, Cageable{
    override fun feed() {
        println("Tweet!")
    }

    override fun cage() {
        println("Cage the bird")
    }

    override fun clean() {
        println("Clean the cage")
    }
}