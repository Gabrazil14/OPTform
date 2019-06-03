package com.barbosa.gabriel.optform.interfaces;

import com.barbosa.gabriel.optform.models.OPT;
import com.barbosa.gabriel.optform.models.Operator;
import com.barbosa.gabriel.optform.models.Post;
import com.barbosa.gabriel.optform.models.Questions;
import com.barbosa.gabriel.optform.models.Supervisor;

import java.util.ArrayList;

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
    Call<Post> getPost(@Header("Authorization") String token, @Path("uETId") String uETId);

    @GET("services/apexrest/Operadores/{supervisorId}")
    Call<ArrayList<Operator>> getOperators(@Header("Authorization") String token, @Path("supervisorId") String supervisorId);

    @GET("services/apexrest/Perguntas")
    Call<Questions> getQuestions(@Header("Authorization") String token);

    @POST("services/apexrest/OPT")
    Call<OPT> sendOPT(@Header("Authorization") String token, @Body OPT opt);
}
