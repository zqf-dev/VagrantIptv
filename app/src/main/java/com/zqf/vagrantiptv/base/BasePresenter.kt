package com.zqf.vagrantiptv.base

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import java.lang.ref.WeakReference

abstract class BasePresenter<V : BaseIView> : IPresenter<V>, DefaultLifecycleObserver {

    lateinit var mView: WeakReference<V>

    var mCoroutineScope = CoroutineScope(Dispatchers.Main)

    override fun attachView(view: V) {
        mView = WeakReference<V>(view)
    }

    override fun detachView() {
        mView.clear()
        mCoroutineScope.cancel()
    }

    open fun getView(): V? {
        return mView.get()
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        detachView()
    }
}