package com.sujian.baseandroid.ext

import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 *   author: sujian
 *   date: 2018/8/28
 *   desc: 公共扩展函数
 */


fun ImageView.loadUrl(url:String) =  Glide.with(this).load(url).into(this)