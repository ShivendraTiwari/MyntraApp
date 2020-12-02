package com.example.myntraapp;

import java.util.ArrayList;

public class GroupInfo_Expandable {

    private String name;
    private ArrayList<ChildInfo_Men_Model> list = new ArrayList<ChildInfo_Men_Model>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ChildInfo_Men_Model> getProductList() {
        return list;
    }

    public void setProductList(ArrayList<ChildInfo_Men_Model> productList) {
        this.list = productList;
    }

}

