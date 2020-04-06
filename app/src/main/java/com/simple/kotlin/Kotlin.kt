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

    val userCopy = user.copy()

    println(userCopy == user)

    println(userCopy === user)

    /**
     * 用data class 修饰的类，可以解构（destructing）类的构造方法里面的参数
     * 反之，如果没有写data class的类要支持解构，需要自己给类重写component方法
     */
    var (username, password, code) = User("zsg test", "password", "hello")


    /**
     * 循环100次
     */
    repeat(100) {
        println(it)
    }


    val arrayOf = arrayOf(1, 2, 3, 4, 5)
    /**
     * 遍历数组
     */
    for (arrayOf in arrayOf.indices){

    }

}

fun doubleNumber(x: Int): Int {
    return x * 2
}