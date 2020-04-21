package com.zj.audio.live

import android.content.Context
import android.graphics.Point
import android.view.WindowManager


/**
 * 版权：渤海新能 版权所有
 * @author zhujiang
 * 版本：1.5
 * 创建日期：2020/4/21
 * 描述：CameraX
 *
 */

/**
 * Return the width of screen, in pixel.
 *
 * @return the width of screen, in pixel
 */
fun getScreenWidth(context: Context?): Int {
    val wm =
        context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val point = Point()
    wm.defaultDisplay.getRealSize(point)
    return point.x
}

/**
 * Return the height of screen, in pixel.
 *
 * @return the height of screen, in pixel
 */
fun getScreenHeight(context: Context?): Int {
    val wm =
        context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            ?: return -1
    val point = Point()
    wm.defaultDisplay.getRealSize(point)
    return point.y
}

/**
 * Return the application's width of screen, in pixel.
 *
 * @return the application's width of screen, in pixel
 */
fun getAppScreenWidth(context: Context?): Int {
    val wm =
        context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val point = Point()
    wm.defaultDisplay.getSize(point)
    return point.x
}

/**
 * Return the application's height of screen, in pixel.
 *
 * @return the application's height of screen, in pixel
 */
fun getAppScreenHeight(context: Context?): Int {
    val wm =
        context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val point = Point()
    wm.defaultDisplay.getSize(point)
    return point.y
}
