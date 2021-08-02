package com.cbb.a06_affirmations.test


fun main() {
    //可读不可写
    val number = listOf(1,2,3,4,5)
    println("$number")
    println("${number.size}")

    val entrees = mutableListOf(1,2,3,4,5)
    println("$entrees")
    println("${entrees.size}")
    entrees.add(6)
    println("$entrees")
    println("${entrees.size}")

    for (i in entrees){
        print(i)
    }
    println()

}