package com.sujian.baseandroid.data.net

import android.content.Context
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File
import java.util.concurrent.TimeUnit


/**
 *   author: sujian
 *   date: 2018/8/22
 *   desc: xxx
 */
object OkHttpUtils {

    @JvmStatic
    @get:Synchronized
    var okHttpClient:OkHttpClient? = null

    private val interceptor:Interceptor
    private  const val MAX_CACHE_SIZE = 10 * 1024 * 1024
    private const val READ_TIME_OUT = 20
    private const val CONNECT_TIME_OUT = 15

    init {
        interceptor = Interceptor {
            chain -> val request =  chain.request()
                .newBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("charset", "utf-8")
                .build()
            chain.proceed(request)
        }
    }


    @JvmStatic
    fun initLogInterceptor():Interceptor{
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @JvmStatic
    fun initOkHttpClient(okHttpClient: OkHttpClient){
        OkHttpUtils.okHttpClient =okHttpClient
    }



    @JvmStatic
    fun initOkHttp(context: Context){

        val cacheFile = File(context.externalCacheDir.toString(),"cache")


        val cache = Cache(cacheFile, MAX_CACHE_SIZE.toLong())

        okHttpClient = OkHttpClient.Builder()
                .readTimeout(READ_TIME_OUT.toLong(),TimeUnit.SECONDS)
                .connectTimeout(CONNECT_TIME_OUT.toLong(),TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .addInterceptor(interceptor)
                .addInterceptor(initLogInterceptor())
                .cache(cache)
                .build()
    }


}