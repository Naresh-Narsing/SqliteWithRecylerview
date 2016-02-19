package com.example.bridge.sqlitewithrecylerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by bridgelabz5 on 18/2/16.
 */
public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.RecylerViewHolder> {

    ArrayList<Album> arrayList = new ArrayList<>();

    recyclerAdapter(ArrayList<Album> arrayList){
        this.arrayList = arrayList;
    }

    @Override
    public RecylerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        RecylerViewHolder recylerViewHolder = new RecylerViewHolder(view);
        return recylerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecylerViewHolder holder, int position) {

        Album album = arrayList.get(position);
        holder.userid.setText(album.getUserId());
        holder.id.setText(album.getId());
        holder.title.setText(album.getTitle());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class RecylerViewHolder extends RecyclerView.ViewHolder{

        TextView userid,id,title;
        RecylerViewHolder(View view){
            super(view);
            userid = (TextView) view.findViewById(R.id.userid);
            id = (TextView) view.findViewById(R.id.id);
            title = (TextView) view.findViewById(R.id.title);
        }
    }
}
