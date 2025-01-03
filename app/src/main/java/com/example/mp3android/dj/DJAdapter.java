package com.example.mp3android.dj;

import android.media.MediaPlayer;
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
    MediaPlayer mediaPlayer;
//    boolean switchOnMusic;

    public DJAdapter(List<Item> items, MediaPlayer mediaPlayer, DJInterface djInterface) {
        this.items = items;
        this.djInterface = djInterface;
        this.mediaPlayer = mediaPlayer;
//        this.switchOnMusic = switchOnMusic;
    }

    @NonNull
    @Override
    public DJViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.dj_list, parent,false);
        return new DJViewHolder(itemView, items, mediaPlayer, djInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull DJViewHolder holder, int position) {
        holder.imageView.setImageResource(items.get(position).getImage());
        holder.songName.setText(items.get(position).getName());
        holder.artist.setText(items.get(position).getName());
//        if (items.get(position).getSwitchOnMusic()){
//            mediaPlayer.start();
//        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
