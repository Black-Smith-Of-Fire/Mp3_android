package com.example.mp3android;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PlaylistViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;

    public PlaylistViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageview);
    }
}
