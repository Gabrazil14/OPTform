package com.barbosa.gabriel.optform.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Session {

    @SerializedName("access_token")
    private String accessToken;
    @SerializedName("instance_url")
    private String instanceUrl;

    public Session(String accessToken, String instanceUrl) {
        this.accessToken = "Bearer " + accessToken;
        this.instanceUrl = instanceUrl;
    }

    public boolean isValid() {
        return !accessToken.isEmpty() && !instanceUrl.isEmpty();
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getInstanceUrl() {
        return instanceUrl;
    }

    public void setInstanceUrl(String instanceUrl) {
        this.instanceUrl = instanceUrl;
    }

}
