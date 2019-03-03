package com.foray.foraypopupwindow;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

import com.foray.foraypopupwindow.Adapters.AdapterWithIcon;
import com.foray.foraypopupwindow.Adapters.NormalAdapters;
import com.foray.foraypopupwindow.Models.ForayWindowSettings;
import com.foray.foraypopupwindow.Models.ForayNormalItem;
import com.foray.foraypopupwindow.Models.ForayWithIconItem;
import java.util.List;

public class ForayPopupWindow {

    public static final String INTENT_DATA = "data";
    private RecyclerView motherView;
    private PopupWindow window;
    private Context context;
    private View pinView;
    private List<ForayNormalItem> forayNormalItems;
    private List<ForayWithIconItem> forayWithIconItems;
    private ForayWindowSettings forayWindowSettings;
    private RecyclerView.Adapter adapter;
    private OnItemListener onItemListener;

    public ForayPopupWindow(Context context, View pinView, List<ForayNormalItem> forayNormalItems, ForayWindowSettings forayWindowSettings) {
        this.context = context;
        this.pinView = pinView;
        this.forayNormalItems = forayNormalItems;
        this.forayWindowSettings =forayWindowSettings;
        initNormalAdapter();
    }

    public ForayPopupWindow(Context context, List<ForayWithIconItem> forayWithIconItems, View pinView, ForayWindowSettings forayWindowSettings) {
        this.context = context;
        this.pinView = pinView;
        this.forayWithIconItems = forayWithIconItems;
        this.forayWindowSettings =forayWindowSettings;
    }

    public ForayPopupWindow(Context context, View pinView, RecyclerView.Adapter adapter, ForayWindowSettings forayWindowSettings) {
        this.context = context;
        this.pinView = pinView;
        this.adapter = adapter;
        this.forayWindowSettings =forayWindowSettings;
    }

    public void initWindow(){
        getMotherView().setHasFixedSize(true);
        getMotherView().setLayoutManager(new LinearLayoutManager(context));
        getMotherView().setAdapter(adapter);
        window = new PopupWindow(getMotherView(), forayWindowSettings.getWidth(), forayWindowSettings.getHeight());
        window.setOutsideTouchable(true);
    }

    public void showWindow(){
        window.showAsDropDown(pinView);
        initAdapterAnimation();
    }

    public void showWindow(int xoff, int yoff){
        window.showAsDropDown(pinView, xoff, yoff);
        initAdapterAnimation();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void showWindow(int xoff, int yoff, int gravity){
        window.showAsDropDown(pinView, xoff, yoff, gravity);
        initAdapterAnimation();
    }

    public void showWindowAtLocation(int gravity, int x, int y){
        window.showAtLocation(pinView, gravity, x, y);
        initAdapterAnimation();
    }

    private void initAdapterAnimation() {
        motherView.setLayoutAnimation(forayWindowSettings.getItemsAnimation(context));
        assert motherView.getAdapter() != null;
        motherView.getAdapter().notifyDataSetChanged();
        motherView.scheduleLayoutAnimation();
    }

    public boolean isShowing(){
        return window.isShowing();
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener){
        window.setOnDismissListener(onDismissListener);
    }

    public void setOutsideTouchable(Boolean touchable){
        window.setOutsideTouchable(touchable);
    }

    public void dismiss(){
        if(window.isShowing())this.window.dismiss();
    }

    @SuppressLint("InflateParams")
    private RecyclerView getMotherView() {
        if(motherView == null){
            motherView = (RecyclerView) LayoutInflater.from(context).inflate(R.layout.view_mother, null, false);
        }
        return motherView;
    }

    public PopupWindow getWindow(){
        return window;
    }

    public void setOnItemListener(OnItemListener onItemListener) {
        this.onItemListener = onItemListener;
    }

    private void initNormalAdapter(){
        adapter = new NormalAdapters(forayWindowSettings, forayNormalItems, onItemListener);
    }

    private void initWithIconAdapter(){
        adapter = new AdapterWithIcon(forayWindowSettings, forayWithIconItems, onItemListener);
    }

    public interface OnItemListener{
        void onItemClickListener(View view, Intent data, int position);
        void onItemLongClickListener(View view, Intent data, int position);
    }
}
