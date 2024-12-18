package com.example.mp3android.album;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mp3android.R;
import com.example.mp3android.artists.ArtistInterface;

public class AlbumViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView songName, artist;

    public AlbumViewHolder(@NonNull View itemView, ArtistInterface artistInterface) {
        super(itemView);
        imageView = itemView.findViewById(R.id.profilePic);
        songName = itemView.findViewById(R.id.songName);
        artist = itemView.findViewById(R.id.artist);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (artistInterface != null) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        artistInterface.onItemClick(pos);
                    }
                }
            }
        });
    }
}
