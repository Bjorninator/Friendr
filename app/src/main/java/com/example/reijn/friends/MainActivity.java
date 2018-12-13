package com.example.reijn.friends;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Friend> friends = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Friend arya = new Friend("Arya", "die mag ik niet", getResources().getIdentifier("arya", "drawable", getPackageName()));
        Friend cersei = new Friend("Cersei", "naar persoon", getResources().getIdentifier("cersei", "drawable", getPackageName()));
        Friend daenerys = new Friend("Daenerys", "drakenchick", getResources().getIdentifier("daenerys", "drawable", getPackageName()));
        Friend jaime = new Friend("Jaime", "half cyborg", getResources().getIdentifier("jaime", "drawable", getPackageName()));
        Friend jon = new Friend("Jon", "plot armour", getResources().getIdentifier("jon", "drawable", getPackageName()));
        Friend jorah = new Friend("Jorah", "Mr friendzone", getResources().getIdentifier("jorah", "drawable", getPackageName()));
        Friend margaery = new Friend("Margaery", "generic", getResources().getIdentifier("margaery", "drawable", getPackageName()));
        Friend melisandre = new Friend("Melisandre", "ik hou van vuur", getResources().getIdentifier("melisandre", "drawable", getPackageName()));
        Friend sansa = new Friend("Sansa", "die mag ik ook niet", getResources().getIdentifier("sansa", "drawable", getPackageName()));
        Friend tyrion = new Friend("Tyrion", "kabouter",getResources().getIdentifier("tyrion", "drawable", getPackageName()) );
        friends.add(arya);
        friends.add(cersei);
        friends.add(daenerys);
        friends.add(jaime);
        friends.add(jon);
        friends.add(jorah);
        friends.add(margaery);
        friends.add(melisandre);
        friends.add(sansa);
        friends.add(tyrion);

        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, friends);
        GridView gridView = (GridView) findViewById(R.id.dezegrid);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new GridItemClickListener());
    }
    private class GridItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Friend clickedFriend = (Friend) parent.getItemAtPosition(position);
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            System.out.println(clickedFriend.getName());
            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);
        }
    }
}

