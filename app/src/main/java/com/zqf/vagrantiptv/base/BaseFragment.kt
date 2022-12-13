package com.zqf.vagrantiptv.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

abstract class BaseFragment<VB : ViewBinding, P : BasePresenter<out IView>> : Fragment() {

    lateinit var mPresenter: P
    lateinit var mVBind: VB
    lateinit var mContext: FragmentActivity

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mContext = requireActivity()
        mPresenter = getPresenter()
        lifecycle.addObserver(mPresenter)
        val type = javaClass.genericSuperclass
        val clazz = (type as ParameterizedType).actualTypeArguments[0] as Class<VB>
        val method = clazz.getMethod(
            "inflate",
            LayoutInflater::class.java,
            ViewGroup::class.java,
            Boolean::class.java
        )
        mVBind = method.invoke(null, layoutInflater, container, false) as VB
        return mVBind.root
    }

    abstract fun getPresenter(): P
}