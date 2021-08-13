class Person(var firstName: String, var lastName: String){
    val fullName
        get()="$firstName $lastName"
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
){
    fun recordGrades(grade: Grade){
        grades.add(grade)
        credits += grade.credits
    }
}
fun main(){
    val john = Person("Nikola", "Momcilovic")

    //MINI EXERCISE
    var homeOwner = john
    john.firstName = "John"
    homeOwner.lastName = "Johnson"

    println(homeOwner.firstName)
    println(homeOwner.lastName)
    println(john.firstName)
    println(john.lastName)
    println(homeOwner===john)

    val jane = Student(firstName = "Jane", lastName = "Appleseed")
    val history = Grade(letter = "B", points = 9.0, credits = 3.0)
    var math = Grade(letter = "A", points = 16.0, credits = 4.0)

    jane.recordGrades(history)
    jane.recordGrades(math)

}