package com.example.myntraapp;

public class BottomSheetModel {

    String content;
   // String recipient;


    public BottomSheetModel(String content) {
        this.content = content;
        //this.recipient = recipient;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

//    public String getRecipient() {
//        return recipient;
//    }
//
//    public void setRecipient(String recipient) {
//        this.recipient = recipient;
//    }
}
