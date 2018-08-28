package com.sujian.baseandroid.utils

import android.graphics.Bitmap
import java.io.File
import java.io.FileOutputStream

/**
 *   author: sujian
 *   date: 2018/8/28
 *   desc: 图片工具类
 */
object ImageUtils {


    /**
     * 保存图片到本地
     */
    fun saveImgToLocal(bitmap: Bitmap,file:File){
        var fileOutputStream: FileOutputStream? = null
        try {
            fileOutputStream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream)
            fileOutputStream.flush()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            fileOutputStream?.close()
        }
    }

}