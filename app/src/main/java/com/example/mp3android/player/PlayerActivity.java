package com.example.mp3android.player;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mp3android.R;
import com.google.android.material.slider.Slider;

import java.util.logging.Logger;

//TODO : the app keeps crashing when music is being played because of line number 127 artistname.setText

public class PlayerActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    ImageButton  forward, back;
    Button play;
    Slider slider;
    boolean user;
    TextView artistName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        String name = getIntent().getStringExtra("Artist_name");

        artistName = findViewById(R.id.playText);

        int music = musicHandler(name);

        // Media code
        mediaPlayer = MediaPlayer.create(this,music);
        play = (Button)findViewById(R.id.play);
        forward = (ImageButton)findViewById(R.id.forward);
        back = (ImageButton)findViewById(R.id.rewind);
        slider = findViewById(R.id.slider);


        slider.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                if (fromUser) {
                    sliderValueChange(false);
                    try {
                        int ticksToMove = mediaPlayer.getDuration() / 100;
                        mediaPlayer.seekTo(ticksToMove * (int) slider.getValue());
                        mediaPlayer.start();
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
//                    play.setBackground(getResources().getDrawable(R.drawable.round_button));
//                    play.setImageResource(R.drawable.round_button);
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

    private int musicHandler(String name){
        if (name.equals("Twisted")) {
            return R.raw.twistedrock;
        }
        else if (name.equals("Paro")) {
            return R.raw.paro;
        }
        else {
            return 0;
        }
    }

    private void sliderValueChange(boolean user) {
        // TODO : Fix the TextView setText
        if (!user) {
            return;
        }
        new Thread(){
            @Override
            public void run(){
                try{
                    int ticksToMove = mediaPlayer.getDuration() / 100;
                    int currentPos = 100 - (mediaPlayer.getDuration() - mediaPlayer.getCurrentPosition()) / ticksToMove;
//                    artistName.setText(currentPos);
                    slider.setValue((float) currentPos);
//                    artistName.setText(Float.toString(slider.getValue())); // This code somehow is giving an error , check this out
                }
                catch (Exception e) {
                    Log.e("Y","Coming from sliderValueChange");
                }
                sliderValueChange(true);
            }
        }.start();
    }

}