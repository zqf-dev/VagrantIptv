package com.zqf.vagrantiptv.ui.contact

import com.zqf.vagrantiptv.base.BaseIView
import com.zqf.vagrantiptv.entity.MeRecycleEntity

interface MeFgContact {

    interface ViewBase : BaseIView {
        fun meData(list: MutableList<MeRecycleEntity>)
    }

    interface Presenter {
        fun getMeData()
    }
}