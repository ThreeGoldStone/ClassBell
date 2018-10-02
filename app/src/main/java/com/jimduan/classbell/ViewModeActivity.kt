package com.jimduan.classbell

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.jimduan.classbell.ui.viewmode.ViewModeFragment

class ViewModeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_mode_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, ViewModeFragment.newInstance())
                    .commitNow()
        }
    }

}
