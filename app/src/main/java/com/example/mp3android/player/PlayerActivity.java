package com.example.mp3android.player;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mp3android.Item;
import com.example.mp3android.R;
import com.google.android.material.slider.Slider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlayerActivity extends AppCompatActivity implements View.OnClickListener{

    MediaPlayer mediaPlayer;
    Button play,forward, back;
    Slider slider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        String name = getIntent().getStringExtra("Artist_name");

        TextView artistName = findViewById(R.id.playText);

        int music = R.raw.twistedrock;

        // Media code
        mediaPlayer = MediaPlayer.create(this,music);
        play = (Button)findViewById(R.id.play);
        forward = (Button)findViewById(R.id.forward);
        back = (Button)findViewById(R.id.rewind);
        slider = findViewById(R.id.slider);


        slider.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {

                // TODO : fix this logical issue
                if (fromUser){
                    mediaPlayer.pause();
                    mediaPlayer.seekTo(mediaPlayer.getCurrentPosition() + (int)slider.getValue());
                    mediaPlayer.start();
                }
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mediaPlayer.isPlaying()){ // start the  music
                    play.setBackground(null);
                    play.setBackgroundResource(R.drawable.home_icon);
                    mediaPlayer.start();
                    artistName.setText(Float.toString(slider.getValue()));
                    sliderValueChange();
                }
                else { // stop it
                    play.setBackground(null);
                    play.setBackgroundResource(R.drawable.baseline_play_arrow_24);
                    mediaPlayer.pause();
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mediaPlayer.pause();
                mediaPlayer.seekTo(mediaPlayer.getCurrentPosition() - 100000);
            }
        });

        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.seekTo(mediaPlayer.getCurrentPosition() + 100000);
            }
        });

//        artistName.setText(name);

    }

    private void sliderValueChange(){
        new Thread(){
            @Override
            public void run(){
                try{
                    int currentPos = mediaPlayer.getCurrentPosition()/100;
                    slider.setValue((float) currentPos);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                sliderValueChange();
            }
        }.start();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.play) {

        }
    }
}