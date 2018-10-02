package com.jimduan.classbell

import android.app.Application
import com.jimduan.bean.MyObjectBox

class APP : Application() {
    override fun onCreate() {
        super.onCreate()
        MyObjectBox.builder().androidContext(this).buildDefault()
    }

}