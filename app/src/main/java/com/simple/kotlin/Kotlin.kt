package com.simple.kotlin

import com.simple.kotlin.entity.User

/**
 * Created by zsg on 2020-04-05.
 * Desc:
 *
 */
fun main() {
    println("Hello World!")

    doubleNumber(1)

    var age = 8
    val name = "Kotlin"

    age = 3

    var user = User()
}

fun doubleNumber(x: Int): Int {
    return x * 2
}