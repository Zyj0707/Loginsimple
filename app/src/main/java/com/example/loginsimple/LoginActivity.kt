package com.example.loginsimple

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.main_activity.*;

/**
 * Created by 张垚杰 on 2018/1/15.
 */
class LoginActivity : BaseActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        //用Lambda
//        login.setOnClickListener { v ->
//            val account = login_name.text.toString()
//            val password = login_passww.text.toString()
//            if (account =="admin" && password== "123") {//Kotlin中 == 操作符 已经调用equals函数
//                val intent = Intent()
//                startActivity(intent)
//                finish()
//            } else {
//                Toast.makeText(this@LoginActivity, "account or password is error", Toast.LENGTH_SHORT).show()
//            }
//        }
        //kotlin写法

        login.setOnClickListener{
            val account = login_name.text.toString()
            val password = login_passww.text.toString()
            if (account=="admin" && password == "123") {
                val intent = Intent(this@LoginActivity,HomeActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this@LoginActivity, "account or password is error", Toast.LENGTH_SHORT).show()
            }
        }

    }
}