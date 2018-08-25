package com.sujian.baseandroid.data.api

import com.sujian.baseandroid.data.bean.HomeBean
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path


/**
 *   author: sujian
 *   date: 2018/8/25
 *   desc: xxx
 */
interface WanAndroidService {

    @GET("/article/list/{page}/json")
    fun home(@Path("page") page:Int):Flowable<HomeBean>
}