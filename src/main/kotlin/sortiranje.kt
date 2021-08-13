fun main() {
    val numbers = arrayOf(5, 7, 2, 8, 12, 4, 3)
    val sortedArray: ArrayList<Int> = ArrayList()
    val first = 0
    val length = numbers.count()

    fun sorting(array: Array<Int>, first: Int, length: Int) {
        if (array.isEmpty()) {
            println("Niz je prazan")
        } else {
            var najmanji = array[0 + first]
            var newFirst = first

            for (i in newFirst until length) {
                if (najmanji > array[i]) {
                    val temp = array[i]
                    array[i] = najmanji
                    najmanji = temp
                }
            }
            println("Najmanji broj u ${newFirst + 1}. krugu je $najmanji")
            sortedArray.add(najmanji)

            if (newFirst < length - 1) {
                newFirst += 1
                sorting(array, newFirst, length)
            }
        }
    }
    sorting(numbers, first, length)
    println("Sortirani niz: $sortedArray")

}