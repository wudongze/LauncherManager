package com.example.wudz.launchermanager.model;

/**
 * USER：wudz on 2016/11/18 14:04
 * <p>
 * EMAIL：wudz@qianbaocard.com
 * <p>
 * TODO
 */

public class HeaderModel extends BaseModel {
    private String name;
    private String path;
    private int image;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
