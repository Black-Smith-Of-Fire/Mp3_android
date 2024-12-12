/* TODO : The rangeslider code can be implemented here or in the viewholder. So the items values of all the items are passed either to the viewholder or to this class
 the idea is to pass the items to the viewholder, and to let this class get and update the values of that items. As soon as index 1 and 2 are equal , the adapter will take over the action */

package com.example.mp3android.dj;

import android.media.MediaPlayer;
import android.util.Log;
import java.util.List;


public class ActivitySwitcher {
    MediaPlayer mediaPlayer;
    DJItemList lol = new DJItemList();
    DJViewHolder dj ;

    ActivitySwitcher(int image, int songName, List<Float> items, boolean switchOnMusic, MediaPlayer mediaPlayer){
         dj = new DJViewHolder();
        if (switchOnMusic) {
            sliderValueChange(true,items);
        }

        this.mediaPlayer = mediaPlayer;

        if (lol.itemList().get(0).getSwitchOnMusic()) {
            mediaPlayer.start();
        }
    }


    private void sliderValueChange(boolean user, List<Float> items) {
        if (!user) {
            return;
        }
        else {
            new Thread() {
                @Override
                public void run() {
                    float i = items.get(1);
                    i ++;
                    items.set(1,i);

                    if (items.get(1).equals(items.get(2))) {
                        return; /*Don't u dare remove this,*/
                    }
                    dj.rangeSlider.setValues(items);
                    System.out.println("" + items);
                    sliderValueChange(true,items);
                }
            }.start();
        }
    }
}
