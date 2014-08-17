package com.example.soundboard;

import java.io.IOException;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{
	private MediaPlayer mp = new MediaPlayer();
	private AssetFileDescriptor afd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initButtons();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id = v.getId();
		if( id == R.id.Song_1){
			Log.v("Swag", "WORKING BABY");
			playClip("Asshole.mp3");
		}
		else if( id == R.id.Song_2){
			playClip("Above the Law.mp3");
		}
		else if( id == R.id.Song_3){
			playClip("Fast Lane.mp3");
		}
		else if( id == R.id.Song_4){
			playClip("I Need a Doctor.mp3");
		}
		else if( id == R.id.Song_5){
			playClip("25 To Life.mp3");
		}
		else if( id == R.id.Song_6){
			playClip("Berzerk.mp3");
		}
	}
	
	public void initButtons(){
		final Button button = (Button) findViewById(R.id.Song_1);
		button.setOnClickListener(this);
		
		final Button button2 = (Button) findViewById(R.id.Song_2);
		button2.setOnClickListener(this);
		
		final Button button3 = (Button) findViewById(R.id.Song_3);
		button3.setOnClickListener(this);
		
		final Button button4 = (Button) findViewById(R.id.Song_4);
		button4.setOnClickListener(this);
		
		final Button button5 = (Button) findViewById(R.id.Song_5);
		button5.setOnClickListener(this);
		
		final Button button6 = (Button) findViewById(R.id.Song_6);
		button6.setOnClickListener(this);
		
	}
	
	public void playClip(String songName){
		mp.stop();
        mp.reset();
		try {
			afd = getAssets().openFd(songName);
			mp.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
            mp.prepare();
            mp.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
