fun main() {
    val spaceCraft = SpaceCraft()
    SpacePort.investigateSpace(spaceCraft)

    println("Test spaceCraft: ${SpacePort.testSetup(spaceCraft)}")
}

class SpaceCraft {
    private var isConnectionAvailable: Boolean = false
    private var isEngineInOrder: Boolean = false
    private var fuel: Int = 0
    var isInSpace: Boolean = false

    fun launch() {
        if (fuel < 5) {
            throw OutOfFuelException()
        }

        if (!isEngineInOrder) {
            throw BrokenEngineException()
        }

        if (!isConnectionAvailable) {
            throw SpaceToEarthConnectionFailedException()
        }

        sendMessageToEarth("Trying to launch...")
        fuel -= 5
        sendMessageToEarth("I'm in space!")
        sendMessageToEarth("I've found some extraterrestrials")
        isInSpace = true
        throw AliensAttackException()
    }

    fun refuel() {
        fuel += 5
        sendMessageToEarth("The fuel tank is filled.")
    }

    fun repairEngine() {
        isEngineInOrder = true
        sendMessageToEarth("The engine is in order.")
    }

    fun fixConnection() {
        isConnectionAvailable = true
        sendMessageToEarth("Hello Earth! Can you hear me?")
        sendMessageToEarth("Connection is established.")
    }

    fun land() {
        sendMessageToEarth("Landing...")
        isInSpace = false
    }

    fun overhaul() {
        if (fuel < 5) {
            refuel()
        }

        if (!isEngineInOrder) {
            repairEngine()
        }

        if (!isConnectionAvailable) {
            fixConnection()
        }
    }

    fun sendMessageToEarth(message: String) = println("Spacecraft to Earth: $message")
}

object SpacePort {
    fun investigateSpace(spaceCraft: SpaceCraft) {
        try {
            spaceCraft.launch()
        } catch (exception: SpaceCraftException) {
            spaceCraft.sendMessageToEarth(exception.localizedMessage)
            spaceCraft.overhaul()
        } catch (exception: AliensAttackException) {
            spaceCraft.sendMessageToEarth(exception.localizedMessage)
        } finally {
            if (spaceCraft.isInSpace) {
                spaceCraft.land()
            } else {
                investigateSpace(spaceCraft)
            }
        }
    }

    fun testSetup(spaceCraft: SpaceCraft) = try {
        spaceCraft.launch()
        true
    } catch (exception: SpaceCraftException) {
        false
    } finally {
        spaceCraft.land()
    }
}

open class SpaceCraftException(message: String) : Exception(message)

class OutOfFuelException : SpaceCraftException("Out of fuel. Can't take off.")

class BrokenEngineException : SpaceCraftException("The engine is broken. Can't take off.")

class SpaceToEarthConnectionFailedException : SpaceCraftException("No connection with Earth. Can't take off.")

class AliensAttackException : Exception("SOS! SOS! Aliens attack!")