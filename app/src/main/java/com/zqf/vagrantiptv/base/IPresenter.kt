package com.zqf.vagrantiptv.base

/**
 * Created by zqf on 2022/12/01.
 */
interface IPresenter<V : BaseIView> {

    /**
     * 绑定 View
     */
    fun attachView(view: V)

    /**
     * 解绑 View
     */
    fun detachView()

}