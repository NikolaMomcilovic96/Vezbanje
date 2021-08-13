fun main(){
    val multiplyLambda = {a: Int, b: Int -> Int
        a * b
    }
    val multiplyResult = multiplyLambda(4,2)
    println(multiplyResult)
    println("----------------------")

    val doubleLambda = {a: Int ->
        2 * a
    }
    val doubleResult = (doubleLambda(3))
    println(doubleResult)
    println("----------------------")

    val squareLambda = {a: Int ->
        a * a
    }
    val squareResult = squareLambda(3)
    println(squareResult)
    println("----------------------")

    fun operateOnNumbers(a: Int, b: Int, operation: (Int, Int) -> Int): Int{
        val result = operation(a,b)
        println(result)
        return result
    }
    val addLambda = {a: Int, b: Int ->
        a + b
    }
    operateOnNumbers(4,2,operation = addLambda)
    println("----------------------")

    val names = arrayOf("ZZZZZZ", "BB", "A", "CCCC", "EEEEE")
    val namesByLength = names.sortedWith(compareBy{
        -it.length
    })
    println(namesByLength)
    println("----------------------")

    val values = listOf(1,2,3,4,5,6)
    values.forEach{
        println("$it: ${it * it}")
    }
    println("----------------------")

    val prices = listOf(1.5, 10.0, 4.99, 2.30, 8.19)
    val largerPrices = prices.filter {
        it > 5
    }
    println(largerPrices)
    println("----------------------")

    val salesPrices = prices.map {
        it * 0.9
    }
    println(salesPrices)
    println("----------------------")

    val strings = prices.map {
        it.toString()
    }
    println(strings)
    println("----------------------")

    val userInput = listOf("0", "11", "haha", "42")
    val numbers = userInput.map {
        it.toIntOrNull()
    }
    println(numbers)
    println("----------------------")

    val onlyNumbers = userInput.mapNotNull {
        it.toIntOrNull()
    }
    println(onlyNumbers)
    println("----------------------")

    val sum = prices.fold(0.0) { a, b ->
        a + b
    }
    println(sum)
    println("----------------------")


    //MINI EXERCISE
    //1
    val nameList = listOf("Nikola", "Jelena", "Tamara", "Petar", "Ana")
    val concatenation = nameList.fold(""){a, b ->
        a + b
    }
    println(concatenation)
    println("----------------------")

    //2
    val filterConcatenation = nameList.filter { it.count() > 3 }.fold(""){a, b ->
        a + b
    }
    println(filterConcatenation)
    println("----------------------")

    //3
    val namesAndAges = mapOf(
        "Nikola" to 24,
        "Aleksandar" to 16,
        "Natasa" to 25,
        "Jovan" to 17
    )
    val filterNamesAndAges = namesAndAges.filter { it.value < 18 }
    println(filterNamesAndAges)
    println("----------------------")

    //4
    val overAged = namesAndAges.filter { it.value > 18 }.map { it.key }
    println(overAged)
    println("----------------------")


    //CHALLENGES
    println("CHALLENGES")

    //1
    val task: () -> Unit = {
        println("Kotlin Apprentice is a great book")
    }
    fun repeatTask(times: Int, task: () -> Unit){
        for (i in 0 until times) {
            task()
        }
    }
    repeatTask(10, task)

    /*  repeatTask(10){
            println("Kotlin Apprentice is a great book")
        }
     */
    println("----------------------")

    //2
    fun mathSum(length: Int, series: (Int) -> Int) : Int{
        var result = 0
        for (i in 0..length){
            result += series(i)
        }
        return result
    }
    println(mathSum(10){it * it})

    fun fibonacci(number: Int): Int{
        if(number <= 0){
            return 0
        }
        if (number == 1 || number == 2){
            return 1
        }
        return fibonacci(number - 1) + fibonacci(number - 2)
    }
    println(mathSum(10, ::fibonacci))
    println("----------------------")

    //3
    val appRatings = mapOf(
        "Calendar Pro" to arrayOf(1, 5, 5, 4, 2, 1, 5, 4),
        "The Messenger" to arrayOf(5, 4, 2, 5, 4, 1, 1, 2),
        "Socialise" to arrayOf(2, 1, 2, 2, 1, 2, 4, 2)
    )
    val averageRatings = mutableMapOf<String, Double>()
    appRatings.forEach{
        val total = it.value.reduce(Int::plus)
        averageRatings[it.key] = total.toDouble() / it.value.size
    }
    println(averageRatings)
    val goodApps = averageRatings.filter {
        it.value > 3
    }.map {
        it.key
    }
    println(goodApps)
}