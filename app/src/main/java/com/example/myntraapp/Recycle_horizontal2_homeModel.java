package com.example.myntraapp;

public class Recycle_horizontal2_homeModel {

    int icon;
    int image1;
    String img_title;
    String img_description;

    public Recycle_horizontal2_homeModel(int icon, int image1, String img_title, String img_description) {
        this.icon = icon;
        this.image1 = image1;
        this.img_title = img_title;
        this.img_description = img_description;
    }

    public int getImage1() {
        return image1;
    }

    public void setImage1(int image1) {
        this.image1 = image1;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getImg_title() {
        return img_title;
    }

    public void setImg_title(String img_title) {
        this.img_title = img_title;
    }

    public String getImg_description() {
        return img_description;
    }

    public void setImg_description(String img_description) {
        this.img_description = img_description;
    }

}
