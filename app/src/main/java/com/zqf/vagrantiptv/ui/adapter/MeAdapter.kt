package com.zqf.vagrantiptv.ui.adapter

import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.zqf.vagrantiptv.R
import com.zqf.vagrantiptv.entity.MeRecycleEntity

class MeAdapter(layoutId: Int) : BaseQuickAdapter<MeRecycleEntity, BaseViewHolder>(layoutId) {
    override fun convert(holder: BaseViewHolder, item: MeRecycleEntity) {
        Glide.with(context).load(item.img).into(holder.getView(R.id.me_recycle_item_left_iv))
        holder.setText(R.id.me_recycle_item_left_tv, item.title)
    }

}