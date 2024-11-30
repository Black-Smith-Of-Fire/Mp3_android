package com.example.mp3android.player;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mp3android.R;
import com.google.android.material.slider.Slider;

//TODO : the app keeps crashing when music is being played. It may have to do something with the memory , fix it

public class PlayerActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    Button play,forward, back;
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
        forward = (Button)findViewById(R.id.forward);
        back = (Button)findViewById(R.id.rewind);
        slider = findViewById(R.id.slider);


        slider.addOnChangeListener(new Slider.OnChangeListener() {
            // ISSUE : crashing the app
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                // TODO : fix this logical issue
                if (fromUser) {
                    sliderValueChange(false);
                    int ticksToMove = mediaPlayer.getDuration() / 100;
//                    user = true;
                    mediaPlayer.seekTo(ticksToMove * (int)slider.getValue());
                    mediaPlayer.start();
                } else {
                    sliderValueChange(true);
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
        // ISSUE : crashing the app
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
                    artistName.setText(Float.toString(slider.getValue()));
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                sliderValueChange(true);
            }
        }.start();
    }

}