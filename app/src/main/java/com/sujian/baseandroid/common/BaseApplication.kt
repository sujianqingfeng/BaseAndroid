package com.sujian.baseandroid.common

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex

/**
 *   author: sujian
 *   date: 2018/8/20
 *   desc:app 基类
 *   open关键字可以被覆写
 */
open class BaseApplication: Application(){

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }


    override fun onCreate() {
        super.onCreate()
        context = this
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

}