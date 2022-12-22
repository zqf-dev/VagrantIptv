package com.zqf.vagrantiptv.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.zqf.vagrantiptv.ui.fg.TabTypeFg

class HomeVpAdapter(fm: FragmentManager, titleList: MutableList<String>) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_SET_USER_VISIBLE_HINT) {
    private val list = titleList

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Fragment {
        return TabTypeFg.getInstance(position)
    }
}