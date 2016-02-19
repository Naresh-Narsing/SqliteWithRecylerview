package com.example.bridge.sqlitewithrecylerview;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class DisplayList extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    //RETRIEVING FROM SQLITE DB
    ArrayList<Album> arrayList = new ArrayList<>();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list);

        recyclerView = (RecyclerView) findViewById(R.id.recylerview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        AlbumDbHelper albumDbHelper = new AlbumDbHelper(this);
        SQLiteDatabase sqLiteDatabase = albumDbHelper.getReadableDatabase();

        Cursor cursor = albumDbHelper.getInformation(sqLiteDatabase);
        cursor.moveToFirst();
        do {
            Album album = new Album(cursor.getString(0),cursor.getString(1),cursor.getString(2));
            arrayList.add(album);

        }while (cursor.moveToNext());
        albumDbHelper.close();

        adapter = new recyclerAdapter(arrayList);
        recyclerView.setAdapter(adapter);

    }
}
