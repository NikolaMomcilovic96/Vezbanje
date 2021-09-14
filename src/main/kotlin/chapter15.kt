import java.awt.Color

fun main() {
    val john = Person(firstName = "John", lastName = "Appleseed")
    val jane = StudentAdvanced(firstName = "Jane", lastName = "Appleseed")

    println(john.fullName())
    println(jane.fullName())

    val history = Grade(letter = 'B', points = 9.0, credits = 3.0)
    jane.recordGrade(history)

    var hallMonitor = StudentAdvanced(firstName = "Jill", lastName = "Bananapeel")

    println(hallMonitor is oboePlayer)
    println(hallMonitor !is oboePlayer)

    println((hallMonitor as? BandMember)?.minumumPracticeTime)

    val math = Grade(letter = 'B', points = 9.0, credits = 3.0)
    val science = Grade(letter = 'F', points = 9.0, credits = 3.0)
    val physics = Grade(letter = 'F', points = 9.0, credits = 3.0)
    val chemistry = Grade(letter = 'F', points = 9.0, credits = 3.0)

    val dom = StudentAthlete(firstName = "Dom", lastName = "Grady")
    dom.recordGrade(math)
    dom.recordGrade(science)
    dom.recordGrade(physics)
    println(dom.isEligible)
    dom.recordGrade(chemistry)
    println(dom.isEligible)

    val human = Human("5/12/1996")

    val circle1 = Shape.Circle(4)
    val circle2 = Shape.Circle(2)
    val square1 = Shape.Circle(4)
    val square2 = Shape.Square(2)

    fun size(shape: Shape): Int {
        return when (shape) {
            is Shape.Circle -> shape.radius
            is Shape.Square -> shape.sideLength
        }
    }
    println(size(circle1))
    println(size(square2))

    val mazda = CarAdvanced("Mazda")
    val mazdaEngine = mazda.Engine("rotary")
    println(mazdaEngine)

    val privilegedUser = PrivilegedUser(username = "sashinka", id = "1234", age = 21)
    val privilege = Privilege(1, "invisibility")
    privilegedUser.addPrivilege(privilege)
    if (privilegedUser.hasPrivilege(1)) {
        println(privilegedUser.about())
    }

    //CHALLENGES
    println("1.")
    val c = C()
    println(c)


    println("2.")
    val a = A()
    println(c as A)
    println(a as? C)


    println("3.")



    println("4.")


}

data class Grade(
    val letter: Char,
    val points: Double,
    val credits: Double
)

open class Person(var firstName: String, var lastName: String) {
    fun fullName() = "$firstName $lastName"
}

open class StudentAdvanced(
    firstName: String, lastName: String,
    var grades: MutableList<Grade> = mutableListOf<Grade>()
) : Person(firstName, lastName) {
    open fun recordGrade(grade: Grade) {
        grades.add(grade)
    }
}

open class BandMember(
    firstName: String,
    lastName: String
) : StudentAdvanced(firstName, lastName) {
    open val minumumPracticeTime: Int
        get() {
            return 2
        }
}

class oboePlayer(
    firstName: String,
    lastName: String
) : BandMember(firstName, lastName) {
    override val minumumPracticeTime: Int =
        super.minumumPracticeTime * 2
}

open class StudentAthlete(
    firstName: String,
    lastName: String
) : StudentAdvanced(firstName, lastName) {
    val failedClasses = mutableListOf<Grade>()

    override fun recordGrade(grade: Grade) {
        super.recordGrade(grade)

        if (grade.letter == 'F') {
            failedClasses.add(grade)
        }
    }

    val isEligible: Boolean
        get() = failedClasses.size < 3
}

abstract class Mammal(val birthDate: String) {
    abstract fun consumeFood()
}

class Human(birthDate: String) : Mammal(birthDate) {
    override fun consumeFood() {

    }

    fun createBirthCertificate() {

    }
}

sealed class Shape {
    class Circle(val radius: Int) : Shape()
    class Square(val sideLength: Int) : Shape()
}

class CarAdvanced(val carName: String) {
    inner class Engine(val engineName: String) {
        override fun toString(): String {
            return "$engineName in a $carName"
        }
    }
}

data class Privilege(val id: Int, val name: String)

open class User(
    val username: String,
    private val id: String,
    protected var age: Int
)

class PrivilegedUser(username: String, id: String, age: Int) : User(username, id, age) {
    private val privileges = mutableListOf<Privilege>()

    fun addPrivilege(privilege: Privilege) {
        privileges.add(privilege)
    }

    fun hasPrivilege(id: Int): Boolean {
        return privileges.map { it.id }.contains(id)
    }

    fun about(): String {
        return "$username, $age"
    }
}

//CHALLENGES
//1.
open class A {
    init {
        println("I'm A!")
    }
}

open class B : A() {
    init {
        println("I'm B!")
    }
}

class C : B() {
    init {
        println("I'm C!")
    }
}

//3.
class StudentBaseballPlayer(firstName: String, lastName: String, position: String, number: Int, battingAverage: Double) :
    StudentAthlete(firstName, lastName)

//4.
sealed class Resource{
    class Success(val data: String)
    class Loading()
    class Error(val error: String)
}