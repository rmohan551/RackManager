package com.example.rackmanager

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    companion object {
        private const val TAG = "MyFirebaseMsgService"
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        // Handle incoming FCM messages here
        Log.d(TAG, "From: ${remoteMessage.from}")

        // Check if the message contains a notification payload.
        remoteMessage.notification?.let {
            Log.d(TAG, "Notification Message Body: ${it.body}")
            // You can handle the notification here, e.g., show a notification to the user.
            // For simplicity, you can use a utility class or NotificationManager to show a notification.
        }

        // If the message contains data payload.
        remoteMessage.data.isNotEmpty().let {
            Log.d(TAG, "Message data payload: " + remoteMessage.data)
            // Handle the data payload here. You may want to perform some action based on the data.
        }
    }

    override fun onNewToken(token: String) {
        // Handle the new token here.
        Log.d(TAG, "Refreshed token: $token")
        // You may want to send the new token to your server for further processing.



         fun showNotification(title: String?, message: String?) {
            val notificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            val channelId = "MyChannelId"

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channel = NotificationChannel(
                    channelId,
                    "MyChannel",
                    NotificationManager.IMPORTANCE_DEFAULT
                )
                channel.description = "My Notification Channel"
                channel.enableLights(true)
                channel.lightColor = Color.BLUE
                channel.enableVibration(true)
                notificationManager.createNotificationChannel(channel)
            }

             val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            val pendingIntent = PendingIntent.getActivity(
                this, 0, intent,
                PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE
            )

            val notificationBuilder = NotificationCompat.Builder(this, channelId)
                .setSmallIcon(R.drawable.baseline_circle_notifications_24)
                .setContentTitle(title)
                .setContentText(message)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)

            notificationManager.notify(0, notificationBuilder.build())
        }
    }
    }



