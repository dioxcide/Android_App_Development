package com.example.tony.testapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

/**
 * Created by Tony on 11/21/2014.
 */
public class MyFragment extends Fragment{
    public MyFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_note_fragment, container, false);

        TabHost tabs = (TabHost)rootView.findViewById(R.id.tabHost2);
        tabs.setup();

        TabHost.TabSpec ts = tabs.newTabSpec("tag1");

        ts.setContent(R.id.linearLayout);
        ts.setIndicator("Add Notes");
        tabs.addTab(ts);

        ts = tabs.newTabSpec("tag2");
        ts.setContent(R.id.linearLayout2);
        ts.setIndicator("Notes");
        tabs.addTab(ts);

        ts= tabs.newTabSpec("tag3");
        ts.setContent(R.id.linearLayout3);
        ts.setIndicator("Random Tab");
        tabs.addTab(ts);

        return rootView;
    }
}
