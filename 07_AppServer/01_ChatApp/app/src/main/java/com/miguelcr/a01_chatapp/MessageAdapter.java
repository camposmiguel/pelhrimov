package com.miguelcr.a01_chatapp;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by miguelcampos on 4/4/17.
 */

public class MessageAdapter extends ArrayAdapter<Message> {
    Context ctx;
    int layoutTemplate;
    List<Message> values;

    public MessageAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Message> objects) {
        super(context, resource, objects);

        ctx = context;
        layoutTemplate = resource;
        values = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(layoutTemplate, parent, false);

        Message current = values.get(position);
        String text = current.getTextMessage();
        String user = current.getUser();
        String date = current.getTime();

        TextView textViewMessage = (TextView) v.findViewById(R.id.textViewMessage);
        TextView textViewUser = (TextView) v.findViewById(R.id.textViewUser);
        TextView textViewDate = (TextView) v.findViewById(R.id.textViewDate);

        textViewMessage.setText(text);
        textViewUser.setText(user);
        textViewDate.setText(date);


        return v;
    }
}
