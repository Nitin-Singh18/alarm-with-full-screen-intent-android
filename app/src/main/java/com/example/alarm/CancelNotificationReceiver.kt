package com.example.alarm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class CancelNotificationReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        context?.let {
            val service = AlarmNotificationService(context)
            service.cancelAlarmNotification()
        }
    }
}