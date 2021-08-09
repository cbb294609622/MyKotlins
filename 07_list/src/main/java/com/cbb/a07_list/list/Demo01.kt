package com.cbb.a07_list.list


fun main() {
    val numbers = listOf(0, 1, 2, 3, 2, 4, 7, 5, 9, 6)
    println("$numbers")
    println("${numbers.sorted()}")

    val numSet = numbers.toSet()
    println("$numSet")

    val set1 = setOf(1, 2, 3)   //不可变
    var set2 = mutableSetOf(1, 2, 3)//可变
    println("$set1 == $set2 ： ${set1 == set2}")

    var peopleAges = mutableMapOf<String, Int>(
        "Fred" to 22,
        "Ann" to 24,
        "Arr" to 35
    )
    peopleAges["work"] = 33
    println(peopleAges)
    peopleAges.forEach{
        print("${it.key} = ${it.value},")
    }
    println()
    //根据表达式返回集合中的匹配项
    val filterNames = peopleAges.filter { it.key.length < 4 }
    println(filterNames)
}