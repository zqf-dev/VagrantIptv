package com.zqf.vagrantiptv.app

import android.app.Application
import com.scwang.smart.refresh.footer.ClassicsFooter
import com.scwang.smart.refresh.header.ClassicsHeader
import com.scwang.smart.refresh.layout.SmartRefreshLayout
import com.scwang.smart.refresh.layout.listener.DefaultRefreshFooterCreator
import com.scwang.smart.refresh.layout.listener.DefaultRefreshHeaderCreator
import com.zqf.vagrantiptv.R


class App : Application() {

    override fun onCreate() {
        super.onCreate()
    }

    companion object {
        init {
            SmartRefreshLayout.setDefaultRefreshHeaderCreator(DefaultRefreshHeaderCreator { context, layout ->
                //设置刷新头的背景色
                layout.setPrimaryColorsId(R.color.white)
                return@DefaultRefreshHeaderCreator ClassicsHeader(context)
            })
            SmartRefreshLayout.setDefaultRefreshFooterCreator(DefaultRefreshFooterCreator { context, layout ->
                //设置滑动到底部自动加载更多
                layout.setEnableAutoLoadMore(false)
                return@DefaultRefreshFooterCreator ClassicsFooter(context).setDrawableSize(20f)
            })
        }
    }
}