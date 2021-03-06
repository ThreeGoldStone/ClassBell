package com.jimduan.classbell

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class AchievementFragment : Fragment() {

    companion object {
        fun newInstance() = AchievementFragment()
    }

    private lateinit var viewModel: AchievementViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.achievement_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AchievementViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
