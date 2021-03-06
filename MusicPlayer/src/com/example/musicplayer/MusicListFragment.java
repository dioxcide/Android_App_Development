package com.example.musicplayer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class MusicListFragment extends Fragment implements OnClickListener{
	private ArrayAdapter<String> MusicAdapter;
	private RelativeLayout mRelativeLayout;
	
	public MusicListFragment(){	
	}
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.music_list, container, false);
        
        mRelativeLayout = (RelativeLayout) inflater.inflate(R.layout.music_list,
                container, false);
        initButtons();
        
        initListView(rootView);
        
        return rootView;
    }
    
    public void initButtons(){

    	final Button Stop = (Button) mRelativeLayout.findViewById(R.id.Stop);
    	Stop.setOnClickListener(this);
		
		final Button button2 = (Button) mRelativeLayout.findViewById(R.id.Play);
		button2.setOnClickListener(this);
		
		final Button button3 = (Button) mRelativeLayout.findViewById(R.id.Pause);
		button3.setOnClickListener(this);

    }
    
    public void initListView(View rootView){
    	 String[] data = {
                 "Mon 6/23 - Sunny - 31/17",
                 "Tue 6/24 - Foggy - 21/8",
                 "Wed 6/25 - Cloudy - 22/17",
                 "Thurs 6/26 - Rainy - 18/11",
                 "Fri 6/27 - Foggy - 21/10",
                 "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
                 "Sun 6/29 - Sunny - 20/7"
         };
         List<String> weekForecast = new ArrayList<String>(Arrays.asList(data));

         // Now that we have some dummy forecast data, create an ArrayAdapter.
         // The ArrayAdapter will take data from a source (like our dummy forecast) and
         // use it to populate the ListView it's attached to.
         MusicAdapter =
                 new ArrayAdapter<String>(
                         getActivity(), // The current context (this activity)
                         R.layout.music_list, // The name of the layout ID.
                         R.id.music_textview, // The ID of the textview to populate.
                         weekForecast);
         
         // Get a reference to the ListView, and attach this adapter to it.
         ListView listView = (ListView) rootView.findViewById(R.id.music_list);
         listView.setAdapter(MusicAdapter);
    }
    
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
}
