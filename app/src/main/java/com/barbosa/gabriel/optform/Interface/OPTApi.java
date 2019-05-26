package com.barbosa.gabriel.optform.Interface;

import com.barbosa.gabriel.optform.model.Supervisor;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface OPTApi {
    @GET("services/apexrest/Supervisor")
    Call<Supervisor> getSupervisor(@Header("Authorization") String token);

}
