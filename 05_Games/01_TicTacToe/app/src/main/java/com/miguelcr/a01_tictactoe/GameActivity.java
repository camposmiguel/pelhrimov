package com.miguelcr.a01_tictactoe;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    TextView player;
    ImageView imageViewCell1, imageViewCell2, imageViewCell3,
            imageViewCell4,imageViewCell5,imageViewCell6,
    imageViewCell7,imageViewCell8,imageViewCell9;
    boolean isPlayingPlayer1 = true;
    String name1, name2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
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

        player = (TextView) findViewById(R.id.textViewPlayer);
        imageViewCell1 = (ImageView) findViewById(R.id.cell1);
        imageViewCell2 = (ImageView) findViewById(R.id.cell2);
        imageViewCell3 = (ImageView) findViewById(R.id.cell3);
        imageViewCell4 = (ImageView) findViewById(R.id.cell4);
        imageViewCell5 = (ImageView) findViewById(R.id.cell5);
        imageViewCell6 = (ImageView) findViewById(R.id.cell6);
        imageViewCell7 = (ImageView) findViewById(R.id.cell1);
        imageViewCell8 = (ImageView) findViewById(R.id.cell8);
        imageViewCell9 = (ImageView) findViewById(R.id.cell9);

        // Get the params that we receive in the Intent
        Bundle extras = getIntent().getExtras();
        name1 = extras.getString("player1");
        name2 = extras.getString("player2");

        player.setText(name1);


    }

    public void cellClicked(View v) {
        int id = v.getId();

        int icon = R.drawable.ic_player1;
        if(!isPlayingPlayer1) {
            icon = R.drawable.ic_player2;
        }

        switch (id) {
            case R.id.cell1:
                imageViewCell1.setImageResource(icon);
                break;
            case R.id.cell2:
                imageViewCell2.setImageResource(icon);
            case R.id.cell3:
                imageViewCell3.setImageResource(icon);
                break;
            case R.id.cell4:
                imageViewCell4.setImageResource(icon);
                break;
            case R.id.cell5:
                imageViewCell5.setImageResource(icon);
                break;
            case R.id.cell6:
                imageViewCell6.setImageResource(icon);
                break;
            case R.id.cell7:
                imageViewCell7.setImageResource(icon);
                break;
            case R.id.cell8:
                imageViewCell8.setImageResource(icon);
                break;
            case R.id.cell9:
                imageViewCell9.setImageResource(icon);
                break;
        }

        if(isPlayingPlayer1) {
            player.setText(name2);
            isPlayingPlayer1 = false;
        } else {
            player.setText(name1);
            isPlayingPlayer1 = true;
        }


    }

}
