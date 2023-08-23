package com.nezrin.coinsapp.root

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.graphics.Color
import android.media.AudioAttributes
import android.net.Uri
import android.os.Build
import android.os.Build.VERSION_CODES.O
import com.nezrin.coinsapp.R
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CoinsApplication:Application() {
//    companion object {
//        const val CHANNEL_NAME = "exampleChannelName"
//        const val CHANNEL_ID = "0"
//    }
//
//    override fun onCreate() {
//        super.onCreate()
//        createNotificationChannel()
//
//    }
//
//    private fun createNotificationChannel() {
//
//        if (Build.VERSION.SDK_INT >= O) {
//            //id -user'in id'sidi notification hansi id'ye gondermek lazimdi onu gosterir
//            //channel name-usere hansi channel oldugunu gosterir
//            //channeli app yaranan kimi yaratmaq lazimdi
//            val channel = NotificationChannel(
//                CHANNEL_ID,
//                CHANNEL_NAME,
//                NotificationManager.IMPORTANCE_DEFAULT
//            )
//            channel.lightColor=Color.BLUE
////            channel.setSound(Uri.parse("android.resource://" + getPackageName() + "/"
////                    + 0),AudioAttributes.Builder().build()) //uri ile ses elave etmek
//            //channel'i yaradiriq
//        val manager = getSystemService(NotificationManager::class.java)
//        manager.createNotificationChannel(channel)
//    }
//}
}