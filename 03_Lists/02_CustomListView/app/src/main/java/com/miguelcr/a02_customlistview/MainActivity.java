package com.miguelcr.a02_customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    List<FootballPlayer> footballPlayerList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. GEt the listview reference
        listView = (ListView) findViewById(R.id.listView);

        // 2. Create the list of elements
        footballPlayerList = new ArrayList<>();

        // 3. Add elements to the list
        footballPlayerList.add(new FootballPlayer("Ronaldo",30,"https://pbs.twimg.com/profile_images/795538317211299844/ShNKtUmK.jpg",8000));
        footballPlayerList.add(new FootballPlayer("Leo Messi",32,"http://images.performgroup.com/di/library/GOAL_INTERNATIONAL/c2/97/hd-lionel-messi-barcelona_5toanmhsh09f11z1b8ucasj4p.jpg",8));
        footballPlayerList.add(new FootballPlayer("Iker Casillas",28,"http://iker.s3.amazonaws.com/wp-content/uploads/2014/10/submenu-ikercasillas-trofeos.jpg",3));
        footballPlayerList.add(new FootballPlayer("Hiniesta",30,"http://www.iniesta8.com/img/profile-iniesta.jpg",500));

        // 4. Create the Adapter
        FootballPlayerAdapter adapter = new FootballPlayerAdapter(
                this, // context
                R.layout.football_player_item, // layout
                footballPlayerList // list of elements
        );

        listView.setAdapter(adapter);



    }
}
