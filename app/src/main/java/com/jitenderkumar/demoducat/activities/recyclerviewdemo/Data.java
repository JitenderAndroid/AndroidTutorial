package com.jitenderkumar.demoducat.activities.recyclerviewdemo;

public class Data {

    public Data(String image, String title) {
        this.image = image;
        this.title = title;
    }

    String image;
    String title;
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
