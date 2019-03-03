package com.foray.recordma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.foray.foraypopupwindow.Anim.ForayAnimationManager;
import com.foray.foraypopupwindow.ForayPopupWindow;
import com.foray.foraypopupwindow.Models.ForayNormalItem;
import com.foray.foraypopupwindow.Models.ForayWindowSettings;

import java.util.ArrayList;
import java.util.List;

public class App extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void normalPopupWindow(View view){
        ForayWindowSettings settings = new ForayWindowSettings();
//        settings.setBackground(); //set window background
          settings.setWidth(160); //set window width
//        settings.setHeight(); //set window height
          settings.setItemsAnimation(ForayAnimationManager.getAlphaAnimation(this)); //set animation displaying items
//        settings.setItemsBackground(); //set background for items
//        settings.setItemsHeight(); //set items height
//        settings.setItemsTextColor(); //set items text color
//        settings.setItemsTextFont(); //set items font
//        settings.setItemsTextGravity(); //set items text gravity
//        settings.setItemsTextSize(); //set items text size
        ForayPopupWindow popupWindow = new ForayPopupWindow(this, view, getNormalList(), settings);
        popupWindow.initWindow();
        popupWindow.showWindow();
    }

    private List<ForayNormalItem> getNormalList() {
        List<ForayNormalItem> normalItems = new ArrayList<>();
        normalItems.add(new ForayNormalItem("Title 1"));
        normalItems.add(new ForayNormalItem("Title 2"));
        normalItems.add(new ForayNormalItem("Title 3"));
        normalItems.add(new ForayNormalItem("Title 4"));
        normalItems.add(new ForayNormalItem("Title 5"));
        normalItems.add(new ForayNormalItem("Title 6"));
        //.
        //.
        //.
        return normalItems;
    }
}
