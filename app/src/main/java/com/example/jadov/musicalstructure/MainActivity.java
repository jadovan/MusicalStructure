package com.example.jadov.musicalstructure;
// This is the Java file for the Main Screen of the application to enter into the user's playlist

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Declare variables
    private TextView playlist_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find playlist button
        playlist_btn = (TextView) findViewById(R.id.playlist_home);

        // Set a click listener to enter playlist activity
        playlist_btn.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the playlist View is clicked on.
            @Override
            public void onClick(View view) {
                Intent playlistIntent = new Intent(MainActivity.this, PlaylistActivity.class);
                startActivity(playlistIntent);
            }
        });

    }
}
