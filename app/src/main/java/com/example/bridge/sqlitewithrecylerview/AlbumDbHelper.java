package com.example.bridge.sqlitewithrecylerview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by bridgelabz5 on 17/2/16.
 */
public class AlbumDbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "album_db";
    public static final int DB_VERSION = 1;
    public static final String CREATE_QUERY = "create table "+AlbumDetails.AlbumEntry.TABLE_NAME +
            "("+AlbumDetails.AlbumEntry.USER_ID +" text,"+ AlbumDetails.AlbumEntry.ID+" text,"+
            AlbumDetails.AlbumEntry.TITLE+" text);";

    public static final String DROP_QUERY = "drop table if exists "+ AlbumDetails.AlbumEntry.TABLE_NAME+";";

    public AlbumDbHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
        Log.d("DATABASE OPERATION","DATABASE CREATED...");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_QUERY);
        Log.d("DATABASE OPERATION", "TABLE CREATED...");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(DROP_QUERY);
        Log.d("DATABASE OPERATION", "DATABASE UPDATED...");
    }

    public void putInformation(String userId, String id, String title, SQLiteDatabase db){
        Log.d("INSIDE","INSIDE");
        ContentValues contentValues = new ContentValues();
        Log.d("INSIDE","INSIDE");
        contentValues.put(AlbumDetails.AlbumEntry.USER_ID, userId);
        Log.d("INSIDE", "INSIDE");
        contentValues.put(AlbumDetails.AlbumEntry.ID, id);
        Log.d("INSIDE", "INSIDE");
        contentValues.put(AlbumDetails.AlbumEntry.TITLE, title);
        Log.d("INSIDE", "INSIDE");
        long l = db.insert(AlbumDetails.AlbumEntry.TABLE_NAME,null,contentValues);
        Log.d("DATABASE OPERATION","ONE ROW INSERTED");
    }

    public Cursor getInformation(SQLiteDatabase db){
        String[] projection = {AlbumDetails.AlbumEntry.USER_ID, AlbumDetails.AlbumEntry.ID,
                AlbumDetails.AlbumEntry.TITLE};
        Cursor cursor = db.query(AlbumDetails.AlbumEntry.TABLE_NAME,projection,null,null,null,null,null);
        return cursor;
    }
}
