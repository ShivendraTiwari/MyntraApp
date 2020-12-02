package com.example.myntraapp;

public class TshirtApparel2SelectModel {

   // String image;
    String brandName;
    String tshirtName;
    String discount;
    String price;

    public TshirtApparel2SelectModel( String brandName, String tshirtName, String discount, String price) {
       //this.image = image;
        this.brandName = brandName;
        this.tshirtName = tshirtName;
        this.discount = discount;
        this.price = price;
    }

//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image= image;
//    }

    public TshirtApparel2SelectModel(){}

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getTshirtName() {
        return tshirtName;
    }

    public void setTshirtName(String tshirtName) {
        this.tshirtName = tshirtName;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
