package com.simple.kotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.simple.base.utils.CacheUtils
import com.simple.base.utils.Utils
import com.simple.kotlin.entity.User
import com.simple.kotlin.widget.CodeView
import com.simple.lesson.LessonActivity

/**
 * Created by zsg on 2020-04-05.
 * Desc:
 *
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val usernameKey = "username"
    private val passwordKey = "password"

    private lateinit var et_username: EditText
    private lateinit var et_password: EditText
    private lateinit var et_code: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et_username = findViewById(R.id.et_username)
        et_password = findViewById(R.id.et_password)
        et_code = findViewById(R.id.et_code)

        et_username.setText(CacheUtils.get(usernameKey))
        et_password.setText(CacheUtils.get(passwordKey))

        val btnLogin = findViewById<Button>(R.id.btn_login)
        val codeView = findViewById<CodeView>(R.id.code_view)

        btnLogin.setOnClickListener(this)
        codeView.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v is CodeView) {
            v.updateCode()
        } else {
            login()
        }
    }

    private fun login() {
        val username: String? = et_username.text.toString()
        val password: String? = et_password.text.toString()
        val code: String? = et_code.text.toString()

        val user = User(username,password,code)
        if(verify(user)){
            CacheUtils.save(usernameKey,username)
            CacheUtils.save(passwordKey,password)
            startActivity(Intent(this,LessonActivity::class.java))
        }

    }

    private fun verify(user: User): Boolean {
        if (user.username == null || user.username!!.length < 4) {
            Utils.toast("用户名不合法")
            return false
        }
        if (user.password == null || user.password!!.length < 4) {
            Utils.toast("密码不合法")
            return false
        }

        return true
    }
}