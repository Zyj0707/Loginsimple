package com.example.loginsimple

import android.content.Intent
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.home_main.*
import kotlinx.android.synthetic.main.main_activity.*

/**
 * Created by 张垚杰 on 2018/1/16.
 */
class HomeActivity :BaseActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_main)
        home_bt.setOnClickListener{
            Log.i("bt","submit")
            val intent = Intent("com.example.broadcastbestpractice.FORCE_OFFLINE")
            sendBroadcast(intent)
        }
    }
}