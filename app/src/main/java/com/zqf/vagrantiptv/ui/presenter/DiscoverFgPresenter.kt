package com.zqf.vagrantiptv.ui.presenter

import com.orhanobut.logger.Logger
import com.zqf.vagrantiptv.base.BasePresenter
import com.zqf.vagrantiptv.ui.contact.DiscoverFgContact
import com.zqf.vagrantiptv.utils.IPTVDataSource
import kotlinx.coroutines.launch

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

    override fun getData() {
        mCoroutineScope.launch {
            val data = IPTVDataSource.getData2("source2.txt")
            Logger.i("data:>> $data")
        }
    }
}
