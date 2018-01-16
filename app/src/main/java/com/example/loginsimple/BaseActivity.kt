package com.example.loginsimple

import android.content.*
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast

/**
 * Created by 张垚杰 on 2018/1/15.
 */
open class BaseActivity : AppCompatActivity() {
    private var receiver: ForceOfflineReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityCollector.addActivity(this)
    }

    override fun onResume() {
        super.onResume()
        Log.i("onResume","start")
        val intentFilter = IntentFilter()
        intentFilter.addAction("com.example.broadcastbestpractice.FORCE_OFFLINE")
        receiver = ForceOfflineReceiver()
        registerReceiver(receiver, intentFilter)

    }

    override fun onPause() {
        super.onPause()
        Log.i("onPause","start")
        if(receiver != null){
            unregisterReceiver(receiver)
            receiver =null
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityCollector.removeActivity(this)
    }

    internal inner class ForceOfflineReceiver : BroadcastReceiver() {

        override fun onReceive(context: Context, intent: Intent) {
            val builder = AlertDialog.Builder(context)
            builder.setTitle("Warning!!")
            builder.setMessage("You are forced to be offline. Please try to login again.")
            builder.setCancelable(false)
            builder.setPositiveButton("OK") { dialog, which ->
                ActivityCollectorJava.finishAll()
                val intent1 = Intent(context, LoginActivityJava::class.java)
                context.startActivity(intent1)
            }
            builder.show()
            Toast.makeText(context,"receiver",Toast.LENGTH_SHORT).show()
        }
    }
//
//    private var receiver: ForceOfflineReceiver? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        ActivityCollector.addActivity(this)
//    }
//
//
//    override fun onPause() {
//        super.onPause()
//        if (receiver != null) {
//            unregisterReceiver(receiver)
//            receiver = null
//        }
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        ActivityCollector.removeActivity(this)
//    }
//
//    internal inner class ForceOfflineReceiver : BroadcastReceiver() {
//
//        override fun onReceive(context: Context, intent: Intent) {
//            val builder = AlertDialog.Builder(context)
//            builder.setTitle("Warning!!!(kotlin)")
//            builder.setMessage("You are forced to be offline. Please try to login again.")
//            builder.setCancelable(false)
//            builder.setPositiveButton("OK") { dialog, which ->
//                ActivityCollectorJava.finishAll()
//                val intent1 = Intent(context, LoginActivityJava::class.java)
//                context.startActivity(intent1)
//            }
//            builder.show()
//            Toast.makeText(context, "receiver", Toast.LENGTH_SHORT).show()
//        }
//    }
}