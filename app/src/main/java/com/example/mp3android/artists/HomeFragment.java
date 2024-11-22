package com.example.mp3android;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mp3android.album.Album;
import com.example.mp3android.artists.ArtistInterface;
import com.example.mp3android.artists.ArtistsAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements ArtistInterface {

    private RecyclerView recyclerView;
    private List<Item> items;
    private ArtistsAdapter adapter;
    List<Item> it = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home,container,false);

         items = itemList();
        //Recycler view
        recyclerView = rootView.findViewById(R.id.recyclerView);

        adapter = new ArtistsAdapter(items,this);
        recyclerView.setAdapter(adapter);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),3);
        recyclerView.setLayoutManager(layoutManager);
        return rootView;
    }

    private List<Item> itemList() {

        it.add(new Item(R.drawable.blacksmith,"Chris"));
        it.add(new Item(R.drawable.blacksmith,"Jaime"));
        it.add(new Item(R.drawable.blacksmith,"Sara"));
        it.add(new Item(R.drawable.blacksmith,"Napoleon"));
        it.add(new Item(R.drawable.blacksmith,"Dj malone"));
        it.add(new Item(R.drawable.blacksmith,"Indila"));
        it.add(new Item(R.drawable.blacksmith,"Terry"));
        it.add(new Item(R.drawable.blacksmith,"Davis"));
        it.add(new Item(R.drawable.blacksmith,"Burger king"));
        it.add(new Item(R.drawable.blacksmith,"Shomw"));
        it.add(new Item(R.drawable.blacksmith,"Carmine"));
        return it;
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(HomeFragment.this.getActivity(), Album.class);
        startActivity(intent);
    }
}