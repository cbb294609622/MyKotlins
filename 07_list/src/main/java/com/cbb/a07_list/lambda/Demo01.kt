package com.cbb.a07_list.lambda

fun main() {
    //常规写法
    val triple:(Int) -> Int = {a:Int -> a *3}
    println(triple(5))
    //使用it 代替变量，只能适用于函数只有一个变量的情况下
    val triple1:(Int) -> Int = {it * 3}
    println(triple1(5))

    var peoples = mutableMapOf<String, Int>(
        "Work" to 11,
        "Marry" to 22,
        "Jar" to 33,
        "Mar" to 23
    )
    var filterPeopleName = peoples.filter { it.key.length >= 4 }
    println(filterPeopleName)

    var peopleNames = listOf("Fred", "Ann", "Barbara", "Joe")
    //根据对字符串进行排序
    println(peopleNames.sorted())
    //根据字符串长度进行排序
//    println(peopleNames.sortedWith{str1:String,str2:String -> str1.length - str2.length})


    val words = listOf("about","acute","brief","balloon","Best","cat","dest","event","first",
        "fix","gust","unlock","view","world","xis","year","size")
    //检索出开头为b的字符串，不区分大小写
    var filterWords = words.filter { it.startsWith("b", ignoreCase = true) }
    println(filterWords)
    // shuffled() 函数随机打乱集合中的项并创建集合的副本
    var filterWords1 = words.filter { it.startsWith("b", ignoreCase = true) }
        .shuffled()
    println(filterWords1)
    //获取集合中的前N个项。使过滤后的单词只包含打乱后的前两个单词
    val filterWords2 = words.filter { it.startsWith("b", ignoreCase = true) }
        .shuffled()
        .take(2)
    println(filterWords2)
    val filterWords3 = words.filter { it.startsWith("b", ignoreCase = true) }
        .shuffled()
        .take(2)
        .sorted()//最后排序
    println(filterWords3)

}