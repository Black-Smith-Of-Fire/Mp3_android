package com.example.mp3android.dj;

import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mp3android.Item;
import com.example.mp3android.R;
import com.google.android.material.slider.RangeSlider;

import java.util.List;

public class DJViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView songName, artist;
    public RangeSlider rangeSlider;
    public ImageButton play;
    public boolean nextMusic = false;
    MediaPlayer mediaPlayer;
    DJInterface djInterface;
    DJItemList itemList = new DJItemList();
    List<Item> items;
    int position = 0;

    public DJViewHolder(@NonNull View itemView , List<Item> items, MediaPlayer mediaPlayer, DJInterface djInterface) {
        super(itemView);

        this.djInterface = djInterface;
        imageView = itemView.findViewById(R.id.artistImage1);
        songName = itemView.findViewById(R.id.songName1);
        artist = itemView.findViewById(R.id.artist2);
        rangeSlider = itemView.findViewById(R.id.slider);
        play = (ImageButton) itemView.findViewById(R.id.play);
        this.mediaPlayer = mediaPlayer;
        this.items = items;


//        new ActivitySwitcher(mediaPlayer);

        if (mediaPlayer.isPlaying()){
            sliderValueChange(true);
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
                                items.get(position).setSwitchOnMusic(false);
//                                setPos(1);
//                                Log.i("Size of the item : ","" + items.size());
//                                Log.i(" and this is after its increment : ", "" + getPos());
                                djInterface.nextTrack(1);
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

    public int getPos(){
        return  position;
    }
    public void setPos(int position) {
        this.position = position;
    }

    private boolean nextInline(boolean value){
        return value;
    }
}
