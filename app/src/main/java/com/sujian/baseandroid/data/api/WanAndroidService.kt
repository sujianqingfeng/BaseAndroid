package com.sujian.baseandroid.data.api

import com.sujian.baseandroid.data.bean.HomeBean
import io.reactivex.Flowable
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Streaming
import retrofit2.http.Url


/**
 *   author: sujian
 *   date: 2018/8/25
 *   desc: xxx
 */
interface WanAndroidService {

    @GET("/article/list/{page}/json")
    fun home(@Path("page") page:Int):Flowable<HomeBean>


    /**
     * 下载文件流
     */
    @GET
    @Streaming
    fun downloadFile(@Url url:String):Flowable<ResponseBody>
}