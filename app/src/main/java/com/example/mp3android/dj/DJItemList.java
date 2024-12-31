package com.example.mp3android.dj;

import android.media.MediaPlayer;

import com.example.mp3android.Item;
import com.example.mp3android.R;

import java.util.ArrayList;
import java.util.List;

public class DJItemList {

    List<ActivitySwitcher> it = new ArrayList<>();
    MediaPlayer mediaPlayer;

    public List<ActivitySwitcher> itemList() {
        mediaPlayer= new MediaPlayer();
        List <Float> bro = new ArrayList<>();
        bro.add(0,0.0f);
        bro.add(0,0.0f);
        bro.add(0,100.0f);
        it.add(new ActivitySwitcher(R.drawable.blacksmith,R.raw.twistedrock,bro,true,mediaPlayer));
//        it.add(new Item(R.drawable.blacksmith,"Chris", R.raw.twistedrock,true));
//        it.add(new Item(R.drawable.blacksmith,"Chris", R.raw.twistedrock,true));
//        it.add(new Item(R.drawable.blacksmith,"Chris", R.raw.twistedrock,true));
//        it.add(new Item(R.drawable.blacksmith,"Chris", R.raw.twistedrock,true));
//        it.add(new Item(R.drawable.blacksmith,"Chris", R.raw.twistedrock,true));
//        it.add(new Item(R.drawable.blacksmith,"Paro", R.raw.paro,false));
//        it.add(new Item(R.drawable.blacksmith,"Paro", R.raw.paro,false));
//        it.add(new Item(R.drawable.blacksmith,"Paro", R.raw.paro,false));
//        it.add(new Item(R.drawable.blacksmith,"Paro", R.raw.paro,false));
//        it.add(new Item(R.drawable.blacksmith,"Paro", R.raw.paro,false));
        return it;
    }
}
