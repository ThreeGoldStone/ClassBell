package com.jimduan.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by DJl on 2018/7/27.
 * email:1554068430@qq.com
 */
val dateFormater1: SimpleDateFormat
    get() = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

fun Date.toString1(): String {
    return dateFormater1.format(this)
}
fun String.toDate1(s:String): Date {
    return dateFormater1.parse(s)
}
val dateFormater2: SimpleDateFormat
    get() = SimpleDateFormat("HH:mm:ss")

fun Date.toString2(): String {
    return dateFormater2.format(this)
}
fun String.toDate2(s:String): Date {
    return dateFormater2.parse(s)
}

class Util {
}