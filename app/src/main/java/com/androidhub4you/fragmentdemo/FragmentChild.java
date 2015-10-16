package com.androidhub4you.fragmentdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Manish Srivastava
 */
public class FragmentChild extends Fragment {


    public FragmentChild() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_child, container, false);

        //call the main activity set tile method
        ((MainActivity)getActivity()).setActionBarTitle("Child Fragment");


        return view;
    }
}
