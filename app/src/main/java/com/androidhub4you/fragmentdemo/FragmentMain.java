package com.androidhub4you.fragmentdemo;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Manish Srivastava
 */
public class FragmentMain extends Fragment {


    public FragmentMain() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        final Button mButtonFragmentMain=(Button)view.findViewById(R.id.button__fragment_main);

        Log.v("<< main fragment>>","<<screen>>");

        mButtonFragmentMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //call the child fragment
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                FragmentChild fragmentChild = new FragmentChild();
                transaction.addToBackStack("fragmentChild");
                transaction.replace(R.id.container, fragmentChild);
                transaction.commit();

            }
        });

        //call the main activity set tile method
        ((MainActivity)getActivity()).setActionBarTitle("Home Fragment");

        return view;
    }
}
