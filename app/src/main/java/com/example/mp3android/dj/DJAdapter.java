package com.example.mp3android.dj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mp3android.Item;
import com.example.mp3android.R;

import java.util.List;

public class DJAdapter extends RecyclerView.Adapter<DJViewHolder> {

    private List<Item> items;
    private final DJInterface djInterface;

    public DJAdapter(List<Item> items, DJInterface djInterface) {
        this.items = items;
        this.djInterface = djInterface;
    }

    @NonNull
    @Override
    public DJViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.dj_list, parent,false);
        return new DJViewHolder(itemView, djInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull DJViewHolder holder, int position) {
        holder.imageView.setImageResource(items.get(position).getImage());
        holder.songName.setText(items.get(position).getName());
        holder.artist.setText(items.get(position).getName());
//        if (holder.nextMusic) {
//
//        }
//        holder.rangeSlider.setValues(items.get(position).getValues());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
