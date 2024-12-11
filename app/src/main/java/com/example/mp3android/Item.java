package com.example.mp3android;

import android.media.MediaPlayer;

import java.util.List;

public class Item {
    String name;
    int image;
    int music;
    List<Float> values;
    MediaPlayer mediaPlayer;
    boolean switchOnMusic;

    public Item(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public Item(int image, String name, int music) {
        this.image = image;
        this.name = name;
        this.music = music;
    }


    public Item(int image, String name, int music, boolean switchOnMusic) {
        this.image = image;
        this.name = name;
        this.music = music;
        this.switchOnMusic = switchOnMusic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Float> getValues() {
        return values;
    }

    public void setValues(List<Float> values) {
        this.values = values;
    }

    public void setSwitchOnMusic(boolean switchOnMusic){
        this.switchOnMusic = switchOnMusic;
    }
    public boolean getSwitchOnMusic(){
        return switchOnMusic;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getMusic() {
        return music;
    }

    public void setMusic(int music) {
        this.music = music;
    }

}
