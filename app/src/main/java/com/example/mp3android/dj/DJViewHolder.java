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

//        rangeSlider.addOnSliderTouchListener(new RangeSlider.OnSliderTouchListener() {
//            @Override
//            public void onStartTrackingTouch(@NonNull RangeSlider slider) {
//                Log.i("Slider's X value is : ","X is working , hurray");
//            }
//
//            @Override
//            public void onStopTrackingTouch(@NonNull RangeSlider slider) {
//                Log.i("Slider's Y value is : ", list.get(1).toString());
//
//            }
//        });

        rangeSlider.addOnChangeListener(new RangeSlider.OnChangeListener(){
            @Override
            public void onValueChange(@NonNull RangeSlider slider, float value , boolean fromUser){
                List <Float> list = rangeSlider.getValues();
                Toast.makeText(itemView.getContext(),"X: " + list.get(0) ,Toast.LENGTH_SHORT).show();
                Toast.makeText(itemView.getContext(),"Y: " + list.get(1) ,Toast.LENGTH_SHORT).show();
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int music = R.raw.twistedrock;

                if(!mediaPlayer.isPlaying()) { // start the  music
                    play.setBackgroundResource(R.drawable.baseline_pause_24);
//                    play.setBackground(getResources().getDrawable(R.drawable.round_button));
//                    play.setImageResource(R.drawable.round_button);
                    mediaPlayer.start();
                }
                else { // stop it
                    play.setBackground(null);
                    play.setBackgroundResource(R.drawable.baseline_play_arrow_24);
                    mediaPlayer.pause();
                }
            }
        });
    }
}
