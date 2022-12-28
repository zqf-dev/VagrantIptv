package com.zqf.vagrantiptv.ui.adapter

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.shuyu.gsyvideoplayer.listener.GSYSampleCallBack
import com.shuyu.gsyvideoplayer.utils.OrientationUtils
import com.zqf.vagrantiptv.R
import com.zqf.vagrantiptv.entity.TabTypeMultiEntity
import com.zqf.vagrantiptv.widget.video.SampleCoverVideo


class TabTypeRecycleAdapter : BaseMultiItemQuickAdapter<TabTypeMultiEntity, BaseViewHolder>() {

    private val TAG = "TabTypeRecycleAdapter"
    private var orientationUtils: OrientationUtils? = null
    private var isPlay = false
    private var isFull = false

    init {
        addItemType(0, R.layout.tabtype1_layout)
        addItemType(1, R.layout.tabtype2_layout)
    }

    override fun convert(holder: BaseViewHolder, item: TabTypeMultiEntity) {
        if (item.type == 0) {
            holder.setText(R.id.t1_title, item.title)
            val gsyVideoPlayer = holder.getView<SampleCoverVideo>(R.id.t1_player)
            //使用lazy的set可以避免滑动卡的情况存在
            gsyVideoPlayer.setUpLazy(item.url, true, null, null, "")
            gsyVideoPlayer.playTag = TAG
            gsyVideoPlayer.isReleaseWhenLossAudio = false
            gsyVideoPlayer.isRotateWithSystem = false
            gsyVideoPlayer.isAutoFullWithSize = true
            gsyVideoPlayer.setIsTouchWiget(false)
            gsyVideoPlayer.isNeedLockFull = true
            gsyVideoPlayer.isShowFullAnimation = false
            gsyVideoPlayer.setIsTouchWiget(false)
            gsyVideoPlayer.playPosition = getItemPosition(item)
            gsyVideoPlayer.fullscreenButton.setOnClickListener {
                gsyVideoPlayer.startWindowFullscreen(context, false, true)
            }
            gsyVideoPlayer.setVideoAllCallBack(object : GSYSampleCallBack() {
                override fun onEnterFullscreen(url: String?, vararg objects: Any?) {
                    super.onEnterFullscreen(url, *objects)
                    isFull = true
                }

                override fun onQuitFullscreen(url: String?, vararg objects: Any?) {
                    super.onQuitFullscreen(url, *objects)
                    isFull = false
                }

                override fun onPrepared(url: String?, vararg objects: Any?) {
                    super.onPrepared(url, *objects)
                    isFull = gsyVideoPlayer.currentPlayer.isIfCurrentIsFullscreen
                    isPlay = true
                }

                override fun onAutoComplete(url: String?, vararg objects: Any?) {
                    super.onAutoComplete(url, *objects)
                    isPlay = false
                    isFull = false
                }
            })
        }
    }

    fun onBackPressed() {
        // 如果不需要旋转屏幕，可以不调用
        // 不需要屏幕旋转，还需要设置 setNeedOrientationUtils(false)
        if (orientationUtils != null) {
            orientationUtils!!.backToProtVideo()
        }
    }
}