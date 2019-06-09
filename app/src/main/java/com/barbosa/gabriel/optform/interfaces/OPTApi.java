package com.barbosa.gabriel.optform.interfaces;

import com.barbosa.gabriel.optform.models.OPT;
import com.barbosa.gabriel.optform.models.Operator;
import com.barbosa.gabriel.optform.models.Post;
import com.barbosa.gabriel.optform.models.Questions;
import com.barbosa.gabriel.optform.models.Supervisor;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface OPTApi {
    @GET("services/apexrest/Supervisor")
    Call<Supervisor> getSupervisor(@Header("Authorization") String token);

    @GET("services/apexrest/Posto/{uETId}")
    Call<ArrayList<Post>> getPost(@Header("Authorization") String token, @Path("uETId") String uETId);

    @GET("services/apexrest/Operadores/{supervisorId}")
    Call<ArrayList<Operator>> getOperators(@Header("Authorization") String token, @Path("supervisorId") String supervisorId);

    @GET("services/apexrest/Perguntas")
    Call<Questions> getQuestions(@Header("Authorization") String token);

    @POST("services/data/v36.0/sobjects/OPT__c")
    Call<OPT> sendOPT(@Header("Authorization") String token, @Body OPT opt);

    @GET("services/apexrest/OPT/{supervisorId}")
    Call<List<OPT>> getOPTs(@Header("Authorization") String token, @Path("supervisorId") String supervisorId);
}
