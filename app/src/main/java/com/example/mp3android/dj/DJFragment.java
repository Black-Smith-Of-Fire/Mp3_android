package com.example.mp3android.dj;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mp3android.R;

public class DJFragment extends Fragment {

    private RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_dj, container,false);

        recyclerView = rootView.findViewById(R.id.djRecyclerView);

        return inflater.inflate(R.layout.fragment_dj, container, false);
    }
}
