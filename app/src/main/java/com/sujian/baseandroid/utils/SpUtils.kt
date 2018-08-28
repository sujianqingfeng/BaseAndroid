package com.sujian.baseandroid.utils

import android.content.Context
import android.content.SharedPreferences
import com.sujian.baseandroid.common.BaseApplication

/**
 *   author: sujian
 *   date: 2018/8/28
 *   desc: SharedPreferences 工具类
 */
object SpUtils {


    private val sp:SharedPreferences by lazy { BaseApplication.context.getSharedPreferences("sp",Context.MODE_PRIVATE) }


    /**
     * 放值
     * with它是将某对象作为函数的参数，在函数块内可以通过 this 指代该对象。返回值为函数块的最后一行或指定return表达式。
     */
    fun putValue(key:String,value:Any) = with(sp.edit()){
        when(value){
            is Boolean -> putBoolean(key,value)
            is Int -> putInt(key,value)
            is String -> putString(key,value)
            is Long -> putLong(key,value)
            is Float -> putFloat(key,value)
            else -> {
                throw IllegalArgumentException("sp 类型不匹配")
            }
        }.apply()
    }

    /**
     * 获值
     */
    fun <V> getValue(key:String,default: V) :V = with(sp){
       val res:Any = when(default){
            is Boolean -> getBoolean(key,default)
            is Int -> getInt(key,default)
            is String -> getString(key,default)
            is Long -> getLong(key,default)
            is Float -> getFloat(key,default)
            else -> {
                throw IllegalArgumentException("sp 类型不匹配")
            }
        }
        res as V
    }

    /**
     * 删除某值
     */
    fun remove(key:String) = sp.edit().remove(key).apply()


    /**
     * 删除所有数据
     */
    fun clear() = sp.edit().clear().apply()

}
