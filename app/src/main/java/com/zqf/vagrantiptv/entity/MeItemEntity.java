package com.zqf.vagrantiptv.entity;

/**
 * Author: zqf
 * Date: 2021/12/29
 */
public class MeItemEntity {

    private Integer img;
    private String title;

    public MeItemEntity(Integer img, String title) {
        this.img = img;
        this.title = title;
    }

    public Integer getImg() {
        return img;
    }

    public void setImg(Integer img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
