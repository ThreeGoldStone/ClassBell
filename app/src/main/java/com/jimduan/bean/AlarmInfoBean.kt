package com.jimduan.bean

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import java.util.*

const val REPEAT_TYPE_1 = ""

/**
 * Created by DJl on 2018/8/16.
 * email:1554068430@qq.com
 */
@Entity data class AlarmInfoBean(@Id var id: Long, var time: Date) {
    var repeatType: String = REPEAT_TYPE_1
    var ringTone: String = ""
    var remarks: String = ""
    var state =false
}
