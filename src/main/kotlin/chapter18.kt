fun main() {
    val names = listOf("Bob", "Caroll", "Ted", "Alice")
    println("Names: ${names.toBulletedList()}")
    val firstName = names.first()
    println(firstName)

    val things = mutableListOf<Any>(1, 2)
    things.add("Steve")
    println("Things: ${things.toBulletedList()}")

    val map = mapOf(
        Pair("one", 1),
        Pair("two", "II"),
        Pair("three", 3.0f)
    )

    val valuesForKeysWithE = map.keys.filter { it.contains("e") }.map { "Values for $it: ${map[it]}" }
    println("Values for keys with E: ${valuesForKeysWithE.toBulletedList()}")
}

interface Map<K, out V> {
    operator fun get(v: @UnsafeVariance V) {

    }
}

fun <T>List<T>.toBulletedList(): String {
    val separator = "\n -"
    return this.map { "$it" }.joinToString(
        separator, prefix = separator
    )
}