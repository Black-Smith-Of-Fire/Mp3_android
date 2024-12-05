package com.example.mp3android.playlist;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;
import static android.view.View.inflate;
import static androidx.core.content.ContextCompat.getSystemService;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mp3android.Item;
import com.example.mp3android.R;
import com.example.mp3android.playlist.PlaylistAdapter;

import java.util.ArrayList;
import java.util.List;

public class PlaylistFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<Item> items;
    private PlaylistAdapter adapter;
    RelativeLayout layout;
    Button done;
    EditText playListInput;

    Button newPlaylist;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_playlist,container,false);

        newPlaylist = (Button)rootView.findViewById(R.id.newPlaylist);
        layout = rootView.findViewById(R.id.relative);

        newPlaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popUp();
            }
        });
        items = itemList();
        //Recycler view
        recyclerView = rootView.findViewById(R.id.playlistRecyclerView);

        adapter = new PlaylistAdapter(items);
        recyclerView.setAdapter(adapter);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),3);
        recyclerView.setLayoutManager(layoutManager);
        return rootView;
    }

    private void popUp(){
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(LAYOUT_INFLATER_SERVICE);
        View popUpView = inflater.inflate(R.layout.popup_window, null);
        done = (Button)popUpView.findViewById(R.id.Done);
        playListInput = (EditText) popUpView.findViewById(R.id.playlistInput);

        //Displaying the popup window
        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = ViewGroup.LayoutParams.WRAP_CONTENT;
        boolean focusable = true;
        PopupWindow popupWindow = new PopupWindow(popUpView, width, height, focusable);
        layout.post(new Runnable() {
            @Override
            public void run() {
                popupWindow.showAtLocation(layout, Gravity.TOP,0,0);
            }
        });

        // Done button working
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items.add(new Item(R.drawable.blacksmith,playListInput.getText().toString()));
            }
        });
    }

    private List<Item> itemList() {

        List<Item> it = new ArrayList<>();
        it.add(new Item(R.drawable.blacksmith,"Chris"));
        it.add(new Item(R.drawable.blacksmith,"Burger king"));
        it.add(new Item(R.drawable.blacksmith,"Carmine"));
        return it;
    }

}
