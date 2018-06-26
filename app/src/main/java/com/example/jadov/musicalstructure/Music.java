package com.example.jadov.musicalstructure;
// This is the Java file for creating the Music structure of each music file

import android.os.Parcel;
import android.os.Parcelable;

public class Music implements Parcelable {

    // Declare variables
    private int mAlbum;
    private String mSong;
    private String mArtist;

    // Main constructor for creating a Music object
    public Music(int mAlbum, String mSong, String mArtist) {
        this.mAlbum = mAlbum;
        this.mSong = mSong;
        this.mArtist = mArtist;
    }

    // Get the album name
    public int getAlbum() {
        return mAlbum;
    }

    // Get the song name
    public String getSong() {
        return mSong;
    }

    // Get the artist name
    public String getArtist() {
        return mArtist;
    }

    // Write object values to parcel for storage
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mAlbum);
        dest.writeString(mSong);
        dest.writeString(mArtist);
    }

    // Constructor used for parcel
    public Music(Parcel parcel) {
        mAlbum = parcel.readInt();
        mSong = parcel.readString();
        mArtist = parcel.readString();
    }

    // Creator - used when un-parceling our parcel (creating the object)
    public static final Creator<Music> CREATOR = new Creator<Music>() {

        @Override
        public Music createFromParcel(Parcel parcel) {
            return new Music(parcel);
        }

        @Override
        public Music[] newArray(int size) {
            return new Music[0];
        }
    };

    // Return hashcode of object
    @Override
    public int describeContents() {
        return hashCode();
    }

}
