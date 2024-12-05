package com.example.mp3android.dj;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mp3android.R;

public class DJViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView songName, artist;

    public DJViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.artistImage1);
        songName = itemView.findViewById(R.id.songName1);
        artist = itemView.findViewById(R.id.artist2);
    }
}
