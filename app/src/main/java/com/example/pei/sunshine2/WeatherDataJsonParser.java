package com.example.pei.sunshine2;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Pei on 10/12/2014.
 */

/* here is the format
{
  "cod": "200",
  "message": 0.4257,
  "city": {
    "id": "295224",
    "name": "Arad",
    "coord": {
      "lon": 35.2061,
      "lat": 31.2608
    },
    "country": "Israel",
    "population": 0
  },
  "cnt": 7,
  "list": [
    {
      "dt": 1426064400,
      "temp": {
        "day": 19.26,
        "min": 17.98,
        "max": 19.26,
        "night": 17.98,
        "eve": 19.26,
        "morn": 19.26
      },
      "pressure": 989.51,
      "humidity": 74,
      "weather": [
        {
          "id": 803,
          "main": "Clouds",
          "description": "broken clouds",
          "icon": "04n"
        }
      ],
      "speed": 1.17,
      "deg": 273,
      "clouds": 68
    },
    {
      "dt": 1426150800,
      "temp": {
        "day": 11.81,
        "min": 9.76,
        "max": 16.01,
        "night": 9.76,
        "eve": 12.78,
        "morn": 16.01
      },
      "pressure": 996.06,
      "humidity": 100,
      "weather": [
        {
          "id": 501,
          "main": "Rain",
          "description": "moderate rain",
          "icon": "10d"
        }
      ],
      "speed": 2.32,
      "deg": 290,
      "clouds": 92,
      "rain": 11.58
    },

 */
public class WeatherDataJsonParser {



    public WeatherDataJsonParser() {

    }

    static public ArrayList<WeatherData> Parse(String jsonWeatherString)
    {
        ArrayList<WeatherData> weatherDataList = new ArrayList<WeatherData>();;
        String TAG = "WeatherDataParser";
        try {
            JSONObject wholeJson = new JSONObject(jsonWeatherString);
            JSONArray jsonTempList = wholeJson.getJSONArray("list");

            for (int i = 0; i < jsonTempList.length(); i++) {
                JSONObject temperature = jsonTempList.getJSONObject(i);
                JSONObject temp = temperature.getJSONObject("temp");
                WeatherData weatherData = new WeatherData();
                weatherData.min = temp.getDouble("min");
                weatherData.max = temp.getDouble("max");
                JSONArray weatherList = temperature.getJSONArray("weather");
                JSONObject weather = weatherList.getJSONObject(0);
                weatherData.description = weather.getString("main");
                weatherDataList.add(weatherData);
            }
        }
        catch (JSONException e)
        {
            Log.e(TAG, "invalid json string " + jsonWeatherString);

        }
        return weatherDataList;
    }
}
