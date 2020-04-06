package com.simple.base

import android.app.Application
import android.content.Context

/**
 * Created by zsg on 2020-04-05.
 * Desc: 系统自动创建的类，声明静态方法
 *
 * 声明静态方法有三种：
 * 1、包级静态函数（详见：Utils.dp2px ）
 * 2、object关键字声明的类，所有的fun都默认为静态函数（详见：CacheUtils类）
 * 3、companion object 默认会生成一个内部类
 */
class BaseApplication : Application() {

    companion object {

        private lateinit var currentApplication: Context

        // @JvmStatic Java 中调用静态函数
        fun currentApplication(): Context {
            return currentApplication
        }

    }

    override fun onCreate() {
        super.onCreate()
        currentApplication = this
    }
}