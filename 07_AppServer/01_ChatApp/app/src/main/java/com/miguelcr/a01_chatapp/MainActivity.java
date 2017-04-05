package com.miguelcr.a01_chatapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ListView listViewMessages;
    List<Message> messageItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        listViewMessages = (ListView) findViewById(R.id.listView);



        // Get data from server
        // Connection configuration
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://miguelftp.esy.es/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Service
        InterfaceServerMessages service = retrofit.create(InterfaceServerMessages.class);
        Call<ServerMessageResponse> messages = service.getMessages();

        // Response
        messages.enqueue(new Callback<ServerMessageResponse>() {
            @Override
            public void onResponse(Call<ServerMessageResponse> call, Response<ServerMessageResponse> response) {
                // Create a list of Elements
                messageItemList = new ArrayList<>();
                messageItemList = response.body().getMessages();

                // The MessageAdapter
                MessageAdapter adapter = new MessageAdapter(
                        MainActivity.this,
                        R.layout.message_item,
                        messageItemList
                );

                listViewMessages.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ServerMessageResponse> call, Throwable t) {

            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
