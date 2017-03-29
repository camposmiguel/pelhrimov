package com.miguelcr.a05_calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textViewScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewScreen = (TextView)findViewById(R.id.textViewScreenBlack);
    }

    public void numberClicked(View view) {
        // Write number 7 in the screen
        // Get the current screen text that now appear in the TextView
        String currentScreenText = textViewScreen.getText().toString();

        if(currentScreenText.equals("0")) {
            // Override the screen text
            textViewScreen.setText("7");
        } else {
            // We put in the TextView screen the current text + the new number clicked
            textViewScreen.setText(currentScreenText + "7");
        }
    }

    public void deleteClicked(View view) {
        // Get the current screen text
        String currentScreenText = textViewScreen.getText().toString();
        if(currentScreenText.length()==1) {
            textViewScreen.setText("0");
        } else {
            // We do the substring from 0 to the previous to the last element
            String newScreenText = currentScreenText.substring(0, currentScreenText.length() - 1);
            // The next into the TextView Screen
            textViewScreen.setText(newScreenText);
        }
    }
}
