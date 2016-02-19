package com.example.bridge.sqlitewithrecylerview;

/**
 * Created by bridgelabz5 on 18/2/16.
 */
public class Album {

    private String userId;
    private String Id;
    private String title;

    public Album(String userId1,String Id1,String title1){
        this.setUserId(userId1);
        this.setId(Id1);
        this.setTitle(title1);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
