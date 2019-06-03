package com.barbosa.gabriel.optform.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Operator implements Parcelable {

    public static final Creator<Operator> CREATOR = new Creator<Operator>() {
        @Override
        public Operator createFromParcel(Parcel in) {
            return new Operator(in);
        }

        @Override
        public Operator[] newArray(int size) {
            return new Operator[size];
        }
    };
    @SerializedName("Id")
    private String id;
    @SerializedName("Name")
    private String name;

    private Operator(Parcel in) {
        id = in.readString();
        name = in.readString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
    }
}
