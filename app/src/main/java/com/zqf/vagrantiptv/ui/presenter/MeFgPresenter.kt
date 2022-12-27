package com.zqf.vagrantiptv.ui.presenter

import com.zqf.vagrantiptv.R
import com.zqf.vagrantiptv.base.BasePresenter
import com.zqf.vagrantiptv.entity.MeItemEntity
import com.zqf.vagrantiptv.ui.contact.MeFgContact
import kotlinx.coroutines.launch

/**
 * Author: zqf
 * Date: 2021/10/08
 */
class MeFgPresenter(v: MeFgContact.ViewBase) : BasePresenter<MeFgContact.ViewBase>(),
    MeFgContact.Presenter {

    init {
        attachView(v)
    }

    override fun getMeData() {
        mCoroutineScope.launch {
            val meList: MutableList<MeItemEntity> = mutableListOf()
            meList.add(
                MeItemEntity(
                    R.mipmap.grid_play_history_icon,
                    "我的历史"
                )
            )
            meList.add(
                MeItemEntity(
                    R.mipmap.grid_my_collection_icon,
                    "我的收藏"
                )
            )
            meList.add(
                MeItemEntity(
                    R.mipmap.grid_my_download_icon,
                    "我的下载"
                )
            )
            meList.add(
                MeItemEntity(
                    R.mipmap.grid_my_message_icon,
                    "我的消息"
                )
            )
            meList.add(
                MeItemEntity(
                    R.mipmap.grid_my_share_icon,
                    "分享好友"
                )
            )
            meList.add(
                MeItemEntity(
                    R.mipmap.grid_my_setting_icon,
                    "设置"
                )
            )
            getView()?.meData(meList)
        }
    }
}
