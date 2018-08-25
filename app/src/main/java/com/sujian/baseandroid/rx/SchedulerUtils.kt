package com.sujian.baseandroid.rx

import io.reactivex.FlowableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 *   author: sujian
 *   date: 2018/8/25
 *   desc: xxx
 */

object SchedulerUtils {
    fun <T> io_main(): FlowableTransformer<T, T> = FlowableTransformer { upstream -> upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()) }
}