package com.example.alarm

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat


class AlarmNotificationService(
    private val context: Context
) {
    private val notificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    fun showNotification() {
        val cancelPendingIntent = PendingIntent.getBroadcast(
            context,
            0,
            Intent(context,CancelNotificationReceiver::class.java),
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )
        val notification = NotificationCompat.Builder(context, ALARM_CHANNEL_ID)
            .setSmallIcon(R.drawable.alarm)
            .setContentTitle("Alarm")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setCategory(Notification.CATEGORY_ALARM)
            .setOngoing(true)
            .addAction(R.drawable.alarm, "Stop", cancelPendingIntent)
            .build()

        notificationManager.notify(
            1,
            notification
        )
    }
    fun cancelAlarmNotification() {
        print("Notification Cancelled")
      notificationManager.cancel(1)
    }

    companion object {
        const val ALARM_CHANNEL_ID = "alarm_channel"
    }
}