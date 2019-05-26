
package com.barbosa.gabriel.optform.models;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Supervisor {

    @SerializedName("Id")
    private String mId;
    @SerializedName("Name")
    private String mName;
    @SerializedName("Turno__c")
    private String mTurnoC;
    @SerializedName("UET__c")
    private String mUETC;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getTurnoC() {
        return mTurnoC;
    }

    public void setTurnoC(String turnoC) {
        mTurnoC = turnoC;
    }

    public String getUETC() {
        return mUETC;
    }

    public void setUETC(String uETC) {
        mUETC = uETC;
    }

}
