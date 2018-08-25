package com.sujian.baseandroid.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sujian.baseandroid.base.contract.BaseContract


/**
 *   author: sujian
 *   date: 2018/8/20
 *   desc: xxx
 */
abstract class BaseFragment :RxFragment(){
    protected var  mView: View? = null



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView = inflater.inflate(getLayoutResId(),container,false)
        return mView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }



    override fun onLazyInitView(savedInstanceState: Bundle?) {
        super.onLazyInitView(savedInstanceState)
        lazyInitView()
    }

    fun lazyInitView(){}
    fun initView(){}
    abstract fun getLayoutResId():Int

}


