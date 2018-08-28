package com.sujian.baseandroid


import com.sujian.baseandroid.common.BaseApplication
import com.sujian.baseandroid.services.InitService


/**
 *   author: sujian
 *   date: 2018/8/21
 *   desc: App
 */
class App : BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        InitService.startService(context)
    }
}