package com.zqf.vagrantiptv.ui.presenter

import android.content.Context
import android.graphics.Color
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.zqf.vagrantiptv.base.BasePresenter
import com.zqf.vagrantiptv.ui.contact.HomeFgContact
import com.zqf.vagrantiptv.widget.ScaleTransitionPagerTitleView
import net.lucode.hackware.magicindicator.MagicIndicator
import net.lucode.hackware.magicindicator.ViewPagerHelper
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView

/**
 * Author: zqf
 * Date: 2021/10/08
 */
class HomeFgPresenter(v: HomeFgContact.IView) :
    BasePresenter<HomeFgContact.IView>(),
    HomeFgContact.Presenter {

    val titleList: MutableList<String> =
        mutableListOf("时事", "CCTV", "卫视", "综艺", "剧场", "美食", "动漫", "旅游", "体育", "音乐")

    init {
        attachView(v)
    }

    /**
     * ViewPage 用法
     */
    override fun initCnIndicatorVp(indicator: MagicIndicator, vp: ViewPager) {
        val cn = CommonNavigator(indicator.context)
        cn.adapter = object : CommonNavigatorAdapter() {
            override fun getCount(): Int {
                return titleList.size
            }

            override fun getTitleView(context: Context?, index: Int): IPagerTitleView {
                val colorTitleV = ScaleTransitionPagerTitleView(context)
                colorTitleV.normalColor = Color.BLACK
                colorTitleV.selectedColor = Color.WHITE
                colorTitleV.text = titleList[index]
                colorTitleV.textSize = 17f
                colorTitleV.setOnClickListener {
                    vp.currentItem = index
                }
                return colorTitleV
            }

            override fun getIndicator(context: Context?): IPagerIndicator {
                val lpi = LinePagerIndicator(context)
                lpi.setColors(Color.WHITE)
                lpi.mode = LinePagerIndicator.MODE_WRAP_CONTENT
                return lpi
            }
        }
        indicator.navigator = cn
        ViewPagerHelper.bind(indicator, vp)
    }

    /**
     * ViewPage2用法
     */
    override fun initCnIndicatorVp2(indicator: MagicIndicator, vp2: ViewPager2) {
        val cn = CommonNavigator(indicator.context)
        cn.adapter = object : CommonNavigatorAdapter() {
            override fun getCount(): Int {
                return titleList.size
            }

            override fun getTitleView(context: Context?, index: Int): IPagerTitleView {
                val colorTitleV = ColorTransitionPagerTitleView(context)
                colorTitleV.normalColor = Color.BLACK
                colorTitleV.selectedColor = Color.WHITE
                colorTitleV.text = titleList[index]
                colorTitleV.setOnClickListener {
                    vp2.currentItem = index
                }
                return colorTitleV
            }

            override fun getIndicator(context: Context?): IPagerIndicator {
                val lpi = LinePagerIndicator(context)
                lpi.mode = LinePagerIndicator.MODE_WRAP_CONTENT
                return lpi
            }
        }
        indicator.navigator = cn
        vp2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                indicator.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageSelected(position: Int) {
                indicator.onPageSelected(position)
            }

            override fun onPageScrollStateChanged(state: Int) {
                indicator.onPageScrollStateChanged(state)
            }
        })
    }
}
