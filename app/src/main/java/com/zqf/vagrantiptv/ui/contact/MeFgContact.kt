package com.zqf.vagrantiptv.ui.contact

import com.zqf.vagrantiptv.base.BaseIView
import com.zqf.vagrantiptv.entity.MeItemEntity

interface MeFgContact {

    interface ViewBase : BaseIView {
        fun meData(list: MutableList<MeItemEntity>)
    }

    interface Presenter {
        fun getMeData()
    }
}