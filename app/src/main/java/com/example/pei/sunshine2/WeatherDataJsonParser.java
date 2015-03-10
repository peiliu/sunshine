package com.example.pei.sunshine2;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Pei on 10/12/2014.
 */


public class WeatherDataJsonParser {

    ArrayList<WeatherData> weatherDataList;

    public WeatherDataJsonParser() {
    }

    public ArrayList<WeatherData> Parse(String jsonWeatherString)
    {
        String TAG = "WeatherDataParser";
        try {
            JSONObject wholeJson = new JSONObject(jsonWeatherString);
            JSONArray jsonTempList = wholeJson.getJSONArray("list");
        }
        catch (JSONException e)
        {
            Log.e(TAG, "invalid json string " + jsonWeatherString);

        }
        return null;
    }
}
