package com.example.mp3android;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ArtistsViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;

    public ArtistsViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageview);
    }
}
