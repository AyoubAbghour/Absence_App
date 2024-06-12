package com.example.absenceapp.allabsence;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.absenceapp.R;

import java.util.ArrayList;

public class Fragment_8_11 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_8_10, container, false);
    }

    private void setupRecyclerView() {
      //  List<String> dataList = new ArrayList<>();
        // Add your data to the list
        // Example:
        // dataList.add("Item 1");
        // dataList.add("Item 2");
        // dataList.add("Item 3");

        // Initialize adapter
     //   adapter = new CustomAdapter(dataList);

        // Set layout manager and adapter
     //   recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //recyclerView.setAdapter(adapter);
    }
}