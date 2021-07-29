package com.cbb.a02_dict

class Dice(
    val numSides: Int
) {

    //随机产生1-6 之间的一个数字返回
    fun roll(): Int = (1..numSides).random()

}