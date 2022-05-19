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

    private class ViewHodel {
        TextView tvName, tvCapital;
        ImageView imageCo;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHodel viewHodel;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);

            viewHodel = new ViewHodel();
            //anh xa
            viewHodel.tvName = (TextView) convertView.findViewById(R.id.tv_name);
            viewHodel.tvCapital = (TextView) convertView.findViewById(R.id.tv_capital);
            viewHodel.imageCo = (ImageView) convertView.findViewById(R.id.img_country);

            convertView.setTag(viewHodel);
        } else {
            viewHodel = (ViewHodel) convertView.getTag();
        }

//        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        convertView = inflater.inflate(layout, null);
//
//        //anh xa
//        TextView tvName = (TextView) convertView.findViewById(R.id.tv_name);
//        TextView tvCapital = (TextView) convertView.findViewById(R.id.tv_capital);
//        ImageView imgCo = (ImageView) convertView.findViewById(R.id.img_country);

        //gan gtri
        viewHodel.tvName.setText(countryList.get(position).getName());
        viewHodel.tvCapital.setText(countryList.get(position).getCapital());
        viewHodel.imageCo.setImageResource(countryList.get(position).getImage());

        return convertView;
    }
}
