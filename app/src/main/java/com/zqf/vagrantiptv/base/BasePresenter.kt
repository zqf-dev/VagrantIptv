package com.zqf.vagrantiptv.base

import androidx.lifecycle.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import java.lang.ref.WeakReference

abstract class BasePresenter<V : IView> : IPresenter<V>, DefaultLifecycleObserver {

    private var mView: WeakReference<V>? = null

    var mCoroutineScope = CoroutineScope(Dispatchers.Main)

    override fun attachView(view: V) {
        mView = WeakReference<V>(view)
    }

    override fun detachView() {
        mView?.clear()
        mCoroutineScope.cancel()
    }

    open fun getView(): V? {
        if (mView != null) {
            return mView!!.get()
        }
        return null
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        detachView()
    }
}