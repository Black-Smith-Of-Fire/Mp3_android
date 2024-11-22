package com.example.mp3android.album;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mp3android.Item;
import com.example.mp3android.R;

import java.util.ArrayList;
import java.util.List;

public class Album extends Fragment {

    private RecyclerView recyclerView;
    private List<Item> items;
    private AlbumAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home,container,false);

        items = itemList();
        //Recycler view
        recyclerView = rootView.findViewById(R.id.recyclerView);

        adapter = new AlbumAdapter(items);
        recyclerView.setAdapter(adapter);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),3);
        recyclerView.setLayoutManager(layoutManager);
        return rootView;
    }

    private List<Item> itemList() {

        List<Item> it = new ArrayList<>();
        it.add(new Item(R.drawable.blacksmith,"Chris"));
        it.add(new Item(R.drawable.blacksmith,"Mj"));
        it.add(new Item(R.drawable.blacksmith,"Indila"));
        it.add(new Item(R.drawable.blacksmith,"Connor"));
        it.add(new Item(R.drawable.blacksmith,"Torbuk"));
        it.add(new Item(R.drawable.blacksmith,"Sheldon"));
        it.add(new Item(R.drawable.blacksmith,"Golden boy"));
        it.add(new Item(R.drawable.blacksmith,"Cassie"));
        it.add(new Item(R.drawable.blacksmith,"McDonald"));
        it.add(new Item(R.drawable.blacksmith,"Carla"));
        it.add(new Item(R.drawable.blacksmith,"Jaimie"));
        return it;
    }
}
