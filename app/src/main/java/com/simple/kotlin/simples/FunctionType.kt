package com.simple.kotlin.simples

import okhttp3.Request

/**
 * Created by zsg on 2020-04-06.
 * Desc:
 *
 */
class FunctionType {

    fun main(){
        val call = Call()
        val response = call.excute(Request.Builder().build())
    }



}