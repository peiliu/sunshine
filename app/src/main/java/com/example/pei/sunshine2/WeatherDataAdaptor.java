package com.example.pei.sunshine2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Pei on 5/13/2015.
 */
public class WeatherDataAdaptor extends ArrayAdapter<WeatherData> {

    public WeatherDataAdaptor(Context context, int resource) {
        super(context, resource);
    }

    public WeatherDataAdaptor(Context context, List<WeatherData> itemList)
    {
        super(context, 0, itemList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // get item based on position
        WeatherData item = getItem(position);

        if (convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_forecast, parent, false);
        }
        TextView tvWeather = (TextView) convertView.findViewById(R.id.list_item_forecast_textview);
        tvWeather.setText(item.toString());

        return convertView;
    }
}
