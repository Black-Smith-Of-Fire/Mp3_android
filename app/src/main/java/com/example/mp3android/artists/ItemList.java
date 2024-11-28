package com.example.mp3android.artists;

import com.example.mp3android.Item;
import com.example.mp3android.R;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//TODO : implement the database connectivity and try to see some alternatives

public class ItemList {

    List<Item> it = new ArrayList<>();

public List<Item> itemList() {


        it.add(new Item(R.drawable.blacksmith,"Shomw"));
        it.add(new Item(R.drawable.blacksmith,"Carmine"));
        return it;
    }
}
