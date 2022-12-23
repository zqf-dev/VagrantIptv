package com.zqf.vagrantiptv.ui.contact

import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.zqf.vagrantiptv.base.BaseIView
import net.lucode.hackware.magicindicator.MagicIndicator

interface HomeFgContact {

    interface IView : BaseIView {
        fun tabSelect(p: Int)
    }

    interface Presenter {
        fun initCnIndicatorVp(indicator: MagicIndicator, vp: ViewPager)
        fun initCnIndicatorVp2(indicator: MagicIndicator, vp: ViewPager2)
    }
}