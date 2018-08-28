package com.sujian.baseandroid.data

import com.sujian.baseandroid.data.api.WanAndroidService
import com.sujian.baseandroid.data.bean.HomeBean
import com.sujian.baseandroid.data.net.RetrofitFactory
import io.reactivex.Flowable
import okhttp3.ResponseBody


/**
 *   author: sujian
 *   date: 2018/8/25
 *   desc: xxx
 */
object DataManger {
    private val mRetrofitFactory:RetrofitFactory by lazy { RetrofitFactory.instance }


    private val wanAndroidService by lazy { mRetrofitFactory.create(WanAndroidService::class.java,"http://www.wanandroid.com") }


    fun getHome():Flowable<HomeBean> = wanAndroidService.home(0)

    fun downFile(url:String):Flowable<ResponseBody> = wanAndroidService.downloadFile(url)


}