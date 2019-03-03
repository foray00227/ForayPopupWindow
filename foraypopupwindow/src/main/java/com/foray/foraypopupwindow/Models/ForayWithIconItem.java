package com.foray.foraypopupwindow.Models;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class ForayWithIconItem implements Serializable {

    private String title;
    private Drawable icon;

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
