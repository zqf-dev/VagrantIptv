package com.zqf.vagrantiptv.utils

/** 拦截日志 */
interface LogHook {

    fun hook(info: LogInfo)
}