package com.zqf.vagrantiptv.ui.presenter

import com.zqf.vagrantiptv.base.BasePresenter
import com.zqf.vagrantiptv.ui.contact.DiscoverFgContact

/**
 * Author: zqf
 * Date: 2021/10/08
 */
class DiscoverFgPresenter(v: DiscoverFgContact.ViewBase) :
    BasePresenter<DiscoverFgContact.ViewBase>(),
    DiscoverFgContact.Presenter {

    init {
        attachView(v)
    }
}