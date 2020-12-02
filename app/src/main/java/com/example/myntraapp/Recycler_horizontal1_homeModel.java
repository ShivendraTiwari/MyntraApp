package com.example.myntraapp;

public class Recycler_horizontal1_homeModel {

    int image1;
    int image2;
    String img_title;
    String img_description;

    public Recycler_horizontal1_homeModel(int image1, int image2, String img_title, String img_description) {
        this.image1 = image1;
        this.image2 = image2;
        this.img_title = img_title;
        this.img_description = img_description;
    }

    public int getImage1() {
        return image1;
    }

    public void setImage1(int image1) {
        this.image1 = image1;
    }

    public int getImage2() {
        return image2;
    }

    public void setImage2(int image2) {
        this.image2 = image2;
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
