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

    val cheapThings = listOf(
        CheapThing("Cinder Block table"),
        CheapThing("Box of old books"),
        CheapThing("Ugly old couch")
    )
    val cheapMover = Mover(cheapThings)

    cheapMover.moveEverythingToTruck(null)
    cheapMover.moveEverythingIntoNewPlace()
    cheapMover.finishMove()

    val television = BreakableThing("Flat-screen Television")
    val breakableThings = listOf(
        television,
        BreakableThing("Mirror"),
        BreakableThing("Guitar")
    )
    val expensiveMover = Mover(breakableThings)

    expensiveMover.moveEverythingToTruck(CardboardBox())

    television.smash()

    expensiveMover.moveEverythingIntoNewPlace()
    expensiveMover.finishMove()

/*
    fun compare(comparator: Comparable<Number>){
        val int: Int = 1
        comparator.compareTo(int)
        val float: Float = 1.0f
        comparator.compareTo(float)

        val intComparable: Comparable<Int> = comparator
        intComparable.compareTo(int)
        intComparable.compareTo(float)
    }
*/
}


fun <T> List<T>.toBulletedList(): String {
    val separator = "\n -"
    return this.map { "$it" }.joinToString(
        separator, prefix = separator
    )
}

interface Checkable {
    fun checkIsOK(): Boolean
}

class Mover<T : Checkable>(
    thingsToMove: List<T>,
    val truckHeightInInches: Int = (12 * 12)
) {
    private var thingsLeftInOldPlace = mutableListOf<T>()
    private var thingInTruck = mutableListOf<Any>()
    private var thingsInNewPlace = mutableListOf<T>()
    private var thingsWhichFailedCheck = mutableListOf<T>()

    init {
        thingsLeftInOldPlace.addAll(thingsToMove)
    }

    fun moveEverythingToTruck(startingContainer: Container<T>?) {
        while (thingsLeftInOldPlace.isNotEmpty()) {
            var currentContainer = startingContainer
            val item = thingsLeftInOldPlace.removeAt(0)

            if (item.checkIsOK()) {
                if (currentContainer != null) {
                    if (!currentContainer.canAddAnotherItem()) {
                        moveContainerToTruck(currentContainer)
                        currentContainer = currentContainer.getAnother()
                    }
                    currentContainer.addItem(item)
                    println("Packed your $item")
                } else {
                    thingInTruck.add(item)
                    println("Moved your $item to the truck!")
                }
            } else {
                thingsWhichFailedCheck.add(item)
                println("Couldn't move your $item to the truck!")
            }
            currentContainer?.let { it }
        }
    }

    fun moveEverythingIntoNewPlace() {
        val containers = thingInTruck.filterIsInstance<Container<T>>()

        for (container in containers) {
            thingInTruck.remove(container)
            while (container.canRemoveAnotherItem()) {
                val itemInContainer = container.removeItem()
                println("Unpacked your $itemInContainer")
                tryToMoveItemIntoNewPlace(itemInContainer)
            }
        }

        while (thingInTruck.isNotEmpty()) {
            @Suppress("UNCHECKED_CAST")
            val item = thingInTruck.removeAt(0) as? T
            if (item != null) {
                tryToMoveItemIntoNewPlace(item)
            } else {
                println("Something in the truck was not of expected generic type")
            }
        }
    }

    private fun tryToMoveItemIntoNewPlace(item: T) {
        if (item.checkIsOK()) {
            thingsInNewPlace.add(item)
            println("Moved your $item into your new place!")
        } else {
            thingsWhichFailedCheck.add(item)
            println("Couldn't move your $item into your new place!")
        }
    }

    fun finishMove() {
        println("Ok, we finished! We were able to move your: ${thingsInNewPlace.toBulletedList()}")
        if (thingsWhichFailedCheck.isNotEmpty()) {
            println("But we need to talk about your: ${thingsWhichFailedCheck.toBulletedList()}")
        }
    }

    private fun moveContainerToTruck(container: Container<T>) {
        thingInTruck.add(container)
        println("Moved a container with your ${container.contents().toBulletedList()}")
    }
}

class CheapThing(val name: String) : Checkable {
    override fun toString(): String {
        return name
    }

    override fun checkIsOK(): Boolean = true
}

class BreakableThing(
    val name: String,
    var isBroken: Boolean = false
) : Checkable {
    fun smash() {
        isBroken = true
    }

    override fun toString(): String {
        return name
    }

    override fun checkIsOK(): Boolean {
        return !isBroken
    }
}

interface Container<T> {
    fun canAddAnotherItem(): Boolean
    fun addItem(item: T)
    fun canRemoveAnotherItem(): Boolean
    fun removeItem(): T
    fun getAnother(): Container<T>
    fun contents(): List<T>
}

class CardboardBox : Container<BreakableThing> {
    private var items = mutableListOf<BreakableThing>()

    override fun contents(): List<BreakableThing> {
        return items.toList()
    }

    override fun canAddAnotherItem(): Boolean {
        return items.count() < 2
    }

    override fun addItem(item: BreakableThing) {
        items.add(item)
    }

    override fun canRemoveAnotherItem(): Boolean {
        return items.isNotEmpty()
    }

    override fun removeItem(): BreakableThing {
        val lastItem = items.last()
        items.remove(lastItem)
        return lastItem
    }

    override fun getAnother(): Container<BreakableThing> {
        return CardboardBox()
    }
}