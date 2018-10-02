package com.jimduan.classbell

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import com.jimduan.utils.BottomNavigationViewHelper
import com.jimduan.utils.MyActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MyActivity() {
    private lateinit var fragments: MutableList<Fragment>
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_schedule -> {
                return@OnNavigationItemSelectedListener true
//                supportFragmentManager.beginTransaction().show()
                var index = 0
                val transaction = supportFragmentManager.beginTransaction()
                val size = fragments.size

                transaction.show(fragments[index])
            }
            R.id.navigation_lessons -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_achievements -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_settings -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        BottomNavigationViewHelper.disableShiftMode(navigation)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        // 初始化碎片列表
        fragments = mutableListOf(ScheduleFragment.newInstance())
        val transaction = supportFragmentManager.beginTransaction()
        // 添加碎片到view
        for (fragment in fragments) {
            transaction.add(R.id.main_contain, fragment)
        }
        transaction.commitNow()
    }
}
