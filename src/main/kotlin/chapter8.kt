import java.util.Random

fun main() {
    val wishlist = mutableListOf("shoes", "google home", "ikea tradfri", "smartwatch")

    if (wishlist.isEmpty()) {
        println("Your list is empty")
    } else {
        if (wishlist.size < 3) {
            println("You need at least 3 items")
        } else {
            println(wishlist.last())
        }
    }

    val arrayOfNumbers = mutableListOf(1, 2, 3)
    for (i in 4..10) {
        arrayOfNumbers.add(i)
    }
    println(arrayOfNumbers.joinToString())
    println(arrayOfNumbers.indexOf(3))

    fun listSums(list: List<Int>): Int {
        var sum = 0
        for (value in list) {
            sum += value
        }
        return sum
    }

    val list = listOf(1, 2, 3, 4, 5, 6)
    val result = listSums(list)
    println(result)


    fun printScoresAndPlayers(players: List<String>, scores: List<Int>) {
        if (scores.count() == players.count()) {
            for ((index,player) in players.withIndex()) {
                println("${index + 1}. $player ${scores[index]}")
            }
        }
        else{
            println("Number of players and scores has to be the same!")
        }
    }
    val players = listOf("Nikola", "Jelena", "Petar", "Tamara")
    val scores = listOf(21, 9, 14, 6)
    printScoresAndPlayers(players, scores)


    //CHALLENGE

    //1
    fun removeOne(item: Int, lista: List<Int>): List<Int>{
        val mutableList = lista.toMutableList()
        for (value in mutableList){
            if(value == item){
                mutableList.remove(value)
                break
            }else{
                continue
            }
        }
        return mutableList.toList()

        /*
        val mutableList = lista.toMutableList()
        mutableList.remove(item)
        return mutableList.toList()
         */
    }
    val lista = listOf(55, 32, 12, 35, 76, 12)
    val newList = removeOne(12, lista)
    println(newList.joinToString())

    //2
    fun remove(item: Int, brojevi: List<Int>): List<Int>{
        val mutableList = brojevi.toMutableList()
        while (item in mutableList)
                mutableList.remove(item)
        return mutableList.toList()
    }
    val brojevi = listOf(12, 13, 15, 18, 13)
    val newBrojevi = remove(13, brojevi)
    println(newBrojevi.joinToString())

    //3
    fun reverse(array: Array<Int>): Array<Int> {
        val newArray = Array(array.size) { 0 }
        for (i in array.indices) {
            newArray[i] = array[array.size - i - 1]
        }
        return newArray
    }
    val array = arrayOf(1,2,3,4,5)
    val newArray = reverse(array)
    println(newArray.joinToString())


    //4
    val random = Random()
    fun rand(from: Int, to: Int): Int{
        return random.nextInt(to-from) + from
    }
    fun randomized(array: Array<Int>): Array<Int>{
        val newArray2 = Array(array.size) { 0 }
        val usedIndices = mutableListOf<Int>()

        for (i in array.indices){
            var randomIndex: Int
            while (true){
                randomIndex = rand(0, array.size)
                if (randomIndex !in usedIndices){
                    usedIndices.add(randomIndex)
                    break
                }
            }
            newArray2[i] = array[randomIndex]
        }
        return newArray2
    }
    val array2 = arrayOf(0,1,2,3,4,5,6,7,8,9)
    val newArray2 = randomized(array2)
    println(newArray2.joinToString())


    //5
    //NE RADI
    fun minMax(numbers: Array<Int>): Pair<Int, Int>? {
        var maxValue = Int.MAX_VALUE
        var minValue = Int.MIN_VALUE
        if(numbers.isEmpty()){
            return null
        }else{
            for (number in numbers){
                if (number < minValue){
                    minValue = number
                }
                if (number > maxValue){
                    maxValue = number
                }
            }
        }
        return Pair(maxValue, minValue)
    }
    val numbers = arrayOf(4,6,8,-2,23,-5,11)
    val minMax = minMax(numbers)
    println(minMax?.first)
    println(minMax?.second)

    //RADI
    fun minMax2(numbers: Array<Int>): Pair<Int, Int>? {
        if (numbers.isEmpty()) return null
        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE
        for (number in numbers) {
            if (number < min) {
                min = number
            }
            if (number > max) {
                max = number
            }
        }
        return Pair(min, max)
    }
    val integers = arrayOf(4, -54, -300, 23, 55666, 22, 1, -2223, 33, 11, 500000)
    val minMax2 = minMax2(integers)
    println(minMax2?.first)
    println(minMax2?.second)


}