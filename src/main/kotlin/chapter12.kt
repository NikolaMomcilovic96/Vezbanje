fun main() {
    val marie = Student(1, "Marie", "Curie")
    val albert = Student(2, "Albert", "Einstein")
    val emmy = Student(3, "Emmy", "Noether")

    StudentRegistry.addStudent(marie)
    StudentRegistry.addStudent(albert)
    StudentRegistry.addStudent(emmy)

    StudentRegistry.listAllStudents()
    println(Student.numberOfStudents())

    val emi = Scientist.newScientist("Emmy", "Noether")
    val isaac = Scientist.newScientist("Isaac", "Newton")
    val tesla = Scientist.newScientist("Nikola", "Tesla")

    ScientistRepository.addScientis(emi)
    ScientistRepository.addScientis(isaac)
    ScientistRepository.addScientis(tesla)

    ScientistRepository.listAllScientists()

    val counter = object : Counts {
        override fun studentCount(): Int {
            return StudentRegistry.allStudents.size
        }

        override fun scientisCount(): Int {
            return ScientistRepository.allScientists.size
        }
    }

    println(counter.studentCount())
    println(counter.scientisCount())


    println("CHALLENGE")
    println("1. zadatak")

    Threshhold.isAboveThreshold(15)

    println("2. zadatak")
    val studentMap = mapOf(
        "first_name" to "Neils",
        "last_name" to "Bohr"
    )
    val student = Student2.loadStudent(studentMap)
    println(student)

    println("3. zadatak")
    val threshold = object : ThresholdChecker {
        override val upper = 10
        override val lower = 7

        override fun isLit(value: Int) = value > upper
        override fun tooQuiet(value: Int) = value <= lower
    }

    if (threshold.isLit(6)) {
        println("Over upper threshold.")
    } else {
        println("Good. It's under upper threshold.")
    }

    if (threshold.tooQuiet(6)) {
        println("It's under lower threshold.")
    } else {
        println("Good. It's above lower threshold.")
    }
}

data class Student(
    val id: Int,
    val firstName: String,
    val lastName: String
) {
    var fullName = "$lastName, $firstName"

    companion object {
        var counter = 0

        fun numberOfStudents() = counter
    }

    init {
        counter += 1
    }
}

object StudentRegistry {
    val allStudents = mutableListOf<Student>()

    fun addStudent(student: Student) {
        allStudents.add(student)
        //numberOfStudents += 1
    }

    fun removeStudent(student: Student) {
        allStudents.remove(student)
    }

    fun listAllStudents() {
        allStudents.forEach {
            println(it.fullName)
        }
        //println("Ukupno ima $numberOfStudents studenta. ")
    }
}

object JsonKeys {
    const val JSON_KEY_ID = "id"
    const val JSON_KEY_FIRSTNAME = "first_name"
    const val JSON_KEY_LASTNAME = "last_name"
}

class Scientist private constructor(
    val id: Int,
    val firstName: String,
    val lastName: String
) {
    companion object {
        var currentId = 0

        fun newScientist(
            firstName: String,
            lastName: String
        ): Scientist {
            currentId += 1
            return Scientist(currentId, firstName, lastName)
        }
    }

    var fullName = "$firstName $lastName"
}

object ScientistRepository {
    val allScientists = mutableListOf<Scientist>()

    fun addScientis(scientist: Scientist) {
        allScientists.add(scientist)
    }

    fun removeScientis(scientist: Scientist) {
        allScientists.remove(scientist)
    }

    fun listAllScientists() {
        allScientists.forEach {
            println("${it.id}: ${it.fullName}")
        }
    }
}

interface Counts {
    fun studentCount(): Int
    fun scientisCount(): Int
}

//CHALLANGE
//1
object Threshhold {
    val threshold = 15

    fun isAboveThreshold(value: Int) {
        if (value > threshold)
            println("Value is above threshold.")
        else if (value < threshold)
            println("Value is under threshold.")
        else
            println("Value is equal to threshold.")
    }
}

//2
data class Student2 private constructor(val firstName: String, val lastName: String){
    companion object {
        fun loadStudent(studentMap: Map<String, String>): Student2 {
            val firstName = studentMap["first_name"] ?: "First"
            val lastName = studentMap["last_name"] ?: "Last"
            return Student2(firstName, lastName)
        }
    }
}

//3
interface ThresholdChecker {
    val lower: Int
    val upper: Int

    fun isLit(value: Int): Boolean
    fun tooQuiet(value: Int): Boolean
}