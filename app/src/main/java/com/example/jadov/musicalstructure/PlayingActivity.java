package com.example.jadov.musicalstructure;
// This is the Java file for the currently playing Music object

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PlayingActivity extends AppCompatActivity {

    // Declare variables
    private Music currentMusic;
    private ImageView playlistBtn, homeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playing);

        // Collect intent data
        Intent intent = getIntent();
        currentMusic = intent.getParcelableExtra("Current Music");

        // Collect all music values
        int albumCover = currentMusic.getAlbum();
        String songName = currentMusic.getSong();
        String artistName = currentMusic.getArtist();

        // Readjust album cover image size within activity to a predetermined size
        ImageView album = findViewById(R.id.album_cover);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) album.getLayoutParams();
        params.height = 960;
        params.width = 960;
        album.setLayoutParams(params);
        album.setImageResource(albumCover);

        // Find song name TextView
        TextView song = findViewById(R.id.song_name);
        song.setText(songName);

        // Find artist name TextView
        TextView artist = findViewById(R.id.artist_name);
        artist.setText(artistName);

        // Find playlist button
        playlistBtn = (ImageView) findViewById(R.id.playlist_btn);

        // Set a click listener on playing playlist button
        playlistBtn.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the playing playlist button is clicked on.
            @Override
            public void onClick(View view) {
                Intent playlistIntent = new Intent(PlayingActivity.this, PlaylistActivity.class);
                startActivity(playlistIntent);
            }
        });

        // Find home button
        homeBtn = (ImageView) findViewById(R.id.home_btn);

        // Set a click listener on playing home button
        homeBtn.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the playing home button is clicked on.
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(PlayingActivity.this, MainActivity.class);
                startActivity(homeIntent);
            }
        });
    }
}
