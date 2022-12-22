package com.zqf.vagrantiptv.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.zqf.vagrantiptv.ui.fg.TabTypeFg

class HomeVp2Adapter(fm: FragmentActivity, titleList: MutableList<String>) :
    FragmentStateAdapter(fm) {
    private val list = titleList
    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return TabTypeFg()
    }
}