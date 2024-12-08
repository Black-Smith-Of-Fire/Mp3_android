package com.example.mp3android;

import java.util.List;

public class Item {
    String name;
    int image;
    int music;
    List<Float> values;

    public Item(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public Item(int image, String name, List<Float> values) {
        this.image = image;
        this.name = name;
        this.values = values;
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
