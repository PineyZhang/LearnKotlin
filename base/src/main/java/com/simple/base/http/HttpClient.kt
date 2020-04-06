package com.simple.base.http

import android.util.Log
import androidx.annotation.NonNull
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException
import java.lang.reflect.Type

/**
 * Created by zsg on 2020-04-05.
 * Desc: OkHttpClient网络请求单列类
 *
 */
object HttpClient : OkHttpClient() {

    private val gson = Gson()

    @NonNull
    fun <T> convert(json: String?, type: Type): T {
        Log.i("json", json)
        return gson.fromJson(json, type)
    }

    fun <T> get(path: String, type: Type, entityCallback: EntityCallback<T>) {
        val request = Request.Builder()
                .url("https://api.hencoder.com/$path")
                .build()
        val call = this.newCall(request)
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                entityCallback.onFailure("网络异常")
            }

            override fun onResponse(call: Call, response: Response) {
                when (response.code()) {
                    in 200..299 -> entityCallback.onSuccess(convert(response.body()!!.string(), type))
                    in 400..499 -> entityCallback.onFailure("客户端错误")
                    in 500..599 -> entityCallback.onFailure("服务器错误")
                    else -> entityCallback.onFailure("未知错误")
                }
            }

        })
    }
}