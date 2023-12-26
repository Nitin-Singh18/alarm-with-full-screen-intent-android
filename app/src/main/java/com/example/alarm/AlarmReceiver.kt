package com.example.alarm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AlarmReceiver : BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
        val alarmTime = intent?.getStringExtra("Alarm") ?: return
        println("Alarm triggered : $alarmTime")
    }
}