package com.example.mp3android.dj;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mp3android.Item;
import com.example.mp3android.R;
import com.google.android.material.slider.RangeSlider;
import com.google.android.material.slider.Slider;

import java.util.ArrayList;
import java.util.List;

public class DJFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<Item> items;
    private DJAdapter adapter;
    RangeSlider rangeSlider;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_dj, container,false);

        items = itemList();
        recyclerView = rootView.findViewById(R.id.djRecyclerView);

        View view = inflater.inflate(R.layout.dj_list, container,false);
        rangeSlider = view.findViewById(R.id.slider);

        adapter = new DJAdapter(items);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        return rootView;
    }

    private List<Item> itemList() {

        List<Item> it = new ArrayList<>();
        List <Float> list = new ArrayList<>();
        List <Float> list2 = new ArrayList<>();
        list.add(0,0.0f);
        list.add(1,0.0f);
        list.add(2,100.0f);
        it.add(new Item(R.drawable.blacksmith,"Chris", list));
        list2.add(0, list.get(2));
        list2.add(1, list.get(2));
        list2.add(2, 100.0f);
        it.add(new Item(R.drawable.blacksmith,"Chris", list2));
        return it;
    }
}
