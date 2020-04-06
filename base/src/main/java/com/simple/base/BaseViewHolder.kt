package com.simple.base

import android.view.View
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by zsg on 2020-04-05.
 * Desc: 抽象类继承 Java类，因为显示的定义了constructor所以类名不需要加括号"（）"
 *
 */
abstract class BaseViewHolder : RecyclerView.ViewHolder {

    constructor(@NonNull itemView: View) : super(itemView)

    private val viewHashMap: MutableMap<Int, View?> = HashMap()

    protected open fun <T : View?> getView(@IdRes id: Int): T? {
        var view = viewHashMap[id]
        if (view == null) {
            view = itemView.findViewById(id)
            viewHashMap[id] = view
        }
        return view as T
    }

    protected fun setText(@IdRes id: Int, @Nullable text: String?) {
        getView<TextView>(id)!!.text = text
    }

}