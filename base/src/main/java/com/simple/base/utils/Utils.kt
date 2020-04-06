@file:JvmName("KotlinUtils")
package com.simple.base.utils

import android.content.res.Resources
import android.util.TypedValue
import android.widget.Toast
import com.simple.base.BaseApplication

/**
 * Created by zsg on 2020-04-05.
 * Desc: 包级函数静态方法
 *
 */
private val displayMetrics = Resources.getSystem().displayMetrics

fun dp2px(dp: Float): Float {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics)
}

object Utils {

    fun toast(string: String?) {
        toast(string, Toast.LENGTH_SHORT)
    }

    fun toast(string: String?, duration: Int) {
        Toast.makeText(BaseApplication.currentApplication(), string, duration).show()
    }
}
