package com.foray.foraypopupwindow.Adapters;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.foray.foraypopupwindow.ForayPopupWindow;
import com.foray.foraypopupwindow.Models.ForayNormalItem;
import com.foray.foraypopupwindow.Models.ForayWindowSettings;
import com.foray.foraypopupwindow.R;

import java.util.List;

public class NormalAdapters extends RecyclerView.Adapter<NormalAdapters.NormalItemView> {

    private ForayWindowSettings forayWindowSettings;
    private List<ForayNormalItem> normalItems;
    private ForayPopupWindow.OnItemListener onItemListener;

    public NormalAdapters(ForayWindowSettings forayWindowSettings, List<ForayNormalItem> normalItems, ForayPopupWindow.OnItemListener onItemListener){
        this.forayWindowSettings = forayWindowSettings;
        this.normalItems = normalItems;
        this.onItemListener = onItemListener;
    }

    public void setForayWindowSettings(ForayWindowSettings forayWindowSettings) {
        this.forayWindowSettings = forayWindowSettings;
    }

    public void setNormalItems(List<ForayNormalItem> normalItems) {
        this.normalItems = normalItems;
        notifyDataSetChanged();
    }

    public void setOnItemListener(ForayPopupWindow.OnItemListener onItemListener) {
        if(onItemListener != null)this.onItemListener = onItemListener;
    }

    public ForayWindowSettings getForayWindowSettings() {
        return forayWindowSettings;
    }

    public ForayPopupWindow.OnItemListener getOnItemListener() {
        return onItemListener;
    }

    public List<ForayNormalItem> getNormalItems() {
        return normalItems;
    }

    @NonNull
    @Override
    public NormalItemView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new NormalItemView(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_normal, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NormalItemView normalItemView, int i) {
        normalItemView.setup(normalItems.get(normalItemView.getAdapterPosition()), forayWindowSettings);
    }

    @Override
    public int getItemCount() {
        if(normalItems != null) return normalItems.size();
        return 0;
    }

    class NormalItemView extends RecyclerView.ViewHolder{

        private TextView tv_title;

        NormalItemView(@NonNull View itemView) {
            super(itemView);
            this.tv_title = (TextView) itemView;
        }

        private void setup(final ForayNormalItem forayNormalItem, ForayWindowSettings forayWindowSettings){
            tv_title.setText(forayNormalItem.getTitle());
            if(forayWindowSettings.getItemsHeight() != -1) tv_title.setHeight(forayWindowSettings.getItemsHeight());
            if(forayWindowSettings.getItemsTextSize() != -1) tv_title.setTextSize(forayWindowSettings.getItemsTextSize());
            tv_title.setTextColor(forayWindowSettings.getItemsTextColor());
            tv_title.setGravity(forayWindowSettings.getItemsTextGravity());
            if(forayWindowSettings.getItemsTextFont() != null) tv_title.setTypeface(forayWindowSettings.getItemsTextFont());
            if(forayWindowSettings.getItemsBackground() != -1) tv_title.setBackgroundResource(forayWindowSettings.getItemsBackground());

            tv_title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent data = new Intent();
                    data.putExtra(ForayPopupWindow.INTENT_DATA, forayNormalItem);
                    if(onItemListener != null) onItemListener.onItemClickListener(v, data, getAdapterPosition());
                }
            });
            tv_title.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Intent data = new Intent();
                    data.putExtra(ForayPopupWindow.INTENT_DATA, forayNormalItem);
                    if(onItemListener != null) onItemListener.onItemLongClickListener(v, data, getAdapterPosition());
                    return true;
                }
            });
        }
    }
}
