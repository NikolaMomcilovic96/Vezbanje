fun main(){
    val myFavoriteSong: String? = null

    val parsedInt = "10".toIntOrNull()
    println(parsedInt)

    if(myFavoriteSong != null){
        println(myFavoriteSong)
    }else{
        println("I don't have a favorite song.")
    }


    //CHALLENGE

    //2
    fun divideIfWhole(number: Int, divider: Int): Int? {
        val answer: Int
        return if(number % divider == 0){
            answer = number / divider
            println("Yep, it divides $answer times")
            answer
        }else{
            println("Not divisible :[")
            null
        }
    }
    divideIfWhole(10,2)

    /*
    fun divideIfWhole(value: Int, divisor: Int): Int? {
        return if (value%divisor==0){
            value/divisor
        }else{
            null
        }
    }
    var answer = divideIfWhole(10, 2)
    if (answer != null){
        println("Yep, it divides $answer times")
    }else{
        println("Not divisible :[")
    }
    */

    //3
    val answer1 = divideIfWhole(10, 2) ?: 0
    println("It divides $answer1 times")

    val answer2 = divideIfWhole(10, 3) ?: 0
    println("It divides $answer2 times")
}