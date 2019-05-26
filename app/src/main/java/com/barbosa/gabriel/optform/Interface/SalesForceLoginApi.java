package com.barbosa.gabriel.optform.Interface;

import com.barbosa.gabriel.optform.model.Session;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface SalesForceLoginApi {
    String loginUrl = "https://login.salesforce.com/services/oauth2/";

    @FormUrlEncoded
    @POST("token")
    Call<Session> login(@Field("grant_type") String grantType, @Field("client_id") String clientId, @Field("client_secret") String clientSecret, @Field("username") String username, @Field("password") String password);


}
