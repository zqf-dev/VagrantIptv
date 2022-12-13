package com.zqf.vagrantiptv.ui.presenter

import com.zqf.vagrantiptv.base.BasePresenter
import com.zqf.vagrantiptv.ui.contact.HomeFgContact

/**
 * Author: zqf
 * Date: 2021/10/08
 */
class HomeFgPresenter(v: HomeFgContact.HomeFgView) : BasePresenter<HomeFgContact.HomeFgView>(),
    HomeFgContact.Presenter {

    init {
        attachView(v)
    }
}
