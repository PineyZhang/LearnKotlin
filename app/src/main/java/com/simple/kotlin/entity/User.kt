package com.simple.kotlin.entity

/**
 * Created by zsg on 2020-04-05.
 * Desc: 在类名上定义 主构造函数
 * plus版：
 * data class 声明的类，会给类生成copy函数，生成一个新的对象
 */
data class User constructor(var username: String?, var password: String?, var code: String?) {

    /**
     * 调用主构造函数，参数传空
     */
    constructor() : this(null, null, null)

}
