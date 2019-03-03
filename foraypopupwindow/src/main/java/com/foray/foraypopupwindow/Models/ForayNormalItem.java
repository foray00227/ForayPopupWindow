package com.foray.foraypopupwindow.Models;

import java.io.Serializable;

public class ForayNormalItem implements Serializable {

    private String title;

    public ForayNormalItem(){}

    public ForayNormalItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
