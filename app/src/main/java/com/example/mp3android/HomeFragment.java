package com.example.mp3android;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements ArtistInterface{

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

        it.add(new Item(R.drawable.blacksmith));
        it.add(new Item(R.drawable.blacksmith));
        it.add(new Item(R.drawable.blacksmith));
        it.add(new Item(R.drawable.blacksmith));
        it.add(new Item(R.drawable.blacksmith));
        it.add(new Item(R.drawable.blacksmith));
        it.add(new Item(R.drawable.blacksmith));
        it.add(new Item(R.drawable.blacksmith));
        it.add(new Item(R.drawable.blacksmith));
        it.add(new Item(R.drawable.blacksmith));
        it.add(new Item(R.drawable.blacksmith));
        return it;
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(HomeFragment.this.getActivity(),Album.class);
        startActivity(intent);
    }
}