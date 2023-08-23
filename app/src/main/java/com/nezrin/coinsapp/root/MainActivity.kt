package com.nezrin.coinsapp.root

import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.*
import com.nezrin.coinsapp.R
import com.nezrin.coinsapp.common.MyWorker
//import com.nezrin.coinsapp.common.service.MyBackgroundService
//import com.nezrin.coinsapp.root.CoinsApplication.Companion.CHANNEL_ID
import dagger.hilt.android.AndroidEntryPoint
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
//
//    //showing notification
//    fun showNotification(){
//
//        //notification'a click edende ozu acir
//        val clickIntent=Intent(this,MainActivity::class.java)
//        val pendingIntent=PendingIntent.getActivity(this,0,clickIntent,0)
//
//        val notification=NotificationCompat.Builder(this,CHANNEL_ID)
//            .setContentIntent(pendingIntent)
//            .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.ic_launcher_foreground))
//            .setContentTitle("My notification")
//            .setContentText("This is my notification")
//            .setSmallIcon(R.mipmap.ic_launcher)
//            .build()
//
//        NotificationManagerCompat.from(this).notify(0,notification)
//
//    }
//
//    fun triggerRefreshData(){
//        val intent=Intent(this,MyBackgroundService::class.java)
//        startService(intent)
//    }

    private fun startWork(){

        val constraints= Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresBatteryNotLow(true)
            .build()


        val oneTimeRequest= OneTimeWorkRequestBuilder<MyWorker>()
            .setConstraints(constraints)
            .build()

        val periodicRequest= PeriodicWorkRequestBuilder<MyWorker>(10, TimeUnit.MINUTES)
            .setBackoffCriteria(BackoffPolicy.EXPONENTIAL,10, TimeUnit.MINUTES)

        val manager= WorkManager.getInstance(this)
        manager.enqueue(oneTimeRequest)


        manager.getWorkInfoByIdLiveData(oneTimeRequest.id).observe(this){

            Log.e("result",it.state.name)

            when(it.state){

                WorkInfo.State.SUCCEEDED ->{

                }
                WorkInfo.State.FAILED ->{

                }
                WorkInfo.State.BLOCKED ->{

                }
                WorkInfo.State.RUNNING ->{

                }
                WorkInfo.State.ENQUEUED ->{

                }
                WorkInfo.State.CANCELLED ->{

                }
            }
        }
    }
}