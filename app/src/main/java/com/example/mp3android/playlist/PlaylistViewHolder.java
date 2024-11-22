package com.example.mp3android.playlist;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mp3android.R;

public class PlaylistViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;

    public PlaylistViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageview);
    }
}
