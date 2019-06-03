package com.barbosa.gabriel.optform.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class UET implements Parcelable {

    @SerializedName("Id")
    private String id;
    @SerializedName("Name")
    private String name;

    private UET(Parcel in) {
        id = in.readString();
        name = in.readString();
    }

    public static final Creator<UET> CREATOR = new Creator<UET>() {
        @Override
        public UET createFromParcel(Parcel in) {
            return new UET(in);
        }

        @Override
        public UET[] newArray(int size) {
            return new UET[size];
        }
    };

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
