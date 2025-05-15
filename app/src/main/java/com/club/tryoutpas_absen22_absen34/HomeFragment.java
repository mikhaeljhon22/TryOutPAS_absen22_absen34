package com.club.tryoutpas_absen22_absen34;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
    TextView tvName;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /*
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        tvName = (TextView) view.findViewById(R.id.tvName);
        return view;
         */
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }
}