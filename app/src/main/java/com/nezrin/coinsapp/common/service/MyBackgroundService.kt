package com.nezrin.coinsapp.common.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

//started service
//class MyBackgroundService:Service() {
//    private val TAG = "MyBackgroundTag"
//    override fun onBind(po: Intent?): IBinder? = null
//
////    override fun onCreate() {
////        Log.d(TAG, "Service created!")
////        super.onCreate()
////    }
//
//    /**
//     * START_STICKY
//     * START_NOT_STICKY
//     * START_REDELIVER_INTENT
//     **/
//
//    override fun onStartCommand(intent: Intent?, flags: Int, startid: Int): Int {
//        Log.d(TAG, "onStartCommand: Service started")
//        //get data from api
//        //set data to local database
//
//
//        return START_STICKY
//    }
//}