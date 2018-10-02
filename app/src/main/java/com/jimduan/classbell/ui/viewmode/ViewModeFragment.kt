package com.jimduan.classbell.ui.viewmode

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jimduan.classbell.R

class ViewModeFragment : Fragment() {

    companion object {
        fun newInstance() = ViewModeFragment()
    }

    private lateinit var viewModel: ViewModeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.view_mode_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ViewModeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
