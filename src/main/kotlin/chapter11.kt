import kotlin.random.Random
import java.util.*
import kotlin.math.pow

class Person(var firstName: String, var lastName: String) {
    val fullName
        get() = "$firstName $lastName"
}

class Grade(
    val letter: String,
    val points: Double,
    val credits: Double
)

class Student(
    val firstName: String,
    val lastName: String,
    val grades: MutableList<Grade> = mutableListOf(),
    var credits: Double = 0.0
) {
    fun recordGrades(grade: Grade) {
        grades.add(grade)
        credits += grade.credits
    }
}

fun main() {
    val john = Person("Nikola", "Momcilovic")

    //MINI EXERCISE
    val homeOwner = john
    john.firstName = "John"
    homeOwner.lastName = "Johnson"

    println(homeOwner.firstName)
    println(homeOwner.lastName)
    println(john.firstName)
    println(john.lastName)
    println(homeOwner === john)

    //val jane = Student(firstName = "Jane", lastName = "Appleseed")
    //val history = Grade(letter = "B", points = 9.0, credits = 3.0)
    //val math = Grade(letter = "A", points = 16.0, credits = 4.0)

    //jane.recordGrades(history)
    //jane.recordGrades(math)

    var imposters = (0..100).map {
        Person(firstName = "John", lastName = "Appleseed")
    }

    imposters.map {
        it.firstName == "John" && it.lastName == "Appleseed"
    }.contains(true)

    println(imposters.contains(john))

    val mutableImposters = mutableListOf<Person>()
    mutableImposters.addAll(imposters)
    mutableImposters.contains(john)
    mutableImposters.add(java.util.Random().nextInt(5), john)

    println(mutableImposters.contains(john))

    val indexOfJohn = mutableImposters.indexOf(john)
    if (indexOfJohn != -1) {
        mutableImposters[indexOfJohn].lastName = "Bananapeel"
    }

    println(john.fullName)

    //MINI-EXERCISE
    println("MINI EXERCISE")
    fun memberOf(person: Person, group: Array<Person>): Boolean {
        return group.contains(person)
    }

    val groupWithJohn = arrayOf(
        Person("A", "B"),
        Person("C", "D"),
        john,
        Person("E", "F"),
        Person("G", "H")
    )

    val groupWithoutJohn = arrayOf(
        Person("A", "B"),
        Person("C", "D"),
        Person("E", "F"),
        Person("G", "H"),
        Person("I", "J")
    )

    println(memberOf(john, groupWithJohn))
    println(memberOf(john, groupWithoutJohn))

    //Methods and mutability
    class Grade(
        val letter: String,
        val points: Double,
        val credits: Double
    )

    class Student(
        val firstName: String,
        val lastName: String,
        val grades: MutableList<Grade> = mutableListOf(),
        var credits: Double = 0.0
    ){
        val gpa: Double
        get(){
            var totalPoints = 0.0
            grades.forEach{
                totalPoints += it.points
            }
            return totalPoints/credits
        }
        fun recordGrade(grade: Grade){
            grades.add(grade)
            credits += grade.credits
        }
    }

    val jane = Student(firstName = "Jane", lastName = "Appleseed")
    val history = Grade(letter = "B", points = 9.0, credits = 3.0)
    val math = Grade(letter = "A", points = 16.0, credits = 4.0)

    jane.recordGrade(history)
    jane.recordGrade(math)

    println(jane.gpa)
}
