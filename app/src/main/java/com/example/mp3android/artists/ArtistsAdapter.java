package com.example.mp3android.artists;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mp3android.Item;
import com.example.mp3android.R;

import java.util.List;

public class ArtistsAdapter extends RecyclerView.Adapter<ArtistsViewHolder> {

    private final ArtistInterface artistInterface;
    private List<Item> items;

    public ArtistsAdapter(List<Item> items, ArtistInterface artistInterface) {
        this.artistInterface = artistInterface;
        this.items = items;
    }

    @NonNull
    @Override
    public ArtistsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.artists_view, parent,false);
        return new ArtistsViewHolder(itemView, artistInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtistsViewHolder holder, int position) {
        holder.imageView.setImageResource(items.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
