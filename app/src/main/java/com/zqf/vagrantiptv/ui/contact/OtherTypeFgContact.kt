package com.zqf.vagrantiptv.ui.contact

import com.zqf.vagrantiptv.base.BaseIView
import com.zqf.vagrantiptv.entity.BannerEntity
import com.zqf.vagrantiptv.entity.TabTypeMultiEntity

interface OtherTypeFgContact {

    interface IView : BaseIView {
        fun recycleData(data: MutableList<TabTypeMultiEntity>)
        fun banner(dataBanner: MutableList<BannerEntity>)
    }

    interface Presenter {
        fun getIPTVData(type: Int)
    }
}