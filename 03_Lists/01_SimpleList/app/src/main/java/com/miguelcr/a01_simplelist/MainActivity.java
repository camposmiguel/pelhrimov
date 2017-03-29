package com.miguelcr.a01_simplelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView list;
    List<String> studentsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Get the ListView reference
        list = (ListView) findViewById(R.id.listView);

        // 2. Create the list of elements
        studentsList = new ArrayList<>();

        // 3. Add elements to the list
        studentsList.add("Dan");
        studentsList.add("Honza");
        studentsList.add("Michal");
        studentsList.add("Petr");
        studentsList.add("Thomas I");
        studentsList.add("Thomas II");
        studentsList.add("Sharka");
        studentsList.add("Jana I");
        studentsList.add("Diana");
        studentsList.add("Petr II");
        studentsList.add("Jakub");
        studentsList.add("Daniel");
        studentsList.add("Dominik");
        studentsList.add("Petr III");
        studentsList.add("Leona");
        studentsList.add("Jana II");
        studentsList.add("Patryk");

        // 4. Define the Adapter component
        ArrayAdapter<String> adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                studentsList
        );

        // 5. Connect ListView and Adapter
        list.setAdapter(adapter);

        // Define the click event listener
        list.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String studentName = studentsList.get(position);
        Toast.makeText(this, "Student: "+studentName, Toast.LENGTH_SHORT).show();
    }
}
