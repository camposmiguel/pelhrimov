package com.miguelcr.a03_hotelcustomlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    List<HotelItem> hotelItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        hotelItemList = new ArrayList<>();
        hotelItemList.add(new HotelItem("Langham Place, New York City",5,399,"Mobile exclusive","nightly price","4,7 / 5 Outstanding","http://www.extravaganzi.com/wp-content/uploads/2012/02/The-Plaza-Hotel-New-York.jpg"));

        HotelAdapter adapter = new HotelAdapter(
                this,
                R.layout.hotel_item,
                hotelItemList
        );
    }
}
