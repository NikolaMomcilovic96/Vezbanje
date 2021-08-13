fun main() {
    val arrayOne = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val arrayTwo = arrayOf(11, 12, 13, 14, 15, 16, 17, 18, 19, 20)

    /*
    fun reverseArray(arrayTwo: Array<Int>): Array<Int>{
        var index = 0

        val newArrayTwo = Array(10, {0})
        for (i in (arrayTwo.count()-1) downTo 0){
            newArrayTwo[index] = arrayTwo[i]
            index += 1
        }
        return newArrayTwo
    }
    val newArrayTwo = reverseArray(arrayTwo)

    fun orderingArrays(arrayOne: Array<Int>, arrayTwo: Array<Int>){
        val finalArray = Array(20, {0})
        val finalLength = (arrayOne.count() + arrayTwo.count())/2
        var i = 0
        var index = 0
        while (i < finalLength){
            finalArray[index] = arrayOne[i]
            finalArray[index+1] = arrayTwo[i]
            i += 1
            index += 2
        }
        println(finalArray.toList())
    }
    orderingArrays(arrayOne, newArrayTwo)
*/

    fun printArrays(arrayOne: Array<Int>, arrayTwo: Array<Int>) {
        val lengthOne = arrayOne.count()
        val lengthTwo = arrayOne.count()

        for (i in 0 until lengthOne) {
            print(arrayOne[i])
            println(arrayTwo[lengthOne - 1 - i])
        }
    }
    printArrays(arrayOne, arrayTwo)
}