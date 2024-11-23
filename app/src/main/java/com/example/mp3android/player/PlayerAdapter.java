package com.example.mp3android.player;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mp3android.Item;
import com.example.mp3android.R;
import com.example.mp3android.playlist.PlaylistViewHolder;

import java.util.List;

public class PlayerAdapter extends RecyclerView.Adapter<PlaylistViewHolder> {

    private List<Item> items;

    public PlayerAdapter(List<Item> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public PlaylistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.playlist_view, parent,false);
        return new PlaylistViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaylistViewHolder holder, int position) {
        holder.imageView.setImageResource(items.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
