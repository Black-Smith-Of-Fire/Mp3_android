package com.example.mp3android.album;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mp3android.Item;
import com.example.mp3android.album.AlbumViewHolder;
import com.example.mp3android.R;
import com.example.mp3android.artists.ArtistInterface;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumViewHolder> {

    private final ArtistInterface artistInterface;
    private List<Item> items;
    private List<Item> names;

    public AlbumAdapter(List<Item> items,ArtistInterface artistInterface) {
        this.artistInterface = artistInterface;
        this.items = items;
        this.names = names;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.songlist_view, parent,false);
        return new AlbumViewHolder(itemView,artistInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        holder.imageView.setImageResource(items.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
