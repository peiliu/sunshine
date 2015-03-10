package com.example.pei.sunshine2;

/**
 * Created by Pei on 3/7/2015.
 */
public class WeatherData {

    int min;
    int max;
    int datetime;
    int description;

    public WeatherData(int min, int max, int datetime, int description) {
        this.min = min;
        this.max = max;
        this.datetime = datetime;
        this.description = description;
    }
}
