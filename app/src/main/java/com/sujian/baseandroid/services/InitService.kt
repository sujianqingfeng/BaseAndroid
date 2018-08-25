package com.sujian.baseandroid.services

import android.annotation.TargetApi
import android.app.IntentService
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.sujian.baseandroid.BuildConfig
import org.jetbrains.anko.startService


/**
 *   author: sujian
 *   date: 2018/8/21
 *   desc: xxx
 */
class InitService : IntentService("InitService") {


    override fun onCreate() {
        super.onCreate()
        // Context.startForegroundService() did not then call Service.startForeground() 解决这个问题
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            val channel = NotificationChannel("init", "init", NotificationManager.IMPORTANCE_HIGH)

            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)

            val notification = Notification.Builder(this, "init").build()
            startForeground(1, notification)
        }
    }


    override fun onHandleIntent(intent: Intent?) {
        Logger.addLogAdapter(object : AndroidLogAdapter() {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return BuildConfig.DEBUG
            }
        })
    }


    // companion object 修饰 代表静态方法
    companion object {
        @JvmStatic
        fun startService(context: Context) {
            // xxx::class.java 获取Class<xxx>

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val intent = Intent(context, InitService::class.java)
                context.startForegroundService(intent)
            } else {
                context.startService<InitService>()
            }

        }
    }
}