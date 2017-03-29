package com.miguelcr.a01_picasso;

import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    TextView textViewName, textViewAge;
    ImageView imageViewPhoto;
    ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewName = (TextView) findViewById(R.id.textViewName);
        textViewAge = (TextView) findViewById(R.id.textViewAge);
        imageViewPhoto = (ImageView) findViewById(R.id.imageViewProfile);
        layout = (ConstraintLayout) findViewById(R.id.layoutMain);

        Picasso.with(this)
                .load("https://pbs.twimg.com/profile_images/795538317211299844/ShNKtUmK.jpg")
                .into(imageViewPhoto);

        textViewName.setText("Ronaldo");
        textViewAge.setText("30 years old");

        // Change textView colors & background color
        textViewName.setTextColor(ContextCompat.getColor(this,android.R.color.white));
        textViewAge.setTextColor(ContextCompat.getColor(this,android.R.color.white));
        layout.setBackgroundColor(ContextCompat.getColor(this,R.color.colorPrimary));
    }
}
