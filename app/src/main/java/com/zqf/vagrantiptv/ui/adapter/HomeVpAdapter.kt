package com.zqf.vagrantiptv.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.zqf.vagrantiptv.ui.fg.OtherTypeFg

class HomeVpAdapter(fm: FragmentManager, titleList: MutableList<String>) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private val list = titleList

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Fragment {
        return OtherTypeFg.getInstance(position)
    }
}