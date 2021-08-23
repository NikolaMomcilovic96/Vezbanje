<<<<<<< HEAD
import kotlin.math.pow

=======
>>>>>>> 049335f (Added chapter 12)
class Person(var firstName: String, var lastName: String) {
    val fullName
        get() = "$firstName $lastName"
}

class Grade(
    val letter: String,
    val points: Double,
    val credits: Double
)

<<<<<<< HEAD
class Student(
=======
/*class Student(
>>>>>>> 049335f (Added chapter 12)
    val firstName: String,
    val lastName: String,
    val grades: MutableList<Grade> = mutableListOf(),
    var credits: Double = 0.0
) {
    fun recordGrades(grade: Grade) {
        grades.add(grade)
        credits += grade.credits
    }
<<<<<<< HEAD
}
=======
}*/
>>>>>>> 049335f (Added chapter 12)

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
//    class Grade(
//        val letter: String,
//        val points: Double,
//        val credits: Double
//    )
//
//    class Student(
//        val firstName: String,
//        val lastName: String,
//        val grades: MutableList<Grade> = mutableListOf(),
//        var credits: Double = 0.0
//    ){
//        val gpa: Double
//        get(){
//            var totalPoints = 0.0
//            grades.forEach{
//                totalPoints += it.points
//            }
//            return totalPoints/credits
//        }
//        fun recordGrade(grade: Grade){
//            grades.add(grade)
//            credits += grade.credits
//        }
//    }
//
//    val jane = Student(firstName = "Jane", lastName = "Appleseed")
//    val history = Grade(letter = "B", points = 9.0, credits = 3.0)
//    val math = Grade(letter = "A", points = 16.0, credits = 4.0)
//
//    jane.recordGrade(history)
//    jane.recordGrade(math)
//
//    println(jane.gpa)

    class Student(
        var firstName: String,
        var lastName: String,
        var id: Int
    ){
        override fun hashCode(): Int {
            val prime = 31
            var result = 1

            result = prime * result + firstName.hashCode()
            result = prime * result + id
            result = prime * result + lastName.hashCode()

            return result
        }

        override fun equals(other: Any?): Boolean {
            if (this === other)
                return true

            if (other == null)
                return false

            if (javaClass != other.javaClass)
                return false

            val obj = other as Student?

            if (firstName != obj?.firstName)
                return false

            if (id != obj?.id)
                return false

            if (lastName != obj?.lastName)
                return false

            return true
        }

        override fun toString(): String {
            return "Student (firstName = $firstName, lastName = $lastName, id = $id)"
        }

        fun copy(
            firstName: String = this.firstName,
            lastName: String = this.lastName,
            id: Int = this.id
        ) = Student(firstName, lastName, id)
    }

    val albert = Student(
        firstName = "Albert",
        lastName = "Einstein",
        id = 1
    )
    val richard = Student(
        firstName = "Richard",
        lastName = "Feynman",
        id = 2
    )
    val albertCopy = albert.copy()

    println(albert)

    println(richard)

    println(albert == richard)
    println(albert == albertCopy)
    println(albert === albertCopy)

    data class StudentData(
        var firstName: String,
        var lastName: String,
        var id: Int
    )

    val marie = StudentData("Marie", "Curie", id = 1)
    val emmy = StudentData("Emmy", "Noether", 2)
    val marieCopy = marie.copy()

    println(marie)
    println(emmy)
    println(marie == emmy)
    println(marie == marieCopy)
    println(marie === marieCopy)


    val (firstName, lastName, id) = marie
    println(firstName)
    println(lastName)
    println(id)


    println("CHALLENGES")
    println("1. Movie lists")

    val jane = User()
    val jake = User()
    val actionList = MovieList(name = "Action")

    jake.addList(actionList)
    jane.addList(actionList)

    jane.lists["Action"]?.movies?.add("Rambo")
    jake.lists["Action"]?.movies?.add("Terminator")

    jake.lists["Action"]?.movies?.add("Die Hard")

    jake.lists["Action"]?.print()
    jane.lists["Action"]?.print()


    println("2. T-shirt store")

    val guess = TShirt("L","red",2000.0,"")
    val nikola = Users("Nikola","nikolamomca96@gmail.com", ShopppingCart())
    val address = Address("nikola","Svetozara Markovica 9","Belgrade",11130)
    val korpa = ShopppingCart()
}

class User(
    val lists: MutableMap<String, MovieList> = mutableMapOf()
){
    fun addList(list: MovieList){
        lists[list.name] = list
    }

    fun list(name: String):MovieList?{
        return lists[name]
    }
}
class MovieList(
    val name: String,
    val movies: MutableList<String> = mutableListOf()
){
    fun print(){
        println("Movie list: $name")
        movies.forEach{
            println(it)
        }
    }
}


data class TShirt(
    val size: String,
    val color: String,
    val price: Double,
    val image: String
)

class Users(
    val name: String,
    val email: String,
    val shopppingCart: ShopppingCart
)

data class Address(
    val name: String,
    val street: String,
    val city: String,
    val zipCode: Int
)

class ShopppingCart(
    var list: MutableList<TShirt> = mutableListOf()
){
    fun totalPrice(): Double{
        var total = 0.0
        list.forEach{
            total += it.price
        }
        return total
    }
}
