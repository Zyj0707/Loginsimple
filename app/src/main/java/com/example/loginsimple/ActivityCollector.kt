package com.example.loginsimple

import android.app.Activity

/**
 * Created by 张垚杰 on 2018/1/15.
 */
object  ActivityCollector {
    var activityList = arrayListOf<Activity>()// like ArrayList as Java

    fun addActivity(activity: Activity){
        activityList.add(activity)
        activityList
    }

    fun removeActivity(activity: Activity){
        activityList.remove(activity)
    }

    fun finishAll(){
        for(activity in activityList){
            if(!activity.isFinishing){
                activity.finish()
            }
        }
    }

}