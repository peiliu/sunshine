package com.example.pei.sunshine2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class ForecastFragment extends Fragment implements AsyncResponse {

    public ForecastFragment() {
    }

    @Override
    public void onCreate(android.os.Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        String weekForecast[] = {
                "Today - Sunny 88 / 63",
                "Tommorrow - Cloudy 70 / 46",
                "Weds - Cloudy 72 / 63",
                "Thurs - Rainy 64 / 51",
                "Fri - Foggy 70 / 46",
                "Sat - Sunny 76 / 68"
        };

        WeatherDataJsonParser weatherDataJsonParser = new WeatherDataJsonParser();
        ArrayAdapter<String> weatherAdapter = new ArrayAdapter<String>(
                getActivity(),
                R.layout.list_item_forecast,
                R.id.list_item_forecast_textview,
                weekForecast);


        ListView list = (ListView) rootView.findViewById(R.id.list_item_forecast_listview);
        list.setAdapter(weatherAdapter);
        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.forecastfragment, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_refresh) {
            FetchWeatherTask fetchWeatherTask = new FetchWeatherTask();
            //new FetchWeatherTask().execute(89052);
            fetchWeatherTask.execute(89052);

        }
        return super.onOptionsItemSelected(item);
     }

    @Override
    public void processFinish(String output) {
        WeatherDataJsonParser weatherDataJsonParser = new WeatherDataJsonParser();
        ArrayList<WeatherData> weatherDataArrayList = weatherDataJsonParser.Parse(output);
    }
}