package com.example.tony.weatherappv2;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends Activity {
    private Button getWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment implements View.OnClickListener {

        private Button getWeather;
        private EditText zipCode;
        private RadioButton fahrButton;
        private RadioButton celcButton;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            return rootView;
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState){
            super.onActivityCreated(savedInstanceState);
            getWeather = (Button)getActivity().findViewById(R.id.getWeather);
            getWeather.setOnClickListener((View.OnClickListener) this);

            zipCode = (EditText)getActivity().findViewById(R.id.editText);

            fahrButton = (RadioButton)getActivity().findViewById(R.id.radioButton);

            celcButton = (RadioButton)getActivity().findViewById(R.id.radioButton2);
        }

        public void onClick(final View v){
            if(v.getId() == R.id.getWeather){
                CharSequence text = "GETTING WEATHER";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(getActivity().getApplicationContext(), text, duration);
                toast.show();

                String city = zipCode.getText().toString();

                update_weather weather = new update_weather(city);

                getFragmentManager().beginTransaction()
                        .replace(R.id.container, weather)
                        .commit();

                weather.updateWeatherData(getActivity().getApplicationContext());
            }
        }
    }
}
