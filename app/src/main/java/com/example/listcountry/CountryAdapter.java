package com.example.listcountry;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CountryAdapter extends BaseAdapter {

    Context context;
    int layout;
    List<Country> countryList;

    public CountryAdapter(Context context, int layout, List<Country> countryList) {
        this.context = context;
        this.layout = layout;
        this.countryList = countryList;
    }

    @Override
    public int getCount() {
        return countryList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);

        //anh xa
        TextView tvName = (TextView) convertView.findViewById(R.id.tv_name);
        TextView tvCapital = (TextView) convertView.findViewById(R.id.tv_capital);
        ImageView imgCo = (ImageView) convertView.findViewById(R.id.img_country);

        //gan gtri
        tvName.setText(countryList.get(position).getName());
        tvCapital.setText(countryList.get(position).getCapital());
        imgCo.setImageResource(countryList.get(position).getImage());

        return convertView;
    }
}
