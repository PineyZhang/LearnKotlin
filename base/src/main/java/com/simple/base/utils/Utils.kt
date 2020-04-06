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

//fun dp2px(dp: Float): Float {
//    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics)
//}
/**
 * 改成 - 扩展Float类的自定义函数
 */
fun Float.dp2px(): Float {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, displayMetrics)
}

object Utils {

//    fun toast(string: String?) {
//        toast(string, Toast.LENGTH_SHORT)
//    }
//
//    fun toast(string: String?, duration: Int) {
//        Toast.makeText(BaseApplication.currentApplication, string, duration).show()
//    }
    /**
     * 简化成重载方法的形式
     * @JvmOverloads: 生成java调用的重载方法
     */
    @JvmOverloads
    fun toast(string: String?, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(BaseApplication.currentApplication, string, duration).show()
    }
}
