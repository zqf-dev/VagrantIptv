package com.zqf.vagrantiptv.ui.presenter

import com.zqf.vagrantiptv.base.BasePresenter
import com.zqf.vagrantiptv.ui.contact.MeFgContact

/**
 * Author: zqf
 * Date: 2021/10/08
 */
class MeFgPresenter(v: MeFgContact.View) : BasePresenter<MeFgContact.View>(),
    MeFgContact.Presenter {

    init {
        attachView(v)
    }
}
