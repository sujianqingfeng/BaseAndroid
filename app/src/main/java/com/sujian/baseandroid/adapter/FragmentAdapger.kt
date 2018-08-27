package com.sujian.baseandroid.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.sujian.baseandroid.base.contract.BaseContract
import com.sujian.baseandroid.base.fragment.BaseFragment

/**
 *   author: sujian
 *   date: 2018/8/27
 *   desc: xxx
 */
class FragmentAdapger (fm:FragmentManager, titles:Array<String>, fragmnets: Array<BaseContract.IBaseView>) :FragmentPagerAdapter(fm) {

    var titles:Array<String>? = null
    var fragmnets:Array<BaseContract.IBaseView>? =null

    init {
        this.titles = titles
        this.fragmnets = fragmnets
    }


    override fun getPageTitle(position: Int): CharSequence? {
        return titles?.get(position)
    }

    override fun getItem(position: Int): Fragment  = fragmnets?.get(position)!! as Fragment

    override fun getCount(): Int  = fragmnets?.size!!
}