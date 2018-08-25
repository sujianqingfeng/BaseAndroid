package com.sujian.baseandroid.rx

import com.orhanobut.logger.Logger
import io.reactivex.subscribers.ResourceSubscriber

/**
 *   author: sujian
 *   date: 2018/8/25
 *   desc: xxx
 */
open class BaseSubscriber<T> :ResourceSubscriber<T>() {
    override fun onComplete() {
    }

    override fun onNext(t: T) {
    }

    override fun onError(t: Throwable?) {
        Logger.e("发生错误")
        t?.printStackTrace()
    }
}