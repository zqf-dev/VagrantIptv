package com.zqf.vagrantiptv.ui.contact

import com.zqf.vagrantiptv.base.BaseIView
import com.zqf.vagrantiptv.entity.BannerEntity

interface OtherTypeFgContact {

    interface IView : BaseIView {
        fun banner(dataBanner: MutableList<BannerEntity>)
    }

    interface Presenter {
        fun getIPTVData(type: Int)
    }
}