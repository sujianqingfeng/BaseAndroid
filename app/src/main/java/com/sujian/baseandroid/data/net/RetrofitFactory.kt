package com.sujian.baseandroid.data.net

import com.sujian.baseandroid.App
import com.sujian.baseandroid.common.BaseApplication
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


/**
 *   author: sujian
 *   date: 2018/8/25
 *   desc: xxx
 */
class RetrofitFactory private constructor(){

    companion object {
        val instance :RetrofitFactory by lazy { RetrofitFactory() }
    }


    fun <T> create(service:Class<T>,baseUrl:String):T{
        if (OkHttpUtils.okHttpClient == null) OkHttpUtils.initOkHttp(BaseApplication.context)
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpUtils.okHttpClient)
                .build()
                .create(service)

    }
}