package com.example.mp3android.album;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mp3android.R;

public class AlbumViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;

    public AlbumViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.profilePic);
    }
}
