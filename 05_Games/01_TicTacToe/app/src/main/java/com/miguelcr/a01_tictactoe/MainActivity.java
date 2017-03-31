package com.miguelcr.a01_tictactoe;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView title;
    EditText player1Name, player2Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = (TextView) findViewById(R.id.textViewTitle);
        player1Name = (EditText) findViewById(R.id.editTextPlayer1);
        player2Name = (EditText) findViewById(R.id.editTextPlayer2);

        Typeface type = Typeface.createFromAsset(getAssets(),"jenthill.ttf");
        title.setTypeface(type);

        // hide the action bar
        getSupportActionBar().hide();
    }

    public void startGame(View view) {
        Intent i = new Intent(this,GameActivity.class);
        i.putExtra("player1",player1Name.getText().toString());
        i.putExtra("player2",player2Name.getText().toString());
        startActivity(i);
    }
}
