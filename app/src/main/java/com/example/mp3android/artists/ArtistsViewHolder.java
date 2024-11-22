package com.example.mp3android.artists;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mp3android.R;

public class ArtistsViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView nameView;

    public ArtistsViewHolder(@NonNull View itemView, ArtistInterface artistInterface) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageview);
        nameView = itemView.findViewById(R.id.name);

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
