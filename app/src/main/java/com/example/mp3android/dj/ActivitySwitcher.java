package com.example.mp3android.dj;

import android.media.MediaPlayer;

import java.util.List;

public class ActivitySwitcher {
    MediaPlayer mediaPlayer;
    DJItemList lol = new DJItemList();

    ActivitySwitcher(int image, int songName, List<Float> items, MediaPlayer mediaPlayer){
        this.mediaPlayer = mediaPlayer;
        if (lol.itemList().get(0).getSwitchOnMusic()) {
            mediaPlayer.start();
        }
    }
}
