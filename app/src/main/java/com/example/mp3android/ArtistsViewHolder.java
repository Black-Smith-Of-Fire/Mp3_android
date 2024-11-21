package com.example.mp3android;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ArtistsViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;

    public ArtistsViewHolder(@NonNull View itemView, ArtistInterface artistInterface) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageview);

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
