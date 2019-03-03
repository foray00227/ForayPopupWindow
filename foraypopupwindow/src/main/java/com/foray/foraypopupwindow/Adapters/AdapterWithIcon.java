package com.foray.foraypopupwindow.Adapters;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.foray.foraypopupwindow.ForayPopupWindow;
import com.foray.foraypopupwindow.Models.ForayNormalItem;
import com.foray.foraypopupwindow.Models.ForayWindowSettings;
import com.foray.foraypopupwindow.Models.ForayWithIconItem;
import com.foray.foraypopupwindow.R;

import java.util.List;

public class AdapterWithIcon extends RecyclerView.Adapter<AdapterWithIcon.NormalItemView> {

    private ForayWindowSettings forayWindowSettings;
    private List<ForayWithIconItem> normalItems;
    private ForayPopupWindow.OnItemListener onItemListener;

    public AdapterWithIcon(ForayWindowSettings forayWindowSettings, List<ForayWithIconItem> normalItems, ForayPopupWindow.OnItemListener onItemListener){
        this.forayWindowSettings = forayWindowSettings;
        this.normalItems = normalItems;
        this.onItemListener = onItemListener;
    }

    public void setForayWindowSettings(ForayWindowSettings forayWindowSettings) {
        this.forayWindowSettings = forayWindowSettings;
    }

    public void setNormalItems(List<ForayWithIconItem> normalItems) {
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

    public List<ForayWithIconItem> getNormalItems() {
        return normalItems;
    }

    @NonNull
    @Override
    public NormalItemView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new NormalItemView(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_with_icon, viewGroup, false));
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
        private ImageView img_icon;
        private View motherView;

        NormalItemView(@NonNull View itemView) {
            super(itemView);
            motherView = itemView;
            this.tv_title = itemView.findViewById(R.id.tv_title);
            this.img_icon = itemView.findViewById(R.id.img_icon);
        }

        private void setup(final ForayWithIconItem forayWithIconItem, ForayWindowSettings forayWindowSettings){
            tv_title.setText(forayWithIconItem.getTitle());
            if(forayWithIconItem.getIcon() != null) img_icon.setImageDrawable(forayWithIconItem.getIcon());
            if(forayWindowSettings.getItemsHeight() != -1) tv_title.setHeight(forayWindowSettings.getItemsHeight());
            if(forayWindowSettings.getItemsTextSize() != -1) tv_title.setTextSize(forayWindowSettings.getItemsTextSize());
            tv_title.setTextColor(forayWindowSettings.getItemsTextColor());
            tv_title.setGravity(forayWindowSettings.getItemsTextGravity());
            if(forayWindowSettings.getItemsTextFont() != null) tv_title.setTypeface(forayWindowSettings.getItemsTextFont());
            if(forayWindowSettings.getItemsBackground() != -1) tv_title.setBackgroundResource(forayWindowSettings.getItemsBackground());

            motherView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent data = new Intent();
                    data.putExtra(ForayPopupWindow.INTENT_DATA, forayWithIconItem);
                    if(onItemListener != null) onItemListener.onItemClickListener(v, data, getAdapterPosition());
                }
            });
            motherView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Intent data = new Intent();
                    data.putExtra(ForayPopupWindow.INTENT_DATA, forayWithIconItem);
                    if(onItemListener != null) onItemListener.onItemLongClickListener(v, data, getAdapterPosition());
                    return true;
                }
            });
        }
    }
}
