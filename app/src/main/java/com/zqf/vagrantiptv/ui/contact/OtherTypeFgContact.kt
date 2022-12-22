package com.zqf.vagrantiptv.ui.contact

import com.zqf.vagrantiptv.base.BaseIView

interface OtherTypeFgContact {

    interface IView : BaseIView {

    }

    interface Presenter {
        fun getIPTVData(type: Int)
    }
}