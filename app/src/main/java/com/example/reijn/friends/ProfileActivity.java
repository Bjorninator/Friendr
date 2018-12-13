package com.example.reijn.friends;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    SharedPreferences.Editor editor;
    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Intent intent = getIntent();
        Friend retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");
        ImageView image = (ImageView) findViewById(R.id.imageView2);
        TextView textvak = (TextView) findViewById(R.id.textView2);
        TextView biovak = (TextView) findViewById(R.id.textView3);
        RatingBar ratingbar = (RatingBar) findViewById(R.id.ratingBar);
        int ID = retrievedFriend.getDrawableId();
        text = retrievedFriend.getName();
        String bio = retrievedFriend.getBio();
        image.setImageDrawable(getResources().getDrawable(ID));
        textvak.setText(text);
        biovak.setText(bio);
        ratingbar.setRating(0);
        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        editor = prefs.edit();
        ratingbar.setOnRatingBarChangeListener(new ratingbarlistener());
        Float aStoredFloat  = prefs.getFloat(text, 0);

        if (aStoredFloat  != 0) {
            ratingbar.setRating(aStoredFloat);
        }
        else {
            ratingbar.setRating(0);
        }
    }
    public class ratingbarlistener implements RatingBar.OnRatingBarChangeListener{
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            editor.putFloat(text,rating);
            editor.apply();

        }

    }

}
