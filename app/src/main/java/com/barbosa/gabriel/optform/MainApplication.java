package com.barbosa.gabriel.optform;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.barbosa.gabriel.optform.model.Session;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainApplication extends Application {
    private static Retrofit retrofit;
    private static Session currentSession;
    private static SharedPreferences sharedpreferences;
    private static SharedPreferences.Editor editor;

    public static Retrofit getRetrofit(String url) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(url)
                    .build();
        }
        return retrofit;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sharedpreferences = getSharedPreferences("Login", Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();
    }

    public Session getSession() {
        if (currentSession == null) {
            String token = sharedpreferences.getString("token", "");
            String url = sharedpreferences.getString("instance_url", "");
            currentSession = new Session(token, url);
        }
        return currentSession;
    }

    public void saveSession(Session session) {
        currentSession = session;
        editor.putString("instance_url", session.getInstanceUrl());
        editor.putString("token", session.getAccessToken());
        editor.apply();
        editor.commit();
    }

}
