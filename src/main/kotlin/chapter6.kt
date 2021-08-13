import kotlin.math.sqrt

fun main(){

    fun printFullName(firstName: String, lastName: String){
        println("$firstName $lastName")
    }
    printFullName(firstName = "Nikola", lastName = "Momcilovic")

    fun calculateFullName(firstName: String, lastName: String) : Pair<String, Int>{
        val fullName = firstName + lastName
        return Pair(fullName, fullName.length)
    }
    println(calculateFullName("Nikola", "Momcilovic"))


    //CHALLENGES

    //1
    fun isNumberDivisible(number: Int, divisor: Int): Boolean{
        return number % divisor == 0
    }
    println(isNumberDivisible(231,11))

    fun isPrime(number: Int) : Boolean{
        if (number < 0){
            return false
        }
        if (number <= 3){
            return true
        }
        val doubleNumber = number.toDouble()
        val root = (sqrt(doubleNumber)).toInt()
        for(divisor in 2..root){
            if(isNumberDivisible(number, divisor)){
                return false
            }
        }
        return true
    }
    println(isPrime(13))
    println(isPrime(22))
    println(isPrime(57))
    println(isPrime(58))


    //2
    fun fibonacci(number: Int): Int{
        if(number <= 0){
            return 0
        }
        if (number == 1 || number == 2){
            return 1
        }

        return fibonacci(number - 1) + fibonacci(number - 2)
    }
    println(fibonacci(1))
    println(fibonacci(2))
    println(fibonacci(3))
    println(fibonacci(4))
    println(fibonacci(5))
    println(fibonacci(6))
    println(fibonacci(7))
    println(fibonacci(10))


}


