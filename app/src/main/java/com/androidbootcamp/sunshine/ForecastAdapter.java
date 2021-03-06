package com.androidbootcamp.sunshine;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ye Lin Aung on 14/09/26.
 */
public class ForecastAdapter extends ArrayAdapter<Item> {

    Context context;

    ArrayList<Item> mItems;

    public ForecastAdapter(Context context, List<Item> objects) {
        super(context, R.layout.list_item_forecast, objects);

        this.context = context;
        this.mItems = (ArrayList<Item>) objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if (convertView == null || convertView.getTag() == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_forecast, null);
            holder = new ViewHolder();
            holder.textView = (TextView) convertView.findViewById(R.id.list_item_forecast_textview);
            holder.imageView = (ImageView) convertView.findViewById(R.id.list_item_forecast_image);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        String imageUrl = "http://openweathermap.org/img/w/"
                + mItems.get(position).getImage()
                + ".png";

        holder.textView.setText(mItems.get(position).getText());
        Picasso.with(context).load(imageUrl).into(holder.imageView);
        return convertView;

    }

    static class ViewHolder {
        TextView textView;
        ImageView imageView;
    }
}
