package com.zqf.vagrantiptv.ui.presenter

import com.zqf.vagrantiptv.base.BasePresenter
import com.zqf.vagrantiptv.ui.contact.OtherTypeFgContact

class OtherTypeFgPresenter(v: OtherTypeFgContact.IView) :
    BasePresenter<OtherTypeFgContact.IView>(), OtherTypeFgContact.Presenter {

    init {
        attachView(v)
    }
}