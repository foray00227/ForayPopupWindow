package com.foray.foraypopupwindow.Models;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.WindowManager;
import android.view.animation.LayoutAnimationController;

import com.foray.foraypopupwindow.Anim.ForayAnimationManager;

import java.io.Serializable;

public class ForayWindowSettings implements Serializable {

    private int Width = WindowManager.LayoutParams.WRAP_CONTENT;
    private int Height = WindowManager.LayoutParams.WRAP_CONTENT;
    private Drawable background = null;
    private int ItemsHeight = -1;
    private int ItemsTextSize = -1;
    private int ItemsTextColor = Color.BLACK;
    private int ItemsTextGravity = Gravity.CENTER;
    private Typeface ItemsTextFont = null;
    private int ItemsBackground = -1;
    private LayoutAnimationController ItemsAnimation = null;

    public int getItemsHeight() {
        return ItemsHeight;
    }

    public void setItemsHeight(int itemsHeight) {
        ItemsHeight = itemsHeight;
    }

    public Drawable getBackground() {
        return background;
    }

    public void setBackground(Drawable background) {
        this.background = background;
    }

    public int getWidth() {
        return Width;
    }

    public void setWidth(int width) {
        Width = width;
    }

    public int getHeight() {
        return Height;
    }

    public void setHeight(int height) {
        Height = height;
    }

    public int getItemsTextSize() {
        return ItemsTextSize;
    }

    public void setItemsTextSize(int itemsTextSize) {
        ItemsTextSize = itemsTextSize;
    }

    public int getItemsTextColor() {
        return ItemsTextColor;
    }

    public void setItemsTextColor(int itemsTextColor) {
        ItemsTextColor = itemsTextColor;
    }

    public int getItemsTextGravity() {
        return ItemsTextGravity;
    }

    public void setItemsTextGravity(int itemsTextGravity) {
        ItemsTextGravity = itemsTextGravity;
    }

    public Typeface getItemsTextFont() {
        return ItemsTextFont;
    }

    public void setItemsTextFont(Typeface itemsTextFont) {
        ItemsTextFont = itemsTextFont;
    }

    public int getItemsBackground() {
        return ItemsBackground;
    }

    public void setItemsBackground(int itemsBackground) {
        ItemsBackground = itemsBackground;
    }

    public LayoutAnimationController getItemsAnimation(Context context) {
        if(ItemsAnimation == null) return ForayAnimationManager.getAlphaAnimation(context);
        return ItemsAnimation;
    }

    public void setItemsAnimation(LayoutAnimationController itemsAnimation) {
        ItemsAnimation = itemsAnimation;
    }
}
