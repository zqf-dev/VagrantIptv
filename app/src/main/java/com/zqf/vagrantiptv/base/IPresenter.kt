package com.zqf.vagrantiptv.base

/**
 * Created by zqf on 2022/12/01.
 */
interface IPresenter<V : IView> {

    /**
     * 绑定 View
     */
    fun attachView(mView: V)

    /**
     * 解绑 View
     */
    fun detachView()

}