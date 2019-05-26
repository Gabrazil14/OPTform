package com.barbosa.gabriel.optform.interfaces;

import com.barbosa.gabriel.optform.models.Session;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface SalesForceLoginApi {
    String LOGIN_URL = "https://login.salesforce.com";
    String CLIENT_ID = "3MVG9ZF4bs_.MKug78PunwIbV3anh9yu_vTv6ifsF0L2GJTTpAA1qBdWRQ3I8aHZYDqVfAo_xOl7MK8Is27Ho";
    String CLIENT_SECRET = "CF0025345F3A6B3FB2A8254426B931BAF560C20C82FEA8407353DE54A614F4EA";

    @FormUrlEncoded
    @POST("/services/oauth2/token")
    Call<Session> login(@Field("grant_type") String grantType, @Field("client_id") String clientId, @Field("client_secret") String clientSecret, @Field("username") String username, @Field("password") String password);

    @FormUrlEncoded
    @POST("/services/oauth2/token")
    Call<Session> refreshToken(@Field("grant_type") String grantType, @Field("client_id") String clientId, @Field("client_secret") String clientSecret, @Field("refresh_token") String invalidToken);

}
