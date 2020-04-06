package com.simple.base

/**
 * Created by zsg on 2020-04-05.
 * Desc:
 *
 */
interface BaseView<T> {

    fun getPresenter(): T
}