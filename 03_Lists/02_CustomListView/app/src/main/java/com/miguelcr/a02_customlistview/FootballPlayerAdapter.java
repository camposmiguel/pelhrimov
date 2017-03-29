package com.miguelcr.a02_customlistview;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by miguelcampos on 29/3/17.
 */

class FootballPlayerAdapter extends ArrayAdapter<FootballPlayer> {
    Context ctx;
    int layoutTemplate;
    List<FootballPlayer> values;

    public FootballPlayerAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<FootballPlayer> objects) {
        super(context, resource, objects);
        ctx = context;
        layoutTemplate = resource;
        values = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(layoutTemplate, parent, false);

        // Get all the football player info
        FootballPlayer current = values.get(position);
        String name = current.getName();
        int age = current.getAge();
        int goals = current.getGoals();
        String photo = current.getPhoto();

        // View components references
        TextView textViewName = (TextView)  v.findViewById(R.id.textViewName);
        TextView textViewAge = (TextView)  v.findViewById(R.id.textViewAge);
        TextView textViewGoals = (TextView)  v.findViewById(R.id.textViewGoals);
        ImageView imageViewPhoto = (ImageView)  v.findViewById(R.id.imageViewPhoto);

        // Set into the view components the current football player info
        textViewName.setText(name);
        textViewAge.setText(String.valueOf(age)); // convert int to String
        textViewGoals.setText(String.valueOf(goals));
        Picasso.with(ctx)
                .load(photo)
                .into(imageViewPhoto);

        return v;

    }
}
