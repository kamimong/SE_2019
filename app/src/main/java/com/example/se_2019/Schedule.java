package com.example.se_2019;

import android.os.Parcel;
import android.os.Parcelable;


public class Schedule implements Parcelable{

    private String name;
    private String date;
    private String title;
    private String content;



    public Schedule(String name, String date, String title, String content){
        this.name = name;
        this.date = date;
        this.title = title;
        this.content = content;
    }

    protected Schedule(Parcel in){
        name = in.readString();
        date = in.readString();
        title = in.readString();
        content = in.readString();
    }



    public static final Parcelable.Creator<Schedule> CREATOR = new Parcelable.Creator<Schedule>() {
        @Override
        public Schedule createFromParcel(Parcel in) {
            return new Schedule(in);
        }

        @Override
        public Schedule[] newArray(int size) {
            return new Schedule[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(date);
        dest.writeString(title);
        dest.writeString(content);
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }




}
