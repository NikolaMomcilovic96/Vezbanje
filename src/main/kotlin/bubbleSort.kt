fun main(){
    val test1 = arrayOf(5, 7, 3, 6, 8)
    val test2 = arrayOf(5, 5, 5)
    val test3 = arrayOf<Int>()
    val test4 = arrayOf(5, 3, 0, -5)

    fun bubbleSort(test: Array<Int>): Array<Int> {
        val listLength = test.count()
        var swap = true
        while (swap) {
            swap = false
            for (i in 0 until listLength-1) {
                for (j in 1 until listLength-2) {
                    if (test[i] > test[j]) {
                        val temp = test[i]
                        test[i] = test[j]
                        test[j] = temp

                        swap = true
                    }
                }
            }
        }
        return test
    }

    bubbleSort(test1)
    bubbleSort(test2)
    bubbleSort(test3)
    bubbleSort(test4)

    if (test1.isEmpty()) {
        println("Array is empty")
    } else {
        for (i in test1) {
            print("$i ")
        }
    }
    println("")

    if (test2.isEmpty()) {
        println("Array is empty")
    } else {
        for (i in test2) {
            print("$i ")
        }
    }
    println("")

    if (test3.isEmpty()) {
        println("Array is empty")
    } else {
        for (i in test3) {
            print("$i ")
        }
    }
    println("")

    if (test4.isEmpty()) {
        println("Array is empty")
    } else {
        for (i in test4) {
            print("$i ")
        }
    }
    println("")
}