package com.example.mp3android.player;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mp3android.Item;
import com.example.mp3android.R;
import com.google.android.material.slider.Slider;

import java.util.ArrayList;
import java.util.List;

public class PlayerActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    Button play,forward, back;
    Slider slider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        String name = getIntent().getStringExtra("Artist_name");

        TextView artistName = findViewById(R.id.playText);

        int lol = R.raw.twistedrock;

        // Media code
        mediaPlayer = MediaPlayer.create(this,lol);
        play = (Button)findViewById(R.id.play);
        forward = (Button)findViewById(R.id.forward);
        back = (Button)findViewById(R.id.rewind);
        slider = findViewById(R.id.slider);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mediaPlayer.isPlaying()){ // start the  music
                    play.setBackground(null);
                    play.setBackgroundResource(R.drawable.home_icon);
                    mediaPlayer.start();
                    artistName.setText("" + mediaPlayer.getCurrentPosition()); // Just to see what is the current timeline of the song
                    int currentPos = (mediaPlayer.getCurrentPosition()/100); // creating a variable that the slider can use to change its current position
                    slider.setValue((float) currentPos); // casting currentPos to float
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

    private List<Item> itemList() {

        List<Item> it = new ArrayList<>();
        it.add(new Item(R.drawable.blacksmith,"Chris"));
        it.add(new Item(R.drawable.blacksmith,"Jaime"));
        it.add(new Item(R.drawable.blacksmith,"Sara"));
        it.add(new Item(R.drawable.blacksmith,"Napoleon"));
        it.add(new Item(R.drawable.blacksmith,"Dj malone"));
        it.add(new Item(R.drawable.blacksmith,"Indila"));
        it.add(new Item(R.drawable.blacksmith,"Terry"));
        it.add(new Item(R.drawable.blacksmith,"Davis"));
        it.add(new Item(R.drawable.blacksmith,"Burger king"));
        it.add(new Item(R.drawable.blacksmith,"Shomw"));
        it.add(new Item(R.drawable.blacksmith,"Carmine"));
        return it;
    }

}