package com.example.bridge.sqlitewithrecylerview;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by bridgelabz5 on 17/2/16.
 */
public class AlbumDetails {

    public AlbumDetails(){

    }

    public static class AlbumEntry{
        public static final String TABLE_NAME = "album_details";
        public static final String USER_ID = "userId";
        public static final String ID = "id";
        public static final String TITLE = "title";

    }
}
