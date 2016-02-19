package com.example.bridge.sqlitewithrecylerview;

import android.app.ProgressDialog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by bridgelabz5 on 17/2/16.
 */
public class BackgroundTask extends AsyncTask<Void,Void,Void> {

    ProgressDialog progressDialog;
    Context ctx;

    String json_url = "http://jsonplaceholder.typicode.com/albums";

    public BackgroundTask(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    protected void onPreExecute() {
        progressDialog = new ProgressDialog(ctx);
        progressDialog.setIndeterminate(true);
        progressDialog.setTitle("PLEASE WAIT...");
        progressDialog.setMessage("DOWNLOAD IN PROGRESS");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    protected Void doInBackground(Void... params) {

//        try {
//            URL url = new URL(json_url);
//            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//            InputStream inputStream = httpURLConnection.getInputStream();
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//            StringBuilder stringBuilder = new StringBuilder();
//            String line;
//
//            while ((line=bufferedReader.readLine())!=null)
//            {
//                stringBuilder.append(line+ " \n");
//                //Thread.sleep(500);
//            }

//            httpURLConnection.disconnect();
//            String json_data = stringBuilder.toString();

        JsonParser json_data = new JsonParser();

        //JSONObject jsonObject = new JSONObject(json_data);
        // JSONArray jsonArray = jsonObject.getJSONArray("");

        JSONArray jsonArray = json_data.getJSONFromUrl(json_url);


        AlbumDbHelper albumDbHelper = new AlbumDbHelper(ctx);
        SQLiteDatabase db = albumDbHelper.getWritableDatabase();

        int count = 0;

        while (count<jsonArray.length()){
            try {
                JSONObject c = jsonArray.getJSONObject(count);
                count++;
                String userid1 = c.getString("userId");
                String id = c.getString("id");
                String title = c.getString("title");


                albumDbHelper.putInformation(userid1,id,title,db);


            } catch (JSONException e) {
                e.printStackTrace();
            }



//            JSONArray jsonArray = jsonObject.getJSONArray("[");

//            AlbumDbHelper albumDbHelper = new AlbumDbHelper(ctx);
//            SQLiteDatabase db = albumDbHelper.getWritableDatabase();


//            int count = 0;
//            while (count<jsonArray.length()){
//
//                JSONObject jsonObject1 = jsonArray.getJSONObject(count);
//                count++;
//
//                albumDbHelper.putInformation(jsonObject1.getString("userId"),jsonObject1.getString("id"),
//                        jsonObject1.getString("title"),db);
//
//            }
//



//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (JSONException e) {
//            e.printStackTrace();
////        } catch (InterruptedException e) {
////            e.printStackTrace();
//        }
        }
        albumDbHelper.close();
        return null;
        }

        @Override
        protected void onProgressUpdate (Void...values){
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute (Void aVoid){
            progressDialog.dismiss();
        }
    }
