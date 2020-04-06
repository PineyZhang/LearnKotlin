package com.simple.base.http

import androidx.annotation.NonNull
import androidx.annotation.Nullable

/**
 * Created by zsg on 2020-04-05.
 * Desc: 接口类
 *
 */
interface EntityCallback<T> {

    fun onSuccess(@NonNull entity: T)

    fun onFailure(@Nullable message: String?)
}