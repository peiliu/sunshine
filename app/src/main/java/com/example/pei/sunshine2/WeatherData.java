package com.example.pei.sunshine2;

/**
 * Created by Pei on 3/7/2015.
 */
public class WeatherData {

    Double min;
    Double max;
    int datetime;
    String description;

    public WeatherData(Double min, Double max, int datetime, String description) {
        this.min = min;
        this.max = max;
        this.datetime = datetime;
        this.description = description;
    }

    public WeatherData() {
    }

    @Override
    public String toString()
    {
        return ("min " + min.toString() + " max " + max.toString() + description);
    }
}
