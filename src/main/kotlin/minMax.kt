fun main(){
    val numbers = arrayOf(1,4,23,9,11)

    fun minMax(numbers: Array<Int>) : Int? {
        var min = numbers[0]
        var max = 0

        for (n in numbers){
            if (min > n){
                min = n
            }
            if (max < n){
                max = n
            }
        }
        println("Min: $min , Max: $max")
        return null
    }
    minMax(numbers)

    //
    val array = arrayOf(9,3,22,97,85,3)

    fun removingOnce(item: Int, array: Array<Int>): List<Int>{
        val length = array.count()
        val list = array.toMutableList()
        for (i in 0 until length){
            if (i == item){
                list.remove(i)
            }
        }
        return list
    }
    println(removingOnce(3, array))

    val brojevi = arrayOf(1,2,3,4,5)
    fun reverse(array: Array<Int>): Array<Int>{
        val newArray = Array(array.size){0}
        val length = array.count()-1
        var index = 0
        for (i in length downTo 0){
            newArray[index] = array[i]
            index += 1
        }
        return newArray
    }
    val newArray = reverse(brojevi)
    println(newArray.joinToString())


    val lista = listOf(1,2,3,4,5,6,7,8,9,10)
    fun middle(lista: List<Int>): Int?{
        if(lista.isEmpty()){
            println("List is empty")
            return null
        }else {
            val length = lista.count()
            if (length % 2 == 0) {
                val middle = (length / 2) - 1
                return lista[middle]
            } else if (length % 2 == 1) {
                val middle = (length / 2)
                return lista[middle]
            }
        }
        return null
    }
    println(middle(lista))


    val nizStringova = arrayOf("Nikola", "Aleksandar","Dejan","Sinisa", "Dinosaurusi")
    fun najduziString(array: Array<String>){
        var i = 0
        var najduzi = ""
        while (i < array.size){
            if (array[i] > najduzi){
                println("U ${i+1}. slucaju najduzi string je $najduzi")
                najduzi = array[i]
            }else{
                println("U ${i+1}. slucaju ${array[i]} NIJE DUZI od $najduzi")
            }
            i += 1
        }
        println(najduzi)
    }
    najduziString(nizStringova)


    val numbersArray = arrayOf(1,2,3,4,5,6,7,8,9,10)        //9
    val length = numbersArray.count() - 1

    fun reverse(array: Array<Int>, length: Int) {
        println(array[length])

        if (length > 0) {
            reverse(array, length-1)
        }
    }
    reverse(numbersArray, length)

}