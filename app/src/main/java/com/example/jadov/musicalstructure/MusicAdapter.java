package com.example.jadov.musicalstructure;
// This is the Java file for determining the Music object currently selected within a list

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MusicAdapter extends ArrayAdapter<Music> {

    // Declare variables
    private Music music;

    // Create the adapter to retrieve object information at current position
    public MusicAdapter(Context context, ArrayList<Music> music) {
        super(context, 0, music);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View playlistItemView = convertView;
        if (playlistItemView == null) {
            playlistItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.playlist_item, parent, false);
        }

        final Music currentMusic = getItem(position);

        ImageView albumIcon = (ImageView) playlistItemView.findViewById(R.id.album_icon);
        albumIcon.setImageResource(currentMusic.getAlbum());

        TextView songTextView = (TextView) playlistItemView.findViewById(R.id.song_text_view);
        songTextView.setText(currentMusic.getSong());

        TextView artistTextView = (TextView) playlistItemView.findViewById(R.id.artist_text_view);
        artistTextView.setText(currentMusic.getArtist());

        return playlistItemView;
    }
}
