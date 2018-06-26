package com.example.jadov.musicalstructure;
// This is the Java file for the musical structure's playlist

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.content.Intent;

import java.util.ArrayList;

public class PlaylistActivity extends AppCompatActivity {

    // Declare variables
    private ArrayList<Music> musicArrayList = new ArrayList<>();
    private ListView listView;
    private MusicAdapter adapter;
    private ImageView homeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist);

        // Add Music objects to ArrayList
        musicArrayList.add(new Music(R.drawable.truth_about_love, "Blow Me(One Last Kiss)", "Pink"));
        musicArrayList.add(new Music(R.drawable.revival, "Remind Me", "Eminem"));
        musicArrayList.add(new Music(R.drawable.one_more_light_live, "Leave Out All the Rest", "Linkin Park"));
        musicArrayList.add(new Music(R.drawable.feed_the_machine, "Song On Fire", "Nickelback"));
        musicArrayList.add(new Music(R.drawable.us_and_them, "Shed Some Light", "Shinedown"));
        musicArrayList.add(new Music(R.drawable.paradigm_shift, "It's All Wrong", "Korn"));
        musicArrayList.add(new Music(R.drawable.attention_attention, "Brilliant", "Shinedown"));
        musicArrayList.add(new Music(R.drawable.hybrid_theory, "Forgotten", "Linkin Park"));
        musicArrayList.add(new Music(R.drawable.post_traumatic, "Watching As I Fall", "Mike Shinoda"));
        musicArrayList.add(new Music(R.drawable.serenity_of_suffering, "Next In Line", "Korn"));
        musicArrayList.add(new Music(R.drawable.marshall_mathers_lp2, "Rhyme Or Reason", "Eminem"));
        musicArrayList.add(new Music(R.drawable.black_labyrinth, "Underneath My Skin", "Jonathan Davis"));
        musicArrayList.add(new Music(R.drawable.gray_chapter, "The Negative One", "Slipknot"));
        musicArrayList.add(new Music(R.drawable.threat_to_survival, "Asking For It", "Shinedown"));
        musicArrayList.add(new Music(R.drawable.one_more_light, "Good Goodbye", "Linkin Park feat. Pusha T and Stormzy"));

        // Add Music ArrayList to Adapter to be displayed in ListView
        adapter = new MusicAdapter(this, musicArrayList);
        listView = (ListView) findViewById(R.id.playlist);
        listView.setAdapter(adapter);

        // Set a click listener on ListView Music Object to retrieve object selected
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object listItem = listView.getItemAtPosition(position);
                Intent playingIntent = new Intent(PlaylistActivity.this, PlayingActivity.class);
                playingIntent.putExtra("Current Music", (Parcelable) listItem);
                startActivity(playingIntent);
            }
        });

        // Find playlist home button
        homeBtn = (ImageView) findViewById(R.id.home_btn);

        // Set a click listener on playlist home button
        homeBtn.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the playlist home button is clicked on.
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(PlaylistActivity.this, MainActivity.class);
                startActivity(homeIntent);
            }
        });
    }
}
