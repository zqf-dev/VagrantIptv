package com.zqf.vagrantiptv.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class TabTypeMultiEntity implements MultiItemEntity {
    public int type;
    public String url;
    public String title;

    public TabTypeMultiEntity(int type, String url, String title) {
        this.type = type;
        this.url = url;
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int getItemType() {
        return type;
    }
}
