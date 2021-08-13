fun main(){
    val intArray = arrayOf(5,6,2,8,3,2,7,6,4,5,5)
    val stringArray = arrayOf("Nokia","Samsung","Google","Apple","Google")

    fun checkElement(arrayList: List<Int>, number: Int): Boolean{
        for (item in arrayList) {
            if (number == item) {
                return true
            }
        }
        return false
    }

    fun removeDuplicate(array: Array<Int>) {
        println("Originalni niz: ${array.toList()} ")
        val noDuplicates: ArrayList<Int> = ArrayList()

        for(i in array){
            val hasDuplicate = checkElement(noDuplicates, i)
            println("found $hasDuplicate")
            if (!hasDuplicate){
                noDuplicates.add(i)
            }
        }
        println(noDuplicates)


    }
    removeDuplicate(intArray)




}