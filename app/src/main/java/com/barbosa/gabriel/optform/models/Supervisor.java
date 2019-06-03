package com.barbosa.gabriel.optform.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Supervisor implements Parcelable {

    @SerializedName("Id")
    private String id;
    @SerializedName("Name")
    private String name;
    @SerializedName("Turno__c")
    private String turno;
    @SerializedName("UET__r")
    private UET uET;

    private Supervisor(Parcel in) {
        id = in.readString();
        name = in.readString();
        turno = in.readString();
        uET = in.readParcelable(UET.class.getClassLoader());
    }

    public static final Creator<Supervisor> CREATOR = new Creator<Supervisor>() {
        @Override
        public Supervisor createFromParcel(Parcel in) {
            return new Supervisor(in);
        }

        @Override
        public Supervisor[] newArray(int size) {
            return new Supervisor[size];
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

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public UET getUET() {
        return uET;
    }

    public void setUET(UET uETR) {
        this.uET = uETR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(turno);
        dest.writeParcelable(uET, 0);
    }
}
