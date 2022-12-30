package com.zqf.vagrantiptv.ui.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.zqf.vagrantiptv.R

class DiscoverAdapter(layoutId: Int) : BaseQuickAdapter<String, BaseViewHolder>(layoutId) {
    override fun convert(holder: BaseViewHolder, item: String) {
        holder.setText(R.id.dis_tv, item)
    }
}