package com.nezrin.coinsapp.common.service

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.app.Service
import android.content.ContentValues.TAG
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.nezrin.coinsapp.R
import com.nezrin.coinsapp.root.MainActivity

//class MyForegroundService : Service() {
//    private val TAG = "MyForegroundService"
//    override fun onBind(po: Intent?): IBinder? = null
//
//    /**
//     * START_STICKY //servisi davam eletdirir
//     * START_NOT_STICKY //servisi baslatmayacaq
//     * START_REDELIVER_INTENT //servisi 0'dan basladacaq
//     */
//    @SuppressLint("NotificationId0")
//    override fun onStartCommand(intent: Intent?, flags: Int, startid: Int): Int {
//        Log.d(TAG, "onStartCommand: Service started!")
//
//        val notificationIntent = Intent(this, MainActivity::class.java)
//        val pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0)
//
//        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
//            .setContentTitle("Title")
//            .setContentText("Content")
//            .setContentIntent(pendingIntent)
//            .setSmallIcon(R.mipmap.ic_launcher)
//            .build()
//        startForeground(0, notification)
//        return START_REDELIVER_INTENT //RAM
//    }
//
//    override fun onCreate() {
//        Log.d(TAG, "onCreate: Service created!")
//
//        val notification = NotificationCompat.Builder(this)
//            .setLargeIcon(
//                BitmapFactory.decodeResource(
//                    resources,
//                    R.drawable.ic_launcher_foreground
//                )
//            )
//            .setContentTitle("My notification")
//            .setContentText("This is my notification")
//            .setSmallIcon(R.drawable.ic_launcher_foreground)
//            .build()
//
//        NotificationManagerCompat.from(this).notify(0,notification)
//        super.onCreate()
//    }
//}
