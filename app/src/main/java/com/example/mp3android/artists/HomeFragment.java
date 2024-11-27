package com.example.mp3android.artists;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mp3android.Item;
import com.example.mp3android.R;
import com.example.mp3android.album.AlbumActivity;
import com.example.mp3android.artists.ArtistInterface;
import com.example.mp3android.artists.ArtistsAdapter;
import com.example.mp3android.album.AlbumActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements ArtistInterface {

    private RecyclerView recyclerView;
    private List<Item> items;
    private ArtistsAdapter adapter;
    private ItemList item = new ItemList();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home,container,false);

         items = item.itemList();
        //Recycler view
        recyclerView = rootView.findViewById(R.id.recyclerView);

        adapter = new ArtistsAdapter(items,this);
        recyclerView.setAdapter(adapter);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),3);
        recyclerView.setLayoutManager(layoutManager);
        return rootView;
    }


    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getActivity(), AlbumActivity.class);
        startActivity(intent);
    }
}