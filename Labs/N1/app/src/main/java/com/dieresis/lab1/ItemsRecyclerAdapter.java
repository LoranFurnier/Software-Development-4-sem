package com.dieresis.lab1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.dieresis.lab1.converter.AbstractNumberConverter;
import com.dieresis.lab1.converter.RuNumberConverter;

import static com.dieresis.lab1.R.drawable.image;

public class ItemsRecyclerAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    private static final int IO_BUFFER_SIZE = 4 * 1024;
    private AbstractNumberConverter mConverter;
    private LayoutInflater mInflater;
    private int mCount;

    public ItemsRecyclerAdapter(Context context, int count) {
        mConverter = new RuNumberConverter(context.getResources());
        mInflater = LayoutInflater.from(context);
        mCount = count;
    }
    
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(mInflater.inflate(R.layout.item_list, parent, false));
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        if (position % 2 == 0) {
            holder.itemView.setBackgroundResource(R.color.even_color);
        } else {
            holder.itemView.setBackgroundResource(R.color.odd_color);
        }
        holder.setImage("https://stroi.mos.ru/images/logo.png");
        holder.setItemText(mConverter.convert(position + 1));
    }

    @Override
    public int getItemCount() {
        return mCount;
    }
}
