package com.example.mp3android.dj;

import com.example.mp3android.Item;
import com.example.mp3android.R;

import java.util.ArrayList;
import java.util.List;

public class ItemList {

    List<Item> it = new ArrayList<>();

    private List<Item> itemList() {

        it.add(new Item(R.drawable.blacksmith,"Chris", R.raw.twistedrock));
        it.add(new Item(R.drawable.blacksmith,"Chris", R.raw.paro));
        return it;
    }
}
