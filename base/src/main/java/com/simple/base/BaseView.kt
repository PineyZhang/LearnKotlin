package com.simple.base

/**
 * Created by zsg on 2020-04-05.
 * Desc:
 *
 */
interface BaseView<T> {

//    fun getPresenter(): T
    /**
     * 简化成接口属性的方式
     */
    val presenter: T
}