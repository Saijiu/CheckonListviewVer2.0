package com.moi.showstateapplication;

/**
 * Created by moi on 2015/3/26.
 *
 */
public class Item {
    private String text;
    private int imageId;

    public Item(String text, int imageId) {
        this.text = text;
        this.imageId = imageId;
    }

    public String getText() {
        return text;
    }

    public int getImageId() {
        return imageId;
    }
}
