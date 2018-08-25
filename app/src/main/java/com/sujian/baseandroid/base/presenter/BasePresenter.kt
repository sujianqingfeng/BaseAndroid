package com.sujian.baseandroid.base.presenter

import com.sujian.baseandroid.base.contract.BaseContract
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


/**
 *   author: sujian
 *   date: 2018/8/20
 *   desc: xxx
 */
open class BasePresenter:BaseContract.IBasePresenter {


    var mDisposable:CompositeDisposable? = null



    fun unSubscribe(){
        if (mDisposable!=null){
            mDisposable?.clear()
        }
    }

    fun addSubscribe(disposable: Disposable){
        if(mDisposable==null){
            mDisposable = CompositeDisposable()
        }
        mDisposable?.add(disposable)
    }


    override fun onCreate() {
    }

    override fun onResume() {
    }

    override fun onDestroy() = unSubscribe()

}