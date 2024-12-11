package com.example.mp3android.dj;

import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;

import com.example.mp3android.Item;
import com.example.mp3android.R;
import com.google.android.material.slider.RangeSlider;

import java.util.List;

public class ActivitySwitcher {

    public RangeSlider rangeSlider;
    public ImageButton play;
    public boolean nextMusic = false;
    MediaPlayer mediaPlayer;
    DJInterface djInterface;
    DJItemList itemList = new DJItemList();
    List<Item> items;
//    int position = parent.;

    public ActivitySwitcher(RangeSlider rangeSlider, ImageButton play){

        this.djInterface = djInterface;
        rangeSlider = this.rangeSlider;
        play = (ImageButton) itemView.findViewById(R.id.play);
        this.mediaPlayer = mediaPlayer;
        this.items = items;


        if (items.get(getPos()).getSwitchOnMusic()) {
            mediaPlayer.start();
            Log.i("Mediaplayer is playing : ", "true");
            sliderValueChange(true);
        }else {
            Log.i("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!", "false");
        }

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
        else if (mediaPlayer.isPlaying()) {
            new Thread() {
                @Override
                public void run() {
                    int ticksToMove = mediaPlayer.getDuration() / 100;
                    int currentPos = 100 - (mediaPlayer.getDuration() - mediaPlayer.getCurrentPosition()) / ticksToMove;
                    List<Float> list = rangeSlider.getValues();
                    list.set(1, (float) currentPos);
                    Log.i("The values", list.toString());
                    rangeSlider.setValues(list);
                    if (list.get(1).equals(list.get(2))) {
                        mediaPlayer.pause();
//                        mediaPlayer.release();
//                        if (djInterface != null) {
//                            int pos = getAbsoluteAdapterPosition();
//                            if (pos != RecyclerView.NO_POSITION) {
//                                items.get(position).setSwitchOnMusic(false);
//                        setPos(1);
//                        Log.i("Size of the item : ","" + items.size());
//                        Log.i(" and this is after its increment : ", "" + getPos());
//                        djInterface.nextTrack(getPos());
//                            }
//                        }
                        return; /*Don't u dare remove this,
                        coz u need to return as soon as the middle and the last sliders are in the same position*/
                    }

                    sliderValueChange(true);
                }
            }.start();
        }
    }

}
