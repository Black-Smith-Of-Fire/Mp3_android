package com.example.mp3android.dj;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mp3android.R;
import com.google.android.material.slider.RangeSlider;
import com.google.android.material.slider.Slider;

import java.util.ArrayList;
import java.util.List;

public class DJViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView songName, artist;
    public RangeSlider rangeSlider;
    public ImageButton play;
    MediaPlayer mediaPlayer;

    public DJViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.artistImage1);
        songName = itemView.findViewById(R.id.songName1);
        artist = itemView.findViewById(R.id.artist2);
        rangeSlider = itemView.findViewById(R.id.slider);
        play = (ImageButton) itemView.findViewById(R.id.play);
        mediaPlayer = MediaPlayer.create(this.itemView.getContext(), R.raw.twistedrock);


        rangeSlider.addOnChangeListener(new RangeSlider.OnChangeListener(){
            @Override
            public void onValueChange(@NonNull RangeSlider slider, float value , boolean fromUser){
                List <Float> list = rangeSlider.getValues();
                Log.i("X , that is 0 : ", list.get(0).toString());

                if (fromUser) {
                    sliderValueChange(false);
                    try {
                        float ticksToMove = mediaPlayer.getDuration() / 100;
                        int position = (int) (ticksToMove * list.get(1));
                        mediaPlayer.seekTo(position);
                    }catch (Exception e) {
                        Log.e("X","Coming from addOnChangeListener");
                    }
                } else {
                    sliderValueChange(true);
                }
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mediaPlayer.isPlaying()) { // start the  music
                    play.setBackgroundResource(R.drawable.baseline_pause_24);
                    mediaPlayer.start();
                    sliderValueChange(true);
                }
                else { // stop it
                    play.setBackground(null);
                    play.setBackgroundResource(R.drawable.baseline_play_arrow_24);
                    mediaPlayer.pause();
                }
            }
        });
    }

    private void sliderValueChange(boolean user) {
        // TODO : Fix the
        if (!user) {
            return;
        }
        new Thread(){
            @Override
            public void run(){
                    int ticksToMove = mediaPlayer.getDuration() / 100;
                    int currentPos = 100 - (mediaPlayer.getDuration() - mediaPlayer.getCurrentPosition()) / ticksToMove;
                    List<Float> list = rangeSlider.getValues();
                    list.set(1,(float) currentPos);
                    Log.i("The values",list.toString());
                    rangeSlider.setValues(list);
                    if (list.get(1).equals(list.get(2))) {
                        mediaPlayer.pause();
                        nextInline(true);
                        return;
                    }

                    sliderValueChange(true);
            }
        }.start();
    }

    public void playMusic(){
        //TODO: after the music of one item is over, the music of the next item should continue
        mediaPlayer.start();
    }

    private boolean nextInline(boolean value){
        return value;
    }
}
