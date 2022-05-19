package com.example.listcountry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Country> countryArrayList;
    CountryAdapter countryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //anh xa
        listView = (ListView) findViewById(R.id.lw);

        countryArrayList = new ArrayList<>();

        countryArrayList.add(new Country("Viet Nam", "Ha Noi", R.drawable.vn));
        countryArrayList.add(new Country("My", "?", R.drawable.mi));

        countryAdapter = new CountryAdapter(this, R.layout.dong_nuoc, countryArrayList);

        listView.setAdapter(countryAdapter);



    }
}