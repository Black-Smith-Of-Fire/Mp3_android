package com.example.mp3android.dj;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mp3android.Item;
import com.example.mp3android.R;
import com.google.android.material.slider.RangeSlider;

import java.util.List;

public class DJFragment extends Fragment implements DJInterface {

    private RecyclerView recyclerView;
    private List<Item> items;
    private DJAdapter adapter;
    RangeSlider rangeSlider;
    MediaPlayer mediaPlayer;
    DJItemList item = new DJItemList();
    boolean switchOnMusic;
    int position = 0;
    ActivitySwitcher switcher = new ActivitySwitcher();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_dj, container,false);

        int position = parent.getChildAdapterPosition();
        items = item.itemList();
        recyclerView = rootView.findViewById(R.id.djRecyclerView);

        View view = inflater.inflate(R.layout.dj_list, container,false);
        rangeSlider = view.findViewById(R.id.slider);
        mediaPlayer = MediaPlayer.create(getContext(),R.raw.twistedrock);

//        switchOnMusic = items.get(position).getSwitchOnMusic();

        adapter = new DJAdapter(items,mediaPlayer,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        return rootView;
    }


    @Override
    public void nextTrack(int position) {

        item.itemList().get(position).setSwitchOnMusic(true);
    }
}
