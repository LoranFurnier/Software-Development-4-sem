package com.dieresis.lab1;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class ItemViewHolder extends RecyclerView.ViewHolder {
    private TextView mItemText;
    private ImageView mImageView;
    public ItemViewHolder(View itemView) {
        super(itemView);
        mItemText = itemView.findViewById(R.id.item_text);
        mImageView = itemView.findViewById(R.id.image_view);
    }

    public void setItemText(String text) {
        mItemText.setText(text);
    }

    public void setImage(String r) {
        new ImageLoadTask(r, mImageView).execute();
    }
}
