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
                showFragmentByIndex(0)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_lessons -> {
                showFragmentByIndex(1)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_achievements -> {
                showFragmentByIndex(2)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_settings -> {
                showFragmentByIndex(3)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    fun showFragmentByIndex(index: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        val size = fragments.size
        for (i in 0..(size - 1)) {
            val fragment = fragments[i]
            if (index == i)
                transaction.show(fragment)
            else
                transaction.hide(fragment)
        }
        transaction.commitNow()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        BottomNavigationViewHelper.disableShiftMode(navigation)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        // 初始化碎片列表
        fragments = mutableListOf(ScheduleFragment.newInstance(),
                LessonsFragment.newInstance(),
                AchievementFragment.newInstance(),
                SettingFragment.newInstance())
        val transaction = supportFragmentManager.beginTransaction()
        // 添加碎片到view
        for (fragment in fragments) {
            transaction.add(R.id.main_contain, fragment)
        }
        showFragmentByIndex(0)
        transaction.commitNow()
    }
}
