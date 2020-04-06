package com.simple.base.utils

import android.content.Context
import com.simple.base.BaseApplication
import com.simple.base.R

/**
 * Created by zsg on 2020-04-05.
 * Desc: object 定义的静态方法工具类
 *
 */
object CacheUtils {

    private val context = BaseApplication.currentApplication

    private val SP = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE);

//    fun save(key: String, value: String?) {
//        SP.edit().putString(key, value).apply()
//    }

//    fun get(key: String?): String? {
//        return SP.getString(key, null)
//    }
    /**
     * 简化版本
     */
    fun save(key: String, value: String?) = SP.edit().putString(key, value).apply()

    fun get(key: String?) = SP.getString(key, null)

}