package com.meetApp.meetappandroid.domain;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Message  implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo
    private String text;
    @ColumnInfo
    private String date;
    @ColumnInfo
    private boolean favourite;
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    private byte[] image;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Message(long id, String text, String date, boolean favourite, byte[] image) {
        this.id = id;
        this.text = text;
        this.date = date;
        this.favourite = favourite;
        this.image = image;
    }

    @Override
    public String toString() {
        return "\n" + text + "\n" + "\n"  + date +"\n"  ;
    }
}
