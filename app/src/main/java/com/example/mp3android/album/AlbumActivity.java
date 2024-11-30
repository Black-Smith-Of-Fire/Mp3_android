/*
This is the class running the album of the artist
uses the following xml : album activity,
* */


package com.example.mp3android.album;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mp3android.Item;
import com.example.mp3android.R;
import com.example.mp3android.player.PlayerActivity;
import com.example.mp3android.artists.ArtistInterface;

import java.util.ArrayList;
import java.util.List;

public class AlbumActivity extends AppCompatActivity implements ArtistInterface{

    private RecyclerView recyclerView;
    private List<Item> items;
    private AlbumAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        items = itemList();
        recyclerView = findViewById(R.id.albumRecycler);
        adapter = new AlbumAdapter(items,this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        items = itemList();

    }

    private List<Item> itemList() {

        List<Item> it = new ArrayList<>();
        it.add(new Item(R.drawable.blacksmith,"Chris"));
        it.add(new Item(R.drawable.blacksmith,"Jaime"));
        it.add(new Item(R.drawable.blacksmith,"Sara"));
        return it;
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(AlbumActivity.this, PlayerActivity.class);
        intent.putExtra("Artist_name",items.get(position).getName());
        startActivity(intent);
    }
}