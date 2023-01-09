package com.zqf.vagrantiptv.ui.contact

import com.zqf.vagrantiptv.base.BaseIView

interface DiscoverFgContact {

    interface ViewBase : BaseIView {

    }

    interface Presenter {
        fun getData()
    }
}