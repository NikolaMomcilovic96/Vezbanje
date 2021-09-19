fun main() {
    val nikolaData = mutableMapOf<String, String>()

    nikolaData.put("firstName", "Nikola")
    nikolaData.put("lastName", "Momcilovic")
    nikolaData["address"] = "Svetozara Markovica 9"
    nikolaData["state"] = "Kaludjerica"
    nikolaData.put("worksAt", "Consulteer")
    nikolaData.put("years", "25")

    fun printAddressAndState(person: MutableMap<String, String>) {
        println(person["address"])
        println(person["state"])
    }
    printAddressAndState(nikolaData)

    nikolaData["address"] = "Save Kovacevica 9"
    nikolaData["city"]="Belgrade"

    val pair = "nickname" to "Momcha"

    nikolaData += pair

    nikolaData.remove("city", "Kragujevac")

    for ((field, data) in nikolaData){
        println("$field : $data")
    }

    println("==============================")
    println("==========CHALLENGES==========")
    //CHALLENGES

    //1
    val states = mapOf(
        "NY" to "New York",
        "CA" to "California"
    )
    fun printStates(states: kotlin.collections.Map<String, String>){
        for ((index, value) in states){
            val nameLength = value.length

            if(nameLength > 8){
                println(value)
            }
        }
    }
    printStates(states)

    //2
    fun mergeMaps(map1: kotlin.collections.Map<String, String>, map2: kotlin.collections.Map<String, String>) : MutableMap<String, String> {
        val newMap = mutableMapOf<String, String>()

        for ((mapOneIndex, mapOneValue) in map1){
            newMap[mapOneIndex] = mapOneValue
            for ((mapTwoIndex, mapTwoValue) in map2){
                if (mapOneIndex != mapTwoIndex){
                    newMap[mapTwoIndex] = mapTwoValue
                }
            }
        }
        return newMap
    }
    val map1 = mapOf(
        "1" to "2",
        "2" to "2"
    )
    val map2 = mapOf(
        "1" to "1",
        "3" to "3"
    )
    println(mergeMaps(map1, map2))

    //3
    fun occurrencesOfCharacters(text: String): MutableMap<Char, Int> {
        val numberOfChars = mutableMapOf<Char, Int>()

        for (character in text){
            val count = numberOfChars.getOrDefault(character, 0)
            numberOfChars[character] = count + 1
        }
        return numberOfChars
    }
    val text = "I'm your huckleberry."
    println(occurrencesOfCharacters(text))

    //4
    fun isInvertible(map: kotlin.collections.Map<String, Int>) = map.values.toSet().size == map.values.size
    val invertibleMap = mapOf("1" to 1, "2" to 2, "3" to 3)
    println(isInvertible(invertibleMap))

    val nonInvertibleMap = mapOf("1" to 3, "2" to 2, "3" to 3)
    println(isInvertible(nonInvertibleMap))

    //5
    val nameTitleLookup: MutableMap<String, String?> = mutableMapOf(
        "Mary" to "Engineer",
        "Patrick" to "Intern",
        "Ray" to "Hacker"
    )
    nameTitleLookup["Patrick"] = null
    nameTitleLookup.remove("Ray")
    println(nameTitleLookup)
}
