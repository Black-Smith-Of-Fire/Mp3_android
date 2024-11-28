package com.example.mp3android;

public class Item {
    String name;
    int image;
    int music;

    public Item(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public Item(int image, String name, int music) {
        this.image = image;
        this.name = name;
        this.music = music;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
