package com.sujian.baseandroid.services

import android.annotation.TargetApi
import android.app.IntentService
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Environment
import android.util.Log
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.sujian.baseandroid.App
import com.sujian.baseandroid.BuildConfig
import com.sujian.baseandroid.Constant
import com.sujian.baseandroid.data.DataManger
import com.sujian.baseandroid.utils.ImageUtils
import com.sujian.baseandroid.utils.SpUtils
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import org.jetbrains.anko.startService
import java.io.File


/**
 *   author: sujian
 *   date: 2018/8/21
 *   desc: xxx
 */
class InitService : IntentService("InitService") {


    lateinit var mDisposables: CompositeDisposable

    override fun onCreate() {
        super.onCreate()
        mDisposables = CompositeDisposable()

        // Context.startForegroundService() did not then call Service.startForeground() 解决这个问题
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel("init", "init", NotificationManager.IMPORTANCE_HIGH)

            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)

            val notification = Notification.Builder(this, "init").build()
            startForeground(1, notification)
        }
    }


    override fun onHandleIntent(intent: Intent?) {
        // logger 配置
        Logger.addLogAdapter(object : AndroidLogAdapter() {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return BuildConfig.DEBUG
            }
        })


        // 这里判断广告图 模拟请求
        mDisposables.add(DataManger.getHome()
                .subscribe {
                    // 判断逻辑
                    val isDownloadAdImg = true
                    if (isDownloadAdImg) {
                        startDownloadImg("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2241266698,3236803863&fm=26&gp=0.jpg")
                    }
                })


    }


    private fun startDownloadImg(url: String) {
        SpUtils.putValue(Constant.AD_IMG_DOWNLOAD_FINSH, false)
        mDisposables.add(DataManger.downFile(url)
                .map { BitmapFactory.decodeStream(it.byteStream()) }
                .subscribe {
                    val fileName = url.hashCode().toString()
                    val file = File(applicationContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES).absolutePath, fileName)
                    ImageUtils.saveImgToLocal(it, file)
                    SpUtils.putValue(Constant.AD_IMG_KEY, file.absolutePath)
                    SpUtils.putValue(Constant.AD_IMG_DOWNLOAD_FINSH, true)
                })

    }


    override fun onDestroy() {
        super.onDestroy()
        mDisposables.clear()
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