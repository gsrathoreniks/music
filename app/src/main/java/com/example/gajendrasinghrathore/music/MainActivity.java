package com.example.gajendrasinghrathore.music;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity {

    // variable declaration
    private ListView mainList;

    private MediaPlayer mp;

    private final String[] listContent = { "ilahi"};

    private Integer play=0;

    private Button playPause;

    private final int[] resID = { R.raw.illahi };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// Initializing variables

        mp = new MediaPlayer();

        mainList = (ListView) findViewById(R.id.listView1);
        playPause=(Button)findViewById(R.id.playPause);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listContent);

        mainList.setAdapter(adapter);
        //-----------------

        playPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if(play==0){
                    playSong(0);
                    playPause.setText("STOP");
                }
                else{
                    playSong(0);
                    playPause.setText("PLAY");
                }

            }
        });
//        mainList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view,
//                                    int position, long id) {
//                playSong(position);
//                Log.d("position", String.valueOf(position));
//
//            }
//        });

    }

    public void playSong(int songIndex) {
// Play song
        if(play==0) {
            mp = MediaPlayer.create(getApplicationContext(), resID[songIndex]);// create's
            mp.start();
            play=1;
        }
        else{
            mp.stop();
            play=0;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mp.release();
    }


}
