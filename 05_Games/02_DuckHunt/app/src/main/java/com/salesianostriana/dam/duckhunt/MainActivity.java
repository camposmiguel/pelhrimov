package com.salesianostriana.dam.duckhunt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText nick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nick = (EditText) findViewById(R.id.editTextNick);
    }

    public void startGame(View view) {
        // Open the GameActivity to start the game!!!!!!
        Intent i = new Intent(this, GameActivity.class);
        // We send the nick value to the GameActivity
        i.putExtra("nick",nick.getText().toString());
        startActivity(i);
    }
}
