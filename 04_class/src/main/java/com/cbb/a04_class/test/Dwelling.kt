package com.cbb.a04_class.test

import kotlin.math.PI
import kotlin.math.sqrt

/**
 * 抽象类
 */
abstract class Dwelling(private var residents: Int) {
    abstract val buildingMaterial: String
    abstract val capacity: Int

    fun hasRoom(): Boolean {
        return residents < capacity
    }

    abstract fun floorArea(): Double


    fun getRoom() {
        if (capacity > residents) {
            residents++
            println("You get a room!")
        } else {
            println("Sorry,at capacity and no rooms left.")
        }
    }

}

class SquareCabin(residents: Int, val length: Double) : Dwelling(residents) {
    override val buildingMaterial: String = "Wood"
    override val capacity: Int = 6
    override fun floorArea(): Double {
        return length * length
    }

}

open class RoundHut(residents: Int, val radius: Double) : Dwelling(residents) {
    override val buildingMaterial: String = "Straw"
    override val capacity: Int = 4
    override fun floorArea(): Double {
        return PI * radius * radius
    }

    fun calculateMaxCarpetSize(): Double {
        val diameter = 2 * radius
        return sqrt(diameter * diameter / 2)
    }

}

class RoundTower(
    residents: Int,
    radius: Double,
    val floors: Int = 2
) : RoundHut(residents, radius) {
    override val buildingMaterial = "Stone"
    override val capacity = 4 * floors

    override fun floorArea(): Double {
        return super.floorArea() * floors
    }


}

fun main() {
    var squareCabin = SquareCabin(3, 50.0)
    /**
     * with 函数
     */
    with(squareCabin) {
        println("\nSquare Cabin\n============")
        println("Capacity: $capacity")
        println("Material: $buildingMaterial")
        println("Has room? ${hasRoom()}")
        println("Floor area: %.2f".format(floorArea()))
    }

    var roundHut = RoundHut(3, 10.0)
    with(roundHut) {
        println("\nRound Hut\n============")
        println("Capacity: $capacity")
        println("Material: $buildingMaterial")
        println("Has room? ${hasRoom()}")
        getRoom()
        println("Has room? ${hasRoom()}")
        getRoom()
        println("Floor area: %.2f".format(floorArea()))
        println("Floor area: %.2f".format(calculateMaxCarpetSize()))
    }

    var roundTower = RoundTower(4, 15.5)
    with(roundTower) {
        println("\nRound Tower\n============")
        println("Capacity: $capacity")
        println("Material: $buildingMaterial")
        println("Has room? ${hasRoom()}")
        println("Floor area: %.2f".format(floorArea()))
        println("Floor area: %.2f".format(calculateMaxCarpetSize()))
    }
}