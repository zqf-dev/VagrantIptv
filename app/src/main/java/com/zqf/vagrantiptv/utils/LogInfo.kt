package com.zqf.vagrantiptv.utils

/**
 * @param type 等级
 * @param msg 消息, 如果消息为null会终止Hook拦截, 并且不会输出日志
 * @param  tag 标签
 * @param tr 异常堆栈
 * @param occurred 发生位置
 */
data class LogInfo(
    var type: FLog.Type,
    var msg: String?,
    var tag: String,
    var tr: Throwable?,
    var occurred: Throwable? = null,
)
