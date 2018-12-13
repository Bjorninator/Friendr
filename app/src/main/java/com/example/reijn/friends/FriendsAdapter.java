package com.example.reijn.friends;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class FriendsAdapter extends ArrayAdapter<Friend> {

    private ArrayList<Friend> friends;
    private Context context;
    public FriendsAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Friend> objects) {
        super(context, resource, objects);
        this.friends = objects;
        this.context = context;

    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }
        ImageView image = (ImageView) convertView.findViewById(R.id.imageView);
        TextView textvak = (TextView) convertView.findViewById(R.id.textView);
        int ID = friends.get(position).getDrawableId();
        String text = friends.get(position).getName();
        textvak.setText(text);
        image.setImageDrawable(getContext().getResources().getDrawable(ID));
        return convertView;
    }

}
