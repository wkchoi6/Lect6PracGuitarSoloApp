package com.example.lect6pracguitarsoloapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayScreen extends AppCompatActivity {
    List<String> SoloNames = new ArrayList<>(Arrays.asList("First Solo Track", "Second Solo Track"));
    List<Integer> SoloPics = new ArrayList<>(Arrays.asList(R.drawable.imgfirst, R.drawable.imgsecond));
    List<Integer> SoloRaws = new ArrayList<>(Arrays.asList(R.raw.firstsolo, R.raw.secondsolo));

    List<GuitarSolo> SoloLists = new ArrayList<>();

    MediaPlayer mediaPlayer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_screen);
        LoadModelData();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setLogo(R.mipmap.ic_launcher_guitar_round);
        actionBar.setTitle(R.string.txtTitle);

        //instantiate List
        ListView listViewSolo = findViewById(R.id.listViewGuitarSolo);

        //Create Adapter obj
        //SoloAdapter myAdapter = new SoloAdapter(SoloLists);

        SoloAdapter2 myAdapter = new SoloAdapter2(SoloLists);

        //set adapter obj to listView
        listViewSolo.setAdapter(myAdapter);

        listViewSolo.setOnItemClickListener((AdapterView<?> adapterView, View view, int i, long l) -> {
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }

            if (myAdapter.getSelectedInd() == i){
                myAdapter.setSelectedInd(-1);
            } else {
                myAdapter.setSelectedInd(i);
                //myAdapter.notifyDataSetChanged(); //another option
                mediaPlayer = MediaPlayer
                        .create(PlayScreen.this,
                                SoloLists.get(i).getSoloRaw());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener((MediaPlayer mediaPlayer) -> {
                    myAdapter.setSelectedInd(-1);
                           /* try {
                                mediaPlayer.prepare();
                                mediaPlayer.start();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }*/
                });
            }

        });
    }
    private void LoadModelData() {
        for (int i = 0; i < SoloNames.size(); i++) {
            GuitarSolo eachSolo = new GuitarSolo(SoloNames.get(i), SoloPics.get(i), SoloRaws.get(i));
            SoloLists.add(eachSolo);
        }
    }
}