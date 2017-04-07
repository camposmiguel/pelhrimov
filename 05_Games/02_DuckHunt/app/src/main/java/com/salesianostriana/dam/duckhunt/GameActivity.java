package com.salesianostriana.dam.duckhunt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {
    TextView textViewPlayer;
    ImageView duck;
    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        textViewPlayer = (TextView) findViewById(R.id.textViewPlayer);
        duck = (ImageView) findViewById(R.id.imageViewDuck);

        // Get the nick value that we receive in the Intent object
        Bundle extras = getIntent().getExtras();
        String nickname = extras.getString("nick");
        textViewPlayer.setText(nickname);

        random = new Random();
        generateRamdonPosition();
    }

    private void generateRamdonPosition() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenHeight = displayMetrics.heightPixels;
        int screenWidth = displayMetrics.widthPixels;

        int min = 0;
        int x = random.nextInt(screenWidth - min + 1) + min;
        int y = random.nextInt(screenHeight - min + 1) + min;

        duck.setX(x);
        duck.setY(y);
        

    }

    public void duckClicked(View view) {
        generateRamdonPosition();
    }
}
